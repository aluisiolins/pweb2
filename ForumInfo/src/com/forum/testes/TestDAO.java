package com.forum.testes;

import java.util.List;

import com.forum.beans.Usuario;
import com.forum.jdbc.UsuarioDAO;

public class TestDAO {

	public static void main(String[] args) {

		//testCadastro();
		//testAltera();
		//testDeleta();
		testBuscarTodos();

	}
	
	public static void testCadastro(){
		
		Usuario usu= new Usuario();
		usu.setNome("carlos");
		usu.setEmail("carlos@gmail.com");
		usu.setSenha("carlos");
		
		UsuarioDAO usuDao= new UsuarioDAO();
		usuDao.cadastro(usu);
		
	}
	
	public static void testAltera(){
			
			Usuario usu= new Usuario();
			usu.setNome("carlos bravo");
			usu.setEmail("carlosb@gmail.com");
			usu.setSenha("carlosb");
			usu.setCod(3);
			
			UsuarioDAO usuDao= new UsuarioDAO();
			usuDao.altera(usu);
			
		}
	
	public static void testDeleta(){
		
		Usuario usu= new Usuario();
		usu.setCod(3);
		
		UsuarioDAO usuDao= new UsuarioDAO();
		usuDao.deleta(usu);
		
	}
	
	public static void testBuscarTodos(){
			
			//Usuario usu= new Usuario();
			UsuarioDAO usuDao= new UsuarioDAO();
			List<Usuario> listaResultado = usuDao.buscarTodos(); //usu
			
			for(Usuario u : listaResultado){
				System.out.println("Codigo:"+ u.getCod()+ " Nome:"+ u.getNome()+ " Email:"+ u.getEmail());
			}
			
		}
	
	

}
