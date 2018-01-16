package com.forum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.forum.beans.Comentario;

public class ComentarioDAO {
	
	private Connection con= Conexao.getConnection();
	
	// INSERIR Comentario 
	public void cadComentario (Comentario comen){
		
		String sql= "INSERT INTO COMENTARIO (texto2c, autor, data, fkidpost) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement preparador= con.prepareStatement(sql);
			preparador.setString(1, comen.getTexto2c());
			preparador.setInt(2, comen.getAutor());
			//preparador.setObject(2, comen.getAutor());
			preparador.setString(3, comen.getData());
			preparador.setInt(4, comen.getFkidPost());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cadastrado Comentario com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("ERRO - "+ e.getMessage());
		}
		
	}
	
	// ALTERAR Comentario 
	public void altera (Comentario coment){
			
			String sql= "UPDATE COMENTARIO SET TEXTO2C= ?, DATA= ?  WHERE NR= ?";
			try {
				PreparedStatement preparador= con.prepareStatement(sql);
				preparador.setString(1, coment.getTexto2c());
				preparador.setString(2, coment.getData());
				preparador.setInt(3, coment.getNr());
				/*preparador.setInt(2, coment.getAutor());
				preparador.setInt(4, coment.getFkidPost());*/
				
								
				preparador.execute();
				preparador.close();
				
				System.out.println("Alterado Comentario com sucesso!");
				
			} catch (SQLException e) {
				System.out.println("ERRO - "+ e.getMessage());
			}
			
		}
	
		// DELETE FROM COMENTARIO WHERE NR= ?
		public void deleta (Comentario comen){
			
			String sql= "DELETE FROM COMENTARIO WHERE NR= ?";
			try {
				PreparedStatement preparador= con.prepareStatement(sql);
				preparador.setInt(1, comen.getNr());
				
				preparador.execute();
				preparador.close();
				
				System.out.println("Deletado Comentario com sucesso!");
				
			} catch (SQLException e) {
				System.out.println("ERRO - "+ e.getMessage());
			}
		
	   }
		
		// BUSCAR TODOS //Comentario 
		public List<Comentario> buscarTodos(){
			
			String sql= "SELECT * FROM COMENTARIO";
			List<Comentario> lista= new ArrayList<Comentario>();
			try {
				PreparedStatement preparador= con.prepareStatement(sql);
				ResultSet resultados = preparador.executeQuery();
				while (resultados.next()){
					Comentario comen = new Comentario();
					comen.setNr(resultados.getInt("nr"));
					comen.setTexto2c(resultados.getString("texto2c"));
					comen.setAutor(resultados.getInt("autor"));
					//comen.setAutor((Usuario) resultados.getObject("autor"));
					comen.setData(resultados.getString("data"));
					comen.setFkidPost(resultados.getInt("fkidPost"));
					lista.add(comen);
					
				}
								
			} catch (SQLException e) {
				System.out.println("ERRO - "+ e.getMessage());
			} return lista;
		
	   }
		
		// BUSCAR POR Nr
				public Comentario buscarComentarioNr(Integer nr){
					Comentario comenRetorno= null;
					String sql= "SELECT * FROM COMENTARIO WHERE NR= ?";
					
					try {
						PreparedStatement preparador= con.prepareStatement(sql);
						preparador.setInt(1,  nr);
						//resultado da consulta
						ResultSet resultado = preparador.executeQuery();
						//se tem registro
						if (resultado.next()){
							comenRetorno = new Comentario();
							comenRetorno.setNr(resultado.getInt("nr"));
							comenRetorno.setTexto2c(resultado.getString("texto2c"));
							comenRetorno.setAutor(resultado.getInt("autor"));
							//comenRetorno.setAutor((Usuario)resultado.getObject("autor"));
							comenRetorno.setData(resultado.getString("data"));
							comenRetorno.setFkidPost(resultado.getInt("fkidPost"));
						}
						System.out.println("Encontrado Comentario com sucesso!");
										
					} catch (SQLException e) {
						System.out.println("ERRO - "+ e.getMessage());
					} 
					return comenRetorno;
	    	   }
				
				
				// BUSCAR Comentarios POR TERMO - 
				public List<Comentario> buscaComentarioTermo(String termo){
			
				//Comentario comentario = null;
				String sql= "SELECT * FROM COMENTARIO WHERE TEXTO2C LIKE  ? ";
				List<Comentario> listaComentarios= new ArrayList<Comentario>();
				String t= '%'+termo+'%';
				
				try {
					PreparedStatement preparador= con.prepareStatement(sql);
					preparador.setString(1, t);
										
					//resultado da consulta
					ResultSet resultados = preparador.executeQuery();
					
					//Enquanto encontrar termo prepara lista posts
					while (resultados.next()){
						Comentario comen = new Comentario();
						comen.setNr(resultados.getInt("nr"));
						comen.setTexto2c(resultados.getString("texto2c"));
						comen.setAutor(resultados.getInt("autor"));
						comen.setData(resultados.getString("data"));
						comen.setFkidPost(resultados.getInt("fkidPost"));
						listaComentarios.add(comen);
					}
					System.out.println("Encontrado Comentario com sucesso!");
											
				} catch (SQLException e) {
					System.out.println("ERRO - "+ e.getMessage());
				} 
				return listaComentarios;
    	   }				
				
			
						
	}
