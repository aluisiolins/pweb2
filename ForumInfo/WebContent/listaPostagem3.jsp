<%@page import="java.util.List"%>
<%@page import="com.forum.jdbc.PostagemDAO"%>
<%@page import="com.forum.beans.Postagem"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Postagens</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Página - Listagem de Postagens</h1>
	
	<%
		List<Postagem> listaTemp2= (List<Postagem>)request.getAttribute("lista");
	%>
		<table border="1">
		  <tr bgcolor="#eaeaea">
		    <th>Identificador:</th>
		    <th>Texto do Post:</th>
		    <th>FkRef</th>
		    <th>FkCod</th>
		    <th>Deletar</th>
		    <th>Alterar</th>
		  </tr>
	<% 
	for(Postagem p : listaTemp2){
	%>
	<tr>
		    <td><%= p.getId() %></td>
		    <td><%= p.getTexto1p() %></td>
		    <td><%= p.getFkref() %></td>
		    <td><%= p.getFkcod() %></td>
		    <td><a href="postagemcontrolserv?acao=del&codi=<%=p.getId()%>">Excluir</a></td>
		    <td><a href="postagemcontrolserv?acao=alt&codi=<%=p.getId()%>">Alterar</a></td>
		    
	</tr>
	
	<% 	
	}
	%>
		</table>
	
</body>
</html>