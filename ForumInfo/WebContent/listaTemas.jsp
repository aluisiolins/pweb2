<%@page import="java.util.List"%>
<%@page import="com.forum.beans.Tema"%>
<%@page import="com.forum.jdbc.TemaDAO"%>
<%@page import="com.forum.beans.Usuario"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Temas</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Página - Listagem de Temas</h1>
	
	<%
	//TemaDAO temaDao= new TemaDAO();
	//List<Tema> listaTemp1 = temaDao.buscarTodos(); 
	
	 List<Tema> listaTemp1= (List<Tema>)request.getAttribute("listaTema");
	%>
		<table border="1">
		  <tr bgcolor="#eaeaea">
		    <th>Referência</th>
		    <th>Descrição</th>
		    <th>Escolha Tema</th>
		    <th>Click abaixo</th>
		  </tr>
	<% 
	for(Tema t : listaTemp1){
	%>
	<tr>
		    <td><%= t.getRef() %></td>
		    <td><%= t.getDescricao() %></td>
		    <td><input type="radio" name="ref" value="<%=t.getRef()%>"></td>
		    <td><a href="cadPostagem.jsp?refe=<%=t.getRef()%>"> Vai p/Postagem</a></td> 
		    
	</tr>
	
	<% 	
	}
	%>
		</table>
	
</body>
</html>