<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div>
<p>Jestes na stronie z opisem ksiaki</p>
<h3>${book.title}</h3>
<p>jej cena wynosi:</p><h2>${book.price}</h2>
</br>
<p>Dla ksiazki sa dostepne nastepujace komentarze</p>
<c:forEach var="comment" items="${listComment}">
<p>${comment.description}</p>
<hr/>
</c:forEach>
</div>
<c:url var="comment" value="/books/comment">
<c:param name="bookId" value="${book.id}"/>
</c:url>
<a href="/ksiegarnia/books/comment/${book.id}">Dodaj komentarz</a>
</body>
</html>