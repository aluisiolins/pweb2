<%@page import="com.forum.jdbc.UsuarioDAO"%>
<%@page import="com.forum.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página - Salvar Cadastro</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Página - Salvo Cadastro</h1>
	<%
		String snome = request.getParameter("nome");
		String semail = request.getParameter("email");
		String ssenha = request.getParameter("senha");
		
		Usuario usu = new Usuario();
		usu.setNome(snome);
		usu.setEmail(semail);
		usu.setSenha(ssenha);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.cadastro(usu);
	%>
	
	<h1>Salvo com sucesso!</h1>

</body>
</html>