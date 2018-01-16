<%@page import="java.util.List"%>
<%@page import="com.forum.jdbc.PostagemDAO"%>
<%@page import="com.forum.beans.Postagem"%>
<%@page import="com.forum.jdbc.TemaDAO"%>
<%@page import="com.forum.beans.Tema"%>
<%@page import="com.forum.jdbc.UsuarioDAO"%>
<%@page import="com.forum.beans.Usuario"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Postagens Geral</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Página - Listagem de Postagens Geral</h1>
	
	<%
		List<Postagem> listaTempP= (List<Postagem>)request.getAttribute("listaP");
		List<Tema> listaTempT= (List<Tema>)request.getAttribute("listaT");
		List<Usuario> listaTempU= (List<Usuario>)request.getAttribute("listaU");
	%>
		<table border="1">
		  
	<%
		for(Tema t : listaTempT){
	%>
		<tr>
			<th>Ref</th> <td><%=t.getRef()%></td>
			<th>Descrição:</th> <td><%=t.getDescricao()%></td>
		</tr>
	
		<%
			for(Usuario u : listaTempU){
	    %>
	    	<tr>
				<th>Cod</th> <td><%=u.getCod()%></td>
			    <th>Nome</th> <td><%=u.getNome()%></td>
			</tr>
			<%
			   	for(Postagem p : listaTempP){
			%>
				<tr>	
					<th>Idt:</th> <td><%=p.getId() %></td>
					<th>Texto do Post:</th> <td><%=p.getTexto1p() %></td>
				</tr>
				    
				<% 	
					}
				%>
		<% 	
			}
		 %>
	<% 	
		}
	 %>		 
		 
		 
		</table>
	
</body>
</html>