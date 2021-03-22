<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
 <c:url value = "/UnicaEntrada" var = "unicaEntrada"/>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action = "${unicaEntrada}" method = "post">
<label for = "nome">Nome da Empresa</label>
<br/>
<input type = "text" name = "nome" value = "${empresa.nome }"/>
<br/>
<label for = "dataAbertura">Data de abertura da empresa</label>
<br/>
<input type = "text" name = "dataAbertura" value = "<fmt:formatDate value = "${empresa.dataAbertura }" pattern = "dd/MM/yyyy"/>"/>
<br/>
<input type = "hidden" name = "id" value = "${empresa.id}"/>
<input type = "hidden" name = "acao" value = "AlteraEmpresa" />
<br/>
<button type = "submit">Cadastrar</button>
</form>

</body>
</html>