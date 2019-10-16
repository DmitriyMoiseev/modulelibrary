<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>АВТОРЫ</title>
</head>
<body>

<h2>Авторы</h2>
<table>
    <tr>
        <th>номер</th>
        <th>имя</th>
        <th>фамилия</th>
        <th>отчество</th>
        <th>действие</th>
    </tr>
    <c:forEach var="author" items="${authorList}">
        <tr>
            <td>${author.authorId}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>${author.patronymic}</td>
            <td>
                <a href="/author/edit/${author.authorId}">редактировать</a>
                <a href="/author/delete/${author.authorId}">удалить</a>
                <a href="/author/show/${author.authorId}">книги</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2><c:url value="/author/add" var="add"/>
    <a href="${add}">Добавить нового автора</a></h2>

<h3><form action="/" method="get">
    <input type="submit" value="Назад"></form></h3>

</body>
</html>
