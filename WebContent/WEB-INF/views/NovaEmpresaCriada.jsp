<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test = "${not empty nomeEmpresa}">
<p> Empresa criada: ${nomeEmpresa} na data ${dataAbertura}</p>
</c:if>
<c:if test = "${empty nomeEmpresa}">
<p> nenhuma empresa recebida </p>
</c:if>
</body>
</html>