<%@page import="java.util.List"%>
<%@page import="com.forum.jdbc.PostagemDAO"%>
<%@page import="com.forum.beans.Postagem"%>
<%@page import="com.forum.jdbc.ComentarioDAO"%>
<%@page import="com.forum.beans.Comentario"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Comentários</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Página - Listagem de Comentários</h1>
	
	<%
		List<Comentario> listaTemp2= (List<Comentario>)request.getAttribute("lista");
	%>
		<table border="1">
		  <tr bgcolor="#eaeaea">
		    <th>Nr:</th>
		    <th>Texto Comentário:</th>
		    <th>C/A </th>
		    <th>Data</th>
		    <th>IdPost</th>
		    <th>Deletar</th>
		    <th>Alterar</th>
		    
		  </tr>
	<% 
	for(Comentario c : listaTemp2){
	%>
	<tr>
		    <td><%= c.getNr() %></td>
		    <td><%= c.getTexto2c() %></td>
		    <td><%= c.getAutor() %></td>
		    <td><%= c.getData() %></td>
		    <td><%= c.getFkidPost()%></td>
		    <td><a href="comentariocontrolserv?acao=del&codi=<%=c.getNr()%>">Excluir</a></td>
		    <td><a href="comentariocontrolserv?acao=alt&codi=<%=c.getNr()%>">Alterar</a></td>
		    		    
	</tr>
	
	<% 	
	}
	%>
		</table>
	
</body>
</html>