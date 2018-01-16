<%@page import="com.forum.jdbc.PostagemDAO"%>
<%@page import="com.forum.beans.Postagem"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página - Salvar Postagem</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Página - Salvar Postagem</h1>
	<%
		String stexto1p = request.getParameter("texto1p");
		String sfkref = request.getParameter("fkref");
		String sfkcod = request.getParameter("fkcod");
		
		Postagem post = new Postagem();
		post.setTexto1p(stexto1p);
		post.setFkref(Integer.parseInt(sfkref));
		post.setFkcod(Integer.parseInt(sfkcod));
		
		PostagemDAO postDao = new PostagemDAO();
		postDao.cadPostagem(post);
	%>
	
	<h1>Salvo Postagem com sucesso!</h1>

</body>
</html>