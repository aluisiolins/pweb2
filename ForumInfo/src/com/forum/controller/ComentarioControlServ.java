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

import com.forum.beans.Comentario;
import com.forum.jdbc.ComentarioDAO;



/**
 * Servlet implementation class UsuarioControlServ
 */
@WebServlet("/comentariocontrolserv")
public class ComentarioControlServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComentarioControlServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Comentario comen= new Comentario();
	
		String acao= request.getParameter("acao");
		ComentarioDAO comenDao= new ComentarioDAO();
		
		if(acao != null && acao.equals("listar")){
		List<Comentario> listaTemp= comenDao.buscarTodos();
		request.setAttribute("lista", listaTemp);
		RequestDispatcher saida= request.getRequestDispatcher("listaComentarios.jsp");
		saida.forward(request, response);
		} 
		else if(acao != null && acao.equals("del")){
			String nr2= request.getParameter("codi");
			comen.setNr(Integer.parseInt(nr2));
			comenDao.deleta(comen);
			
		response.sendRedirect("comentariocontrolserv?acao=listar");
			
		}
		else if(acao != null && acao.equals("alt")){
			String codi= request.getParameter("codi");
			Comentario comenAlt= comenDao.buscarComentarioNr(Integer.parseInt(codi));
			request.setAttribute("comentario", comenAlt);
			request.getRequestDispatcher("alterarComentario.jsp").forward(request, response);
			
		}
		else if(acao != null && acao.equals("cad")){
			RequestDispatcher saida= request.getRequestDispatcher("cadComentario.jsp");
			saida.forward(request, response);
			} 
		
		else if(acao != null && acao.equals("listarTermo")){ ///////busca por termo
			String termo= request.getParameter("termo");
			List<Comentario> listaTermo= comenDao.buscaComentarioTermo(termo);
			request.setAttribute("listaTermo", listaTermo);
			RequestDispatcher saida= request.getRequestDispatcher("listaBuscaComentarioTermo.jsp");
			saida.forward(request, response);
			} 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//	Pegando dados form alteracao
		String snr= request.getParameter("nr");
		String stexto2c= request.getParameter("texto2c");
		String sautor= request.getParameter("autor");
		String sdata= request.getParameter("data");
		String sfkidPost= request.getParameter("fkidPost");
				
		// criando obj Comentario e atribuindo valores na tela
		Comentario comen= new Comentario();
		comen.setNr(Integer.parseInt(snr));
		comen.setTexto2c(stexto2c);
		comen.setAutor(Integer.parseInt(sautor));
		comen.setData(sdata);
		comen.setFkidPost(Integer.parseInt(sfkidPost));	
		
		// criando usuarioDAO 	
		ComentarioDAO comenDao= new ComentarioDAO();
		
		//salvar banco
		comenDao.altera(comen);
		
		PrintWriter out= response.getWriter();
		out.println("Salvo com sucesso!");
		
		response.sendRedirect("comentariocontrolserv?acao=listar");
		
	}

	

}
