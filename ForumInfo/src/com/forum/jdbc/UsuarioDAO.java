package com.forum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;*/

import com.forum.beans.Usuario;

public class UsuarioDAO {
	
	private Connection con= Conexao.getConnection();
	
	// INSERIR USUARIO 
	public void cadastro (Usuario usu){
		
		String sql= "INSERT INTO USUARIO (nome, email, senha) VALUES (?, ?, ?)";
		try {
			PreparedStatement preparador= con.prepareStatement(sql);
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getEmail());
			preparador.setString(3, usu.getSenha());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cadastrado com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("ERRO - "+ e.getMessage());
			
			/*String msgErro= null;
			msgErro="Erro de cadastro (email duplicado ou dados inválidos"+e.getMessage();*/
		}
		
	}
	
	// ALTERAR USUARIO 
	public void altera (Usuario usu){
			
			String sql= "UPDATE USUARIO SET NOME= ? , EMAIL= ? , SENHA= ? WHERE COD= ?";
			try {
				PreparedStatement preparador= con.prepareStatement(sql);
				preparador.setString(1, usu.getNome());
				preparador.setString(2, usu.getEmail());
				preparador.setString(3, usu.getSenha());
				preparador.setInt(4, usu.getCod());
				
				preparador.execute();
				preparador.close();
				
				System.out.println("Alterado com sucesso!");
				
			} catch (SQLException e) {
				System.out.println("ERRO - "+ e.getMessage());
			}
			
		}
	
		// DELETE FROM USUARIO WHERE COD= ?
		public void deleta (Usuario usu){
			
			String sql= "DELETE FROM USUARIO WHERE COD= ?";
			try {
				PreparedStatement preparador= con.prepareStatement(sql);
				preparador.setInt(1, usu.getCod());
				
				preparador.execute();
				preparador.close();
				
				System.out.println("Deletado com sucesso!");
				
			} catch (SQLException e) {
				System.out.println("ERRO - "+ e.getMessage());
			}
		
	   }
		
		// BUSCAR TODOS //Usuario usuario
		public List<Usuario> buscarTodos(){
			
			String sql= "SELECT * FROM USUARIO";
			List<Usuario> lista= new ArrayList<Usuario>();
			try {
				PreparedStatement preparador= con.prepareStatement(sql);
				ResultSet resultados = preparador.executeQuery();
				while (resultados.next()){
					Usuario usu = new Usuario();
					usu.setCod(resultados.getInt("cod"));
					usu.setNome(resultados.getString("nome"));
					usu.setEmail(resultados.getString("email"));
					usu.setSenha(resultados.getString("senha"));
					lista.add(usu);
					
				}
								
			} catch (SQLException e) {
				System.out.println("ERRO - "+ e.getMessage());
			} return lista;
		
	   }
		
		
		// BUSCAR TODOS Geral U  // Usuario 
		public List<Usuario> buscarTodosGeralU(){
			
			String sql= "SELECT  DISTINCT POSTAGEM.*, TEMA.*, USUARIO.*"
					+ " FROM POSTAGEM"
					+ " INNER JOIN TEMA ON (postagem.fkref = tema.ref)"
					+ " INNER JOIN USUARIO ON (postagem.fkcod = usuario.cod)";
		
			List<Usuario> listaU= new ArrayList<Usuario>();
			
			try {
				PreparedStatement preparador= con.prepareStatement(sql);
				ResultSet resultados = preparador.executeQuery();
				
				while (resultados.next()){
					Usuario usu = new Usuario();
					usu.setCod(resultados.getInt("cod"));
					usu.setNome(resultados.getString("nome"));
					listaU.add(usu);									
				}
								
			} catch (SQLException e) {
				System.out.println("ERRO - "+ e.getMessage());
				
			}
			return listaU;
	   }		
		
		
		
		
		// BUSCAR POR CODIGO 
				public Usuario buscarUsuarioCodigo(Integer codigo){
					Usuario usuRetorno= null;
					String sql= "SELECT * FROM USUARIO WHERE COD= ?";
					
					try {
						PreparedStatement preparador= con.prepareStatement(sql);
						preparador.setInt(1,  codigo);
						//resultado da consulta
						ResultSet resultado = preparador.executeQuery();
						//se tem registro
						if (resultado.next()){
							usuRetorno = new Usuario();
							usuRetorno.setCod(resultado.getInt("cod"));
							usuRetorno.setNome(resultado.getString("nome"));
							usuRetorno.setEmail(resultado.getString("email"));
							usuRetorno.setSenha(resultado.getString("senha"));
						}
						System.out.println("Encontrado com sucesso!");
										
					} catch (SQLException e) {
						System.out.println("ERRO - "+ e.getMessage());
					} 
					return usuRetorno;
	    	   }
				
				
			// BUSCAR USUARIO POR EMAIL - AUTENTICANDO
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
    	   }	

}
