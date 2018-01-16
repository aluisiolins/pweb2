<%@page import="com.forum.beans.Postagem"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Postagem</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Página - Alterar Postagens</h1>
	
	<%
		Postagem posti= (Postagem)request.getAttribute("postagem");
	%>

	<form action="postagemcontrolserv" method="post">
	
		<input type="hidden" name="acao" value="salvar">
	
		
		<label> Idt: </label>
		<input type="text" name="id" value="<%=posti.getId()%>">  
		<label> Texto Post: </label>
		<input type="text" size="100" name="texto1p" value="<%=posti.getTexto1p()%>"><br><br>
		<label> FkRef: </label>
		<input type="text" name="fkref" value="<%=posti.getFkref()%>">
		<label> FkCod: </label>
		<input type="text" name="fkcod" value="<%=posti.getFkcod()%>"><br><br>
		
		<br><input type="submit" value="Alterar Postagem">
	
	</form>
</body>
</html>