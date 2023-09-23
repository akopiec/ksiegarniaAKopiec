<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>List books</title></head>
<body><h2>Books:</h2>
<div>
<table>
<tr>
<th>Nazwa</th>
<th>Wydawnictwo</th>
<th>Autor</th>
<th>Cena</th>
<th>Kategoria</th>
<th>Widok szczegolowy</th>
<th>Edytuj</th>
<th>Usun</th>
<th>Dodaj do koszyka</th>
</tr>
<c:forEach var="book" items="${books}">
<c:url var="edit" value="/books/edit">
<c:param name="bookId" value="${book.id}"/>
</c:url>
<c:url var="delete" value="/books/delete">
<c:param name="bookId" value="${book.id}"/>
</c:url>
<c:url var="addToCart" value="/cart/addToCart">
<c:param name="bookId" value="${book.id}"/> </c:url>
<c:url var="detail" value="/books/detail"><c:param name="bookId" value="${book.id}"/></c:url>
<tr>
<td>${book.title}</td>
<td>${book.publisher}</td>
<td>${book.authors}</td>
<td>${book.price}</td>
<td>${book.category.name}</td>
<td><a href="/ksiegarnia/books/detail/${book.id}">widok szczegolowy</a></td>
<td><a href="${edit}">edytuj</a></td>
<td><a href="/ksiegarnia/books/delete/${book.id}">usun</a></td>
<td><a href="${addToCart}">dodajDoKoszyka</a> </td>
</tr>
</c:forEach></table>
</div>
<div>
<c:url var="cart" value="/cart/list"> </c:url>
<input type="button" value="Dodaj ksiazke" onclick="window.location.href='formadd';return false;"/>
<p><a href="${cart}">Koszyk</a></p>
<p><a href="/ksiegarnia/orders/addOrder">Zluz zamowienie</a></p>
</div>
</body>
</html>