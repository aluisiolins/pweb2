<%@page import="com.forum.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Cadastro</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Página - Alterar Cadastro de Usuários</h1>
	
	<%
		Usuario usu= (Usuario)request.getAttribute("usuario");
	%>

	<form action="usuariocontrolserv" method="post">
	
		<input type="hidden" name="acao" value="salvar">
	
		
		<label> Codigo: </label>
		<input type="text" name="codigo" value="<%=usu.getCod()%>">
		<label> Nome: </label>
		<input type="text" name="nome" value="<%=usu.getNome()%>"><br><br>
		<label> Email: </label>
		<input type="text" name="email" value="<%=usu.getEmail()%>">
		<label> Senha: </label>
		<input type="password" name="senha" value="<%=usu.getSenha()%>"><br><br>
		
		<br><input type="submit" value="Alterar">
	
	</form>
</body>
</html>