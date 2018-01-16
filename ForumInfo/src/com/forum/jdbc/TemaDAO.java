package com.forum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.forum.beans.Tema;

public class TemaDAO {
	
	private Connection con= Conexao.getConnection();
	
			
		// BUSCAR TODOS //Temas 
		public List<Tema> buscarTodos(){
			
			String sql= "SELECT * FROM TEMA";
			List<Tema> listaTemas= new ArrayList<Tema>();
			try {
				PreparedStatement preparador= con.prepareStatement(sql);
				ResultSet resultados = preparador.executeQuery();
				while (resultados.next()){
					Tema tema = new Tema();
					tema.setRef(resultados.getInt("ref"));
					tema.setDescricao(resultados.getString("descricao"));
					listaTemas.add(tema);
					
				}
								
			} catch (SQLException e) {
				System.out.println("ERRO - "+ e.getMessage());
			} 
			return listaTemas;
		
	   }
		
		// BUSCAR TODOS Geral T   // Tema   
		public List<Tema> buscarTodosGeralT(){
			
			String sql= "SELECT DISTINCT POSTAGEM.*, TEMA.*, USUARIO.*"
					+ " FROM POSTAGEM"
					+ " INNER JOIN TEMA ON (postagem.fkref = tema.ref)"
					+ " INNER JOIN USUARIO ON (postagem.fkcod = usuario.cod)";
							
			List<Tema> listaT= new ArrayList<Tema>();
				
			try {
				PreparedStatement preparador= con.prepareStatement(sql);
				ResultSet resultados = preparador.executeQuery();
				
				while (resultados.next()){
					Tema tema = new Tema();
					tema.setRef(resultados.getInt("ref"));
					tema.setDescricao(resultados.getString("descricao"));
					listaT.add(tema);
				}
								
			} catch (SQLException e) {
				System.out.println("ERRO - "+ e.getMessage());
				
			}
			return listaT;
		
	   }

}
