<%@page import="java.util.List"%>
<%@page import="com.forum.jdbc.PostagemDAO"%>
<%@page import="com.forum.beans.Postagem"%>
<%@page import="com.forum.jdbc.ComentarioDAO"%>
<%@page import="com.forum.beans.Comentario"%>
<%@page import="com.forum.jdbc.UsuarioDAO"%>
<%@page import="com.forum.beans.Usuario"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Geral de Postagem </title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Página - Listagem Geral (Postagens) </h1>
	
	<%
		List<Postagem> listaTempP= (List<Postagem>)request.getAttribute("listaP");
		List<Comentario> listaTempC= (List<Comentario>)request.getAttribute("lista");
	%>
		<table border="1">
		  
				<%
				for(Postagem p : listaTempP){
				%>
					<tr><th bgcolor="#eaeaea"> Postagem</th><td><%=p.toString()%></td></tr> 
						<%
							
							for(Comentario c : listaTempC){
								if(c.getFkidPost().equals(p.getId())){
						%>	
							<tr><th bgcolor="yellow"> Comentário</th><td><%=c.toString()%></td></tr>	
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