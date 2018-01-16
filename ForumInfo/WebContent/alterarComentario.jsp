<%@page import="com.forum.beans.Postagem"%>
<%@page import="com.forum.beans.Comentario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Comentário</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Página - Alterar Comentário</h1>
	
	<%
		Comentario comen= (Comentario)request.getAttribute("comentario");
	%>

	<form action="comentariocontrolserv" method="post">
	
		<input type="hidden" name="acao" value="salvar">
	
		
		<label> Nr: </label>
		<input type="text" readonly size="20" name="nr" value="<%=comen.getNr()%>">  
		<label> Tx Comen: </label>
		<input type="text"  size="100" name="texto2c" value="<%=comen.getTexto2c()%>"><br><br>
		<label> Cod Autor: </label>
		<input type="text" readonly name="autor" value="<%=comen.getAutor()%>">
		<label> Data: </label>
		<input type="text" name="data" value="<%=comen.getData()%>"><br><br>
		<label> FkIdPost: </label>
		<input type="text" readonly size="20" name="fkidPost" value="<%=comen.getFkidPost()%>"><br><br>
		
		<br><input type="submit" value="Alterar Comentario">
	
	</form>
</body>
</html>