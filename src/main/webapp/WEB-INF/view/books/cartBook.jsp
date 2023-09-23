<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head></head>
<body>
<div><h3>Koszyk</h3>
<table border="1" style="background: rgb(104,226,219">   <tr><td>Nazwa</td><td>Ilosc</td><td>Kwota za ksiazki</td></tr>
<c:forEach var="mapBook" items="${mapBook}"><tr><td>${mapBook.key.title}</td><td>${mapBook.value}</td><td>${mapBook.value*mapBook.key.price}</td>
<c:url var="usunZKoszyka"  value="/cart/deleteFromCart">
<c:param name="bookId" value="${mapBook.key.id}"/></c:url>
<td><a href="${usunZKoszyka}">UsunzKoszyka</a></td></tr>
</c:forEach>
</table>
</div>
</body>
</html>