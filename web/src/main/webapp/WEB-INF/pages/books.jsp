<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>КНИГИ</title>
</head>
<body>

<h2>Книги</h2>
<table>
    <tr>
        <th>номер</th>
        <th>название</th>
        <th>жанр</th>
        <th>издательство</th>
        <th>год издания</th>
        <th>номер автора</th>
        <th>действие</th>
    </tr>
    <c:forEach var="book" items="${bookList}">
        <tr>
            <td>${book.bookId}</td>
            <td>${book.title}</td>
            <td>${book.genre}</td>
            <td>${book.edition}</td>
            <td>${book.editionYear}</td>
            <td>${book.author.authorId}</td>
            <td>
                <a href="/book/edit/${book.bookId}">редактировать</a>
                <a href="/book/delete/${book.bookId}">удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2><c:url value="/book/add" var="add"/>
    <a href="${add}">Добавить новую книгу</a></h2>

<h3><form action="/" method="get">
    <input type="submit" value="Назад"></form></h3>

</body>
</html>
