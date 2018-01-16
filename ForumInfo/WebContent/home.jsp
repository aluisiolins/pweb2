<%@page import="com.forum.beans.Usuario"%>
<%@page import="com.forum.jdbc.TemaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
 <%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home - Início</title>
</head>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
<h1>Forum de Informática *** Página - Home</h1>

<%
Usuario usuAutenticado = (Usuario)session.getAttribute("usuAut");
out.print("Olá "+usuAutenticado.getNome()+ "! Seja bem-vindo(a) ao melhor site do mundo!");

int cod_usu= usuAutenticado.getCod();
%>

<h2>Temas para Discussão no Forum</h2>

	

</body>
</html>