<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <th>Modyfikacja</th>
        </tr>
        <c:forEach var="book" items="${books}">
        <c:url var="edit" value="/books/edit">
                        <c:param name="bookId" value="${book.id}"/>
                    </c:url>
                    <c:url var="delete" value="/books/delete">
                        <c:param name="bookId" value="${book.id}"/>
                    </c:url>
                    <c:url var="dodajDoKoszyka" value="/cart/dodajDoKoszyka">
                    <c:param name="bookId" value="${book.id}"/> </c:url>
            <tr>
                <td>${book.title}</td>
                <td>${book.publisher}</td>
                <td>${book.authors}</td>
                <td>${book.price}</td>
                <td>${book.category.name}</td>
               <sec:authorize access="hasRole('ADMIN')">
                   <td><a href="${edit}">edytuj</a></td>
                   <td><a href="${delete}">usuń</a></td>
               </sec:authorize> <a href="${dodajDoKoszyka}">DodajDoKoszyka</a> </td>
                            </tr>
            </tr>
        </c:forEach></table>
</div>
<div>
<c:url var="koszyk" value="/cart/lista"> </c:url>
    <input type="button" value="Add Book" onclick="window.location.href='formadd';return false;"/>
    <p><a href="${koszyk}">Koszyk</a></p>
</div>
</body>
</html>