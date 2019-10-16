<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty book.title}">
        <title>Добавить</title>
    </c:if>
    <c:if test="${!empty book.title}">
        <title>Редактировать</title>
    </c:if>
</head>
<body>
<c:if test="${empty book.title}">
    <c:url value="/book/add" var="var"/>
</c:if>
<c:if test="${!empty book.title}">
    <c:url value="/book/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty book.title}">
        <input type="hidden" name="bookId" value="${book.bookId}">
    </c:if>
    <label for="title">Название</label>
    <input type="text" name="title" id="title">
    <label for="genre">Жанр</label>
    <input type="text" name="genre" id="genre">
    <label for="edition">Издание</label>
    <input type="text" name="edition" id="edition">
    <label for="editionYear">Год издания</label>
    <input type="text" name="editionYear" id="editionYear">
    <c:if test="${empty book.title}">
        <label for="author.authorId">Номер автора</label>
        <input type="number" name="author.authorId" id="author.authorId">
        <input type="submit" value="Добавить книгу">
    </c:if>
    <c:if test="${!empty book.title}">
        <input type="hidden" name="author.authorId" value="${book.author.authorId}">
        <input type="submit" value="Редактировать книгу">
    </c:if>
</form>
</body>
</html>
