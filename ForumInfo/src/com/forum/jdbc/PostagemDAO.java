package com.forum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.forum.beans.Postagem;

public class PostagemDAO {
	
	private Connection con= Conexao.getConnection();
	
	// INSERIR Postagem 
	public void cadPostagem (Postagem post){
		
		String sql= "INSERT INTO POSTAGEM (texto1p, fkref, fkcod) VALUES (?, ?, ?)";
		try {
			PreparedStatement preparador= con.prepareStatement(sql);
			preparador.setString(1, post.getTexto1p());
			preparador.setInt(2, post.getFkref());
			preparador.setInt(3, post.getFkcod());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cadastrado Post com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("ERRO - "+ e.getMessage());
		}
		
	}
	
	// ALTERAR Postagem 
	public void altera (Postagem posti){
			
			String sql= "UPDATE POSTAGEM SET TEXTO1P= ? , FKREF= ? , FKCOD= ? WHERE ID= ?";
			try {
				PreparedStatement preparador= con.prepareStatement(sql);
				preparador.setString(1, posti.getTexto1p());
				preparador.setInt(2, posti.getFkref());
				preparador.setInt(3, posti.getFkcod());
				preparador.setInt(4, posti.getId());
				
				preparador.execute();
				preparador.close();
				
				System.out.println("Alterado Post com sucesso!");
				
			} catch (SQLException e) {
				System.out.println("ERRO - "+ e.getMessage());
			}
			
		}
	
		// DELETE FROM Postagem WHERE Id= ?
		public void deleta (Postagem post){
			
			String sql= "DELETE FROM POSTAGEM WHERE ID= ?";
			try {
				PreparedStatement preparador= con.prepareStatement(sql);
				preparador.setInt(1, post.getId());
				
				preparador.execute();
				preparador.close();
				
				System.out.println("Deletado Post com sucesso!");
				
			} catch (SQLException e) {
				System.out.println("ERRO - "+ e.getMessage());
			}
		
	   }
		
		// BUSCAR TODOS //Postagem 
		public List<Postagem> buscarTodos(){
			
			String sql= "SELECT * FROM POSTAGEM";
			List<Postagem> lista= new ArrayList<Postagem>();
			try {
				PreparedStatement preparador= con.prepareStatement(sql);
				ResultSet resultados = preparador.executeQuery();
				while (resultados.next()){
					Postagem posti = new Postagem();
					posti.setId(resultados.getInt("id"));
					posti.setTexto1p(resultados.getString("texto1p"));
					posti.setFkref(resultados.getInt("fkref"));
					posti.setFkcod(resultados.getInt("fkcod"));
					lista.add(posti);
					
				}
								
			} catch (SQLException e) {
				System.out.println("ERRO - "+ e.getMessage());
			} return lista;
		
	   }
		
		// BUSCAR TODOS Geral P  // Postagem 
				public List<Postagem> buscarTodosGeralP(){
					
					String sql= "SELECT  DISTINCT POSTAGEM.*, TEMA.*, USUARIO.*"
							+ " FROM POSTAGEM"
							+ " INNER JOIN TEMA ON (postagem.fkref = tema.ref)"
							+ " INNER JOIN USUARIO ON (postagem.fkcod = usuario.cod)";
							
																			
					List<Postagem> listaP= new ArrayList<Postagem>();
					try {
						PreparedStatement preparador= con.prepareStatement(sql);
						ResultSet resultados = preparador.executeQuery();
						while (resultados.next()){
							Postagem posti = new Postagem();
							posti.setId(resultados.getInt("id"));
							posti.setTexto1p(resultados.getString("texto1p"));
							posti.setFkref(resultados.getInt("fkref"));
							posti.setFkcod(resultados.getInt("fkcod"));
							listaP.add(posti);
						}
										
				} catch (SQLException e) {
					System.out.println("ERRO - "+ e.getMessage());
					
				}
				
				return listaP;
			
		   }
				
					
		
		// BUSCAR POR Idt 
				public Postagem buscarPostagemId(Integer idt){
					Postagem postRetorno= null;
					String sql= "SELECT * FROM POSTAGEM WHERE ID= ?";
					/*List<Postagem> lista= new ArrayList<Postagem>();*/
					
					try {
						PreparedStatement preparador= con.prepareStatement(sql);
						preparador.setInt(1,  idt);
						//resultado da consulta
						ResultSet resultado = preparador.executeQuery();
						//se tem registro
						if (resultado.next()){
							postRetorno = new Postagem();
							postRetorno.setId(resultado.getInt("id"));
							postRetorno.setTexto1p(resultado.getString("texto1p"));
							postRetorno.setFkref(resultado.getInt("fkref"));
							postRetorno.setFkcod(resultado.getInt("fkcod"));
						}
						System.out.println("Encontrado Post com sucesso!");
										
					} catch (SQLException e) {
						System.out.println("ERRO - "+ e.getMessage());
					} 
					return postRetorno;
	    	   }
				
				
			// BUSCAR Postagem POR TERMO - 
				public List<Postagem> buscaPostagemTermo(String termo){
			
				//Postagem postagem = null;
				String sql= "SELECT * FROM POSTAGEM WHERE TEXTO1P LIKE  ? ";
				List<Postagem> listaPosts= new ArrayList<Postagem>();
				String t= '%'+termo+'%';
				
				try {
					PreparedStatement preparador= con.prepareStatement(sql);
					preparador.setString(1, t);
										
					//resultado da consulta
					ResultSet resultados = preparador.executeQuery();
					
					//Enquanto encontrar termo prepara lista posts
					while (resultados.next()){
						Postagem posti = new Postagem();
						posti.setId(resultados.getInt("id"));
						posti.setTexto1p(resultados.getString("texto1p"));
						posti.setFkref(resultados.getInt("fkref"));
						posti.setFkcod(resultados.getInt("fkcod"));
						listaPosts.add(posti);
					}
					System.out.println("Encontrado com sucesso!");
											
				} catch (SQLException e) {
					System.out.println("ERRO - "+ e.getMessage());
				} 
				return listaPosts;
    	   }	

								
		/*// BUSCAR Postagem POR EMAIL - AUTENTICANDO
		public Usuario autenticaUsuarioEmail(Usuario usuario){
			Usuario usuAutent= null;
			String sql= "SELECT * FROM USUARIO WHERE EMAIL= ? AND SENHA= ?";
			
			try {
				PreparedStatement preparador= con.prepareStatement(sql);
				preparador.setString(1, usuario.getEmail());
				preparador.setString(2, usuario.getSenha());
				
				//resultado da consulta
				ResultSet resultado = preparador.executeQuery();
				
				//se tem registro
				if (resultado.next()){
					usuAutent = new Usuario();
					usuAutent.setCod(resultado.getInt("cod"));
					usuAutent.setNome(resultado.getString("nome"));
					usuAutent.setEmail(resultado.getString("email"));
					usuAutent.setSenha(resultado.getString("senha"));
				}
				System.out.println("Encontrado com sucesso!");
								
			} catch (SQLException e) {
				System.out.println("ERRO - "+ e.getMessage());
			} 
			return usuAutent;
	   }	*/
				
				
}
