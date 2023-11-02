<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список книг</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Список книг</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Назва книги</th>
        <th>Дії</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.id}" /></td>
            <td><c:out value="${book.name}" /></td>

            <td>
                <form action="${pageContext.request.contextPath}/deleteBook" method="post">
                    <input type="hidden" name="action" value="deleteBook">
                    <input type="hidden" name="bookId" value="${book.id}">
                    <button type="submit">Видалити</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="form-container">
    <h2>Створити нову книгу:</h2>
    <form action="${pageContext.request.contextPath}/createBook" method="post">
        <label for="bookName">Назва книги:</label>
        <input type="text" id="bookName" name="bookName" required><br>
        <button type="submit">Створити</button>
    </form>
</div>
<div class="form-container">
    <h2>Редагувати книгу:</h2>
    <form action="${pageContext.request.contextPath}/updateBook" method="post">
        <label for="bookIdU">ID книги:</label>
        <input type="number" id="bookIdU" name="bookIdU" required><br>
        <label for="bookNameU">Назва книги:</label>
        <input type="text" id="bookNameU" name="bookNameU" required><br>
        <button type="submit">Оновити</button>
    </form>
</div>
</body>
</html>







