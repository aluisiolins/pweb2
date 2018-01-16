package com.forum.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.beans.Usuario;
import com.forum.jdbc.UsuarioDAO;

/**
 * Servlet implementation class UsuarioControlServ
 */
@WebServlet("/usuariocontrolserv")
public class UsuarioControlServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioControlServ() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		Usuario usu= new Usuario();
	
		String acao= request.getParameter("acao");
		UsuarioDAO usuDao= new UsuarioDAO();
		
		if(acao != null && acao.equals("listar")){
		List<Usuario> listaTemp= usuDao.buscarTodos();
		request.setAttribute("lista", listaTemp);
		RequestDispatcher saida= request.getRequestDispatcher("listaUsuarios.jsp");
		saida.forward(request, response);
		} 
		else if(acao != null && acao.equals("lisT") || acao.equals("lisU") || acao.equals("lisP")){
			List<Usuario> listaTempU= usuDao.buscarTodosGeralU();
			request.setAttribute("listaU", listaTempU);
			RequestDispatcher saida= request.getRequestDispatcher("listaPostagemGeral.jsp");
			saida.forward(request, response);
			} 
		else if(acao != null && acao.equals("del")){
			String codigo= request.getParameter("codi");
			usu.setCod(Integer.parseInt(codigo));
			usuDao.deleta(usu);
			
			response.sendRedirect("usuariocontrolserv?acao=listar");
			
		}
		else if(acao != null && acao.equals("alt")){
			String codigo= request.getParameter("codi");
			Usuario usuAlt= usuDao.buscarUsuarioCodigo(Integer.parseInt(codigo));
			request.setAttribute("usuario", usuAlt);
			request.getRequestDispatcher("alterarCad.jsp").forward(request, response);
			
		}
		else if(acao != null && acao.equals("cad")){
			RequestDispatcher saida= request.getRequestDispatcher("cadastro.jsp");
			saida.forward(request, response);
			} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	Pegando dados form alteracao
		String scodigo= request.getParameter("codigo");
		String snome= request.getParameter("nome");
		String semail= request.getParameter("email");
		String ssenha= request.getParameter("senha");
		
		// criando obj usuario e atribuindo valores na tela
		Usuario usu= new Usuario();
		usu.setCod(Integer.parseInt(scodigo));
		usu.setNome(snome);
		usu.setEmail(semail);
		usu.setSenha(ssenha);
		
		// criando usuarioDAO 	
		UsuarioDAO usuDao= new UsuarioDAO();
		
		//salvar banco
		usuDao.altera(usu);
		
		PrintWriter out= response.getWriter();
		out.println("Salve com sucesso!");
		
		response.sendRedirect("usuariocontrolserv?acao=listar");
		
	}

}
