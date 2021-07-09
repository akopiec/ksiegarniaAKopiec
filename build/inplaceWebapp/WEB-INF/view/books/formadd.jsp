
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Dodaj książkę</title>
</head>
<body>
Dodaj książkę
<form:form action="saveBook" modelAttribute="book" method="POST">
    <table>
        <tbody>
        <tr><td><label>id</label>
        <td><form:hidden path="id"/></td
        </tr>
        <tr>
            <td><label for="title">nazwa:</label></td>
            <td><form:input path="title" id="title"/></td>
        </tr>
        <tr>
            <td><label for="publisher">wydawnictwo:</label></td>
            <td><form:input path="publisher" id="publisher"/></td>
        </tr>
        <tr>
            <td><label for="price">cena:</label></td>
            <td><form:input path="price" id="price"/></td>
        </tr>

        <tr>
                    <td><label for="categories">kategoria:</label></td>
                    <td>
                        <form:select path="category" id="categories">
                            <form:options items="${categories}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td><label for="authors">autorzy:</label></td>

                  <td>
                        <form:select multiple="true" path="authors" id="authors">
                            <form:options items="${authors}" itemValue="id" itemLabel="fullName"/>
                        </form:select>
                    </td>
                </tr>

tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save"/></td>
        </tr>
        </tbody>
    </table>
</form:form>
<p>
    <a href="${pageContext.request.contextPath}/books/list "> return </a>
</p>
</body>
</html>
