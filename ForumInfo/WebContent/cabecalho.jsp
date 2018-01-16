<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cabeçalho</title>
</head>
<body>
	<p> &nbsp;&nbsp;
	<a href="home.jsp">[Home]</a> &nbsp;&nbsp;
	Cadastros=> [<a href="usuariocontrolserv?acao=cad">&nbsp;&nbsp;Usuário&nbsp;</a>
	<a href="temacontrolserv?acao=listar">&nbsp;&nbsp;|&nbsp;Postagem&nbsp;</a>
	<a href="postagemcontrolserv?acao=listar">&nbsp;&nbsp;|&nbsp;Comentário&nbsp;&nbsp;]</a>
	&nbsp;&nbsp; 
	<!-- <a href="comentariocontrolserv?acao=cad">&nbsp;&nbsp;|&nbsp;Comentário&nbsp;&nbsp;]</a> -->
	
	Listagens=> [<a href="temacontrolserv?acao=listar">&nbsp;&nbsp;Temas&nbsp;</a>
	<a href="usuariocontrolserv?acao=listar">&nbsp;&nbsp;|&nbsp;Usuário&nbsp;&nbsp;</a>
	<a href="postagemcontrolserv?acao=listar">&nbsp;&nbsp;|&nbsp;Postagem&nbsp;&nbsp;</a>
	<a href="comentariocontrolserv?acao=listar">&nbsp;&nbsp;|&nbsp;Comentário&nbsp;&nbsp;]</a>
	<a href="relatoriogeralcontrolserv?acao=lisT">&nbsp;&nbsp;|&nbsp;Geral&nbsp;&nbsp;]</a>
	</p>
	
	<p> &nbsp;&nbsp;
	Buscas por:=>  [Tema&nbsp
	<a href="formBuscaTermoPost_Comen.jsp">&nbsp;|&nbsp;Termo:Post/Comentário&nbsp;&nbsp;]</a>
	 &nbsp;&nbsp;
	<a href="autenticaserv">[Sair]</a>&nbsp;&nbsp;
	</p>
	
</body>
</html>