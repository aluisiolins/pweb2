<%@page import="java.util.List"%>
<%@page import="com.forum.jdbc.UsuarioDAO"%>
<%@page import="com.forum.beans.Usuario"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuários</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Página - Listagem de Usuários</h1>
	
	<%
	  List<Usuario> listaTemp2= (List<Usuario>)request.getAttribute("lista");
	%>
		<table border="1">
		  <tr bgcolor="#eaeaea">
		    <th>Código</th>
		    <th>Nome</th>
		    <th>Email</th>
		    <th>Deletar</th>
		    <th>Alterar</th>
		  </tr>
	<% 
	for(Usuario u : listaTemp2){
	%>
	<tr>
		    <td><%= u.getCod() %></td>
		    <td><%= u.getNome() %></td>
		    <td><%= u.getEmail() %></td>
		    <td><a href="usuariocontrolserv?acao=del&codi=<%=u.getCod()%>">Excluir</a></td>
		    <td><a href="usuariocontrolserv?acao=alt&codi=<%=u.getCod()%>">Alterar</a></td>
		    
	</tr>
	
	<% 	
	}
	%>
		</table>
	
</body>
</html>