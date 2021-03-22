<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<c:url value = "/UnicaEntrada" var = "unicaEntrada"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Faça seu Login</h1>

<form action = "${unicaEntrada}" method = "post">
<label for = "login">Login:</label>
<input type = "text" name = "login"/>
<label for = "senha">Senha:</label>
<input type = "password" name = "senha"/>
<input type = "hidden" name = "acao" value = "Login"/>
<button type = "submit">Enviar</button>
</form>

<a href = "/gerenciador/UnicaEntrada?acao=FormUsuario">Cadastrar</a>


</body>
</html>