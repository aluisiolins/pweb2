<%@page import="com.forum.jdbc.ComentarioDAO"%>
<%@page import="com.forum.jdbc.UsuarioDAO"%>
<%@page import="com.forum.jdbc.PostagemDAO"%>
<%@page import="com.forum.beans.Comentario"%>
<%@page import="com.forum.beans.Usuario"%>
<%@page import="com.forum.beans.Postagem"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página - Salvar Comentário</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Página - Salvar Comentário</h1>
	<%
		String stexto2c = request.getParameter("texto2c");
		String sfkidpost = request.getParameter("fkidpost");
		String sfkcodusu = request.getParameter("fkcod");
		String sdata = request.getParameter("data");
		int codi_usu= Integer.parseInt(sfkcodusu);
		int idt_post= Integer.parseInt(sfkidpost);
		
		//UsuarioDAO uDao= new UsuarioDAO();
		
		//Usuario autor_comentario= uDao.buscarUsuarioCodigo(codi_usu);
		
		//System.out.println("ponto 1!"+ autor_comentario);
						
		Comentario comen = new Comentario();
		comen.setTexto2c(stexto2c);
		comen.setAutor(codi_usu);
		//comen.setAutor(autor_comentario);
		comen.setData(sdata);
		comen.setFkidPost(Integer.parseInt(sfkidpost));
				
		ComentarioDAO comenDao = new ComentarioDAO();
		comenDao.cadComentario(comen);
				
		Postagem post= new Postagem();
		PostagemDAO postDao= new PostagemDAO();
		post= postDao.buscarPostagemId(idt_post);
		post.adicionarComentario(comen);
		postDao.altera(post);
						
		//System.out.println("ponto 2!"+ autor_comentario);
		
	%>
	
	<h1>Salvo Postagem com sucesso!</h1>

</body>
</html>