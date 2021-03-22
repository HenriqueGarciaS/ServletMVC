<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<c:url value = "/UnicaEntrada" var = "unicaEntrada"/>


<!DOCTYPE html>    
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar uma nova empresa</title>
</head>
<body>



<form action = "${unicaEntrada}" method = "post">
<label for = "nome">Nome da Empresa</label>
<br/>
<input type = "text" name = "nome"/>
<br/>
<label for = "dataAbertura">Data de abertura da empresa</label>
<br/>
<input type = "date" name = "dataAbertura"/>
<input type = "hidden" name = "acao" value = "CriaEmpresa"/>
<br/>
<br/>
<button type = "submit">Cadastrar</button>
</form>







</body>
</html>