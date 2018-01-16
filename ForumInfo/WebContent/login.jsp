<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página de login (email/senha)</title>
</head>
<body>
	
	<h1>Página - Login (email/senha)</h1>
	<fieldset>
	<form action="autenticaserv" method="post">
	
		<label> Email: </label>
		<input type="text" name="email"><br><br>
		<label> Senha: </label>
		<input type="password" name="senha"><br><br>
		
		<br><input type="submit" value="Logar">
	
	</form>
	</fieldset>
	




</body>
</html>