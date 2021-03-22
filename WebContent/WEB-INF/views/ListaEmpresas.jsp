<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="modelos.Empresa,java.util.List" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>Usuario Logado : ${usuario.login}</p>
<br/>
<br/>
<a href = "/gerenciador/UnicaEntrada?acao=Logout">Logout</a>

<c:if test = "${not empty nomeEmpresa}">
<p> Empresa criada: ${nomeEmpresa} na data ${dataAbertura}</p>
</c:if>

<h1>Lista de empresas</h1>
<a href = "/gerenciador/UnicaEntrada?acao=FormEmpresa">Adcionar Empresa</a>

<ul>
<c:forEach items = "${empresas}" var = "empresa">
<li>id:${empresa.id} ${empresa.nome } <fmt:formatDate value = "${empresa.dataAbertura }" pattern = "dd/MM/yyyy"/>
<a href = "/gerenciador/UnicaEntrada?acao=GetEmpresa&id=${empresa.id}">Editar</a>
<a href = "/gerenciador/UnicaEntrada?acao=RemoveEmpresa&id=${empresa.id}">Remover</a></li>
</c:forEach>
</ul>

</body>
</html>