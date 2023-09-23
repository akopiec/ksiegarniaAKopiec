<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="pl">
<head>
<meta charset="UTF-8">
<meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Ksiegarnia</title>
</head>
<body>
<h1>Witaj na stronie ksiegarni</h1>
<ul>
<li><a href="${pageContext.request.contextPath}/books/list">Lista Ksiazek</a></li>
<li><a href="${pageContext.request.contextPath}/cart/list">Koszyk z ksiazkami</a></li>
<li><a href="${pageContext.request.contextPath}/login">Zaloguj</a></li>
<li><a href="${pageContext.request.contextPath}/logout">Wyloguj</a></li>
<li><a href="${pageContext.request.contextPath}/register">Zarejestruj</a></li>
</ul>
</body>
</html>