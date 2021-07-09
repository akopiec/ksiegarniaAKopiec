<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head></head>
<body>
<div><h3>Koszyk</h3>
  <table border="1" style="background: rgb(104,226,219">   <tr><td>Nazwa</td><td>Wydawnictwo</td><td>Autor</td><td>Cena</td><td>Kategoria</td><td>Modyfikacja</td></tr>
    <c:forEach var="listBook" items="${listBook}">
    <c:url var="usunZKoszyka"  value="/cart/usunZKoszyka">
    <c:param name="bookId" value="${listBook.id}"/></c:url>
    <tr style="background : rgb(75,216,213)">
    <td>${listBook.title}</td>
    <td>${listBook.publisher}</td>
    <td>${listBook.authors}</td>
    <td>${listBook.price}</td>
    <td>${listBook.category.name}</td><td><a href="${usunZKoszyka}">UsunzKoszyka</a></td>
    </tr>  </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>