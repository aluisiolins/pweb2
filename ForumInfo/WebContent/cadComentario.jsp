<%@page import="com.forum.beans.Comentario"%>
<%@page import="com.forum.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Coment�rio</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>P�gina - Cadastro de Coment�rio</h1>
	
<%
	String sid_post = request.getParameter("ident");
	int iid_post= Integer.parseInt(sid_post); 
		
	Usuario usuAutenticado = (Usuario)session.getAttribute("usuAut");
	int icod_usu= usuAutenticado.getCod();
	String sfknome= usuAutenticado.getNome(); 
	
%>	

	<form action="salvaCadComentario.jsp" method="post">
	
		<label> Texto do Coment�rio </label>
		<input size="100" type="text" name="texto2c"><br><br>
		<label> Autor: </label>
		<input type="text" name="fkcod" value="<%=icod_usu %>">
		<input type="text" name="fknome" value="<%=sfknome %>">
		<label> Data: </label>
		<input type="text" name="data" value="00/00/2018">
		<label> FkIdPost: </label>
		<input type="text" name="fkidpost" value="<%=iid_post%>"><br><br>
		
		<br><input type="submit" value="Cadastrar Coment�rio">
	
	</form>
</body>
</html>