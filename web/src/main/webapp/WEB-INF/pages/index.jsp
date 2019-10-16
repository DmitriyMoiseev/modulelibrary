<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Домашняя страница</title>
</head>
<body>
<c:url value="/book" var="book"/>
<h1><a href="${book}">КНИГИ</a></h1>
<c:url value="/author" var="author"/>
<h1><a href="${author}">АВТОРЫ</a></h1>
</body>
</html>
