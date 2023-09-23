<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pl">
<head>
<meta charset="UTF-8">
<meta name="viewport"
    content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Zluz zamowienie</title>
</head>
<body>
<div>
<table><tr><td>produkt to:</td><td>ilosc to:</td><td>Do zaplaty:</td></tr>
<c:forEach var="mapbook" items="${mapbook}">
<tr><td>${mapbook.key.title}</td><td>${mapbook.value}</td><td>${mapbook.key.price*mapbook.value}</td></tr>
</c:forEach>
</table>
<p>Wartosc calkowita:</p><h3>${totalPrice}</h3>
<form:form method="post">
<c:if test="${not empty mapbook}">
<input type="submit" value="Zloz zamowienie" class="save"/>
</c:if>
</form:form>
</div>
</body>
</html>