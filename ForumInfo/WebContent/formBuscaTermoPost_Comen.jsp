<%@page import="com.forum.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form de Buscas </title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h2>Página - Formulário de Buscas </h2>
	<br>
	
<%
	String sref_tema = request.getParameter("refe");
		
	Usuario usuAutenticado = (Usuario)session.getAttribute("usuAut");
	int icod_usu= usuAutenticado.getCod();
	
%>	
	<h3>Busca de Postagem por Termo: </h3>
	<form action="postagemcontrolserv" method="get">
	
		<label> Digite termo de busca: </label>
		<input size="50" type="text" name="termo">
		<input type="hidden" name="acao" value="listarTermo">
		<br><br>
		
		<input type="submit" value="Buscar Postagem por Termo">
		<br>
		<br>
		<br>
	</form>
	
	<h3>Busca de Comentário por Termo: </h3>
	<form action="comentariocontrolserv" method="get">
	
		<label> Digite termo de busca: </label>
		<input size="50" type="text" name="termo">
		<input type="hidden" name="acao" value="listarTermo">
		<br><br>
		
		<input type="submit" value="Buscar Comentario por Termo">
		<br>
		<br>
	</form>
	
	
</body>
</html>