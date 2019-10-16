<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty author.firstName}">
        <title>Добавить</title>
    </c:if>
    <c:if test="${!empty author.firstName}">
        <title>Редактировать</title>
    </c:if>
</head>
<body>
<c:if test="${empty author.firstName}">
    <c:url value="/author/add" var="var"/>
</c:if>
<c:if test="${!empty author.firstName}">
    <c:url value="/author/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty author.firstName}">
        <input type="hidden" name="authorId" value="${author.authorId}">
    </c:if>
    <label for="firstName">Имя</label>
    <input type="text" name="firstName" id="firstName">
    <label for="lastName">Фамилия</label>
    <input type="text" name="lastName" id="lastName">
    <label for="patronymic">Отчество</label>
    <input type="text" name="patronymic" id="patronymic">
    <c:if test="${empty author.firstName}">
        <input type="submit" value="Добавить автора">
    </c:if>
    <c:if test="${!empty author.firstName}">
        <input type="submit" value="Редактировать автора">
    </c:if>
</form>
</body>
</html>
