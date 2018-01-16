<%@page import="com.forum.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Postagem</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Página - Cadastro de Postagem</h1>
	
<%
	String sref_tema = request.getParameter("refe");
		
	Usuario usuAutenticado = (Usuario)session.getAttribute("usuAut");
	int icod_usu= usuAutenticado.getCod();
	
%>	

	<form action="salvaCadPostagem.jsp" method="post">
	
		<label> Texto do Post: </label>
		<input size="100" type="text" name="texto1p"><br><br>
		<label> FkRef: </label>
		<input type="text" name="fkref" value="<%=sref_tema %>">
		<label> FkCod: </label>
		<input type="text" name="fkcod" value="<%=icod_usu %>"><br><br>
		
		<br><input type="submit" value="Cadastrar Post">
	
	</form>
</body>
</html>