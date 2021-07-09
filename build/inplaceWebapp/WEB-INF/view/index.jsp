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
    <ul>
        <li><a href="${pageContext.request.contextPath}/authors/list">Autorzy</a></li>
        <li><a href="${pageContext.request.contextPath}/books/list">Ksiązki</a></li>
        <li><a href="${pageContext.request.contextPath}/categories/list">Kategorie</a></li>
    </ul>
    <h1>Witaj</h1>
</body>
</html>