<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pl">

<body>
<form:form method="post" modelAttribute="comment">
<label for="description">podaj komentarz</label>
</br>
<form:textarea cols="40" rows="15" path="description" id="description" />
<button type="submit">Dodaj komentarz</button>
</form:form>
</body>
</html>
