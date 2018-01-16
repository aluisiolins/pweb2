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

import com.forum.beans.Postagem;
import com.forum.jdbc.PostagemDAO;


/**
 * Servlet implementation class UsuarioControlServ
 */
@WebServlet("/postagemcontrolserv")
public class PostagemControlServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostagemControlServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Postagem post= new Postagem();
	
		String acao= request.getParameter("acao");
		PostagemDAO postDao= new PostagemDAO();
		
		if(acao != null && acao.equals("listar")){
		List<Postagem> listaTemp= postDao.buscarTodos();
		request.setAttribute("lista", listaTemp);
		RequestDispatcher saida= request.getRequestDispatcher("listaPostagem.jsp");
		saida.forward(request, response);
		} else if(acao != null && acao.equals ("lisT")|| acao.equals("lisU") || acao.equals("lisP")){
			List<Postagem> listaTempP= postDao.buscarTodosGeralP();
			request.setAttribute("listaP", listaTempP);
			RequestDispatcher saida= request.getRequestDispatcher("listaPostagemGeral.jsp");
			saida.forward(request, response);
			} 
		else if(acao != null && acao.equals("del")){
			String idt= request.getParameter("codi");
			post.setId(Integer.parseInt(idt));
			postDao.deleta(post);
			
		response.sendRedirect("postagemcontrolserv?acao=listar");
			
		}
		else if(acao != null && acao.equals("alt")){
			String codi= request.getParameter("codi");
			Postagem postAlt= postDao.buscarPostagemId(Integer.parseInt(codi));
			request.setAttribute("postagem", postAlt);
			request.getRequestDispatcher("alterarPostagem.jsp").forward(request, response);
			
		}
		else if(acao != null && acao.equals("cad")){
			RequestDispatcher saida= request.getRequestDispatcher("cadPostagem.jsp");
			saida.forward(request, response);
			} 
		
		else if(acao != null && acao.equals("listarTermo")){ ///////busca por termo
			String termo= request.getParameter("termo");
			List<Postagem> listaTermo= postDao.buscaPostagemTermo(termo);
			request.setAttribute("listaTermo", listaTermo);
			RequestDispatcher saida= request.getRequestDispatcher("listaBuscaPostagemTermo.jsp");
			saida.forward(request, response);
			} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//	Pegando dados form alteracao
		String sidt= request.getParameter("id");
		String stexto1p= request.getParameter("texto1p");
		String sfkref= request.getParameter("fkref");
		String sfkcod= request.getParameter("fkcod");
		
		// criando obj Postagem e atribuindo valores na tela
		Postagem posti= new Postagem();
		
		posti.setTexto1p(stexto1p);
		posti.setFkref(Integer.parseInt(sfkref));
		posti.setFkcod(Integer.parseInt(sfkcod));
		posti.setId(Integer.parseInt(sidt));
		
		// criando usuarioDAO 	
		PostagemDAO postDao= new PostagemDAO();
		
		//salvar banco
		postDao.altera(posti);
		
		PrintWriter out= response.getWriter();
		out.println("Salve com sucesso!");
		
		response.sendRedirect("postagemcontrolserv?acao=listar");
		
	}

	

}
