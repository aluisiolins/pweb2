package com.forum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.beans.Comentario;
import com.forum.beans.Postagem;
import com.forum.beans.Tema;
import com.forum.beans.Usuario;
import com.forum.jdbc.TemaDAO;
import com.forum.jdbc.UsuarioDAO;
import com.forum.jdbc.ComentarioDAO;
import com.forum.jdbc.PostagemDAO;


/**
 * Servlet implementation class TemaControlServ
 */
@WebServlet("/relatoriogeralcontrolserv")
public class RelatorioGeralControlServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioGeralControlServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String acao= request.getParameter("acao");
		TemaDAO temaDao= new TemaDAO();
		UsuarioDAO usuDao= new UsuarioDAO();
		PostagemDAO postDao= new PostagemDAO();
		ComentarioDAO comenDao= new ComentarioDAO();
		
		if(acao != null && acao.equals("lisT") || acao.equals("lisU") || acao.equals("lisP")){
			List<Tema> listaTempT= temaDao.buscarTodosGeralT();
			List<Usuario> listaTempU= usuDao.buscarTodosGeralU();
			List<Postagem> listaTempP= postDao.buscarTodosGeralP();
			List<Comentario> listaTempC= comenDao.buscarTodos();
			request.setAttribute("listaT", listaTempT);
			request.setAttribute("listaU", listaTempU);
			request.setAttribute("listaP", listaTempP);
			request.setAttribute("lista", listaTempC);
			RequestDispatcher saida= request.getRequestDispatcher("listaPostagemGeral2.jsp");
			RequestDispatcher saida2= request.getRequestDispatcher("listaPostagemGeral2.jsp");
			RequestDispatcher saida3= request.getRequestDispatcher("listaPostagemGeral2.jsp");
			RequestDispatcher saida4= request.getRequestDispatcher("listaPostagemGeral2.jsp");
			saida.forward(request, response);
			saida2.forward(request, response);
			saida3.forward(request, response);
			saida4.forward(request, response);
			} 
		
	}

}
