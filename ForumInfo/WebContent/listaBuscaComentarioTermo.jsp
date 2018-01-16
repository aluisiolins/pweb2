<%@page import="java.util.List"%>
<%@page import="com.forum.jdbc.ComentarioDAO"%>
<%@page import="com.forum.beans.Comentario"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Busca de Comentários por Termo</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h2>Página - Listagem de Comentários (Busca/Termo)</h2>
	
	<%
		List<Comentario> listaTemp2= (List<Comentario>)request.getAttribute("listaTermo");
	%>
		<table border="1">
		  <tr bgcolor="#eaeaea">
		    <th>Nr:</th>
		    <th>Tx Comentário:</th>
		    <th>C/A</th>
		    <th>Data</th>
		    <th>FkidPost</th>
		    <th>Deletar</th>
		    <th>Alterar</th>
		    <th>Esc Post</th>
		    <th>p/ Comentar</th>
		  </tr>
	<% 
	for(Comentario c : listaTemp2){
	%>
	<tr>
		    <td><%= c.getNr()%></td>
		    <td><%= c.getTexto2c() %></td>
		    <td><%= c.getAutor() %></td>
		    <td><%= c.getData() %></td>
		    <td><%= c.getFkidPost() %></td>
		    <td><a href="comentariocontrolserv?acao=del&codi=<%=c.getNr()%>">Excluir</a></td>
		    <td><a href="comentariocontrolserv?acao=alt&codi=<%=c.getNr()%>">Alterar</a></td>
		    <td><input type="radio" name="ref" value="<%=c.getNr()%>"></td>
		    <td><a href="cadComentario.jsp?ident=<%=c.getNr()%>"> Comentar =></a></td> 
		    
	</tr>
	
	<% 	
	}
	%>
		</table>
	
</body>
</html>