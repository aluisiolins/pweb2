package com.forum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.beans.Tema;
import com.forum.jdbc.TemaDAO;


/**
 * Servlet implementation class TemaControlServ
 */
@WebServlet("/temacontrolserv")
public class TemaControlServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TemaControlServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	//	Tema tema2= new Tema();
	
		String acao= request.getParameter("acao");
		TemaDAO temaDao= new TemaDAO();
		
		if(acao != null && acao.equals("listar")){
		List<Tema> listaTemas= temaDao.buscarTodos();
		request.setAttribute("listaTema", listaTemas);
		RequestDispatcher saida= request.getRequestDispatcher("listaTemas.jsp");
		saida.forward(request, response);
		
		}  else if(acao != null && acao.equals("lisT") || acao.equals("lisU") || acao.equals("lisP")){
			List<Tema> listaTempT= temaDao.buscarTodosGeralT();
			request.setAttribute("listaT", listaTempT);
			RequestDispatcher saida= request.getRequestDispatcher("listaPostagemGeral.jsp");
			saida.forward(request, response);
			} 
		
	}

}
