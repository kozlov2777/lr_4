<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список предметів</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Список предметів</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Назва предмету</th>
        <th>Дії</th>
    </tr>
    <c:forEach items="${subjects}" var="subject">
        <tr>
            <td><c:out value="${subject.id}" /></td>
            <td><c:out value="${subject.name}" /></td>
            <td>
                <!-- Форма для видалення предмету -->
                <form action="${pageContext.request.contextPath}/deleteSubject" method="post">
                    <input type="hidden" name="action" value="deleteSubject">
                    <input type="hidden" name="subjectId" value="${subject.id}">
                    <button type="submit">Видалити</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="${pageContext.request.contextPath}/createSubject" method="post">
    <h2>Створити новий предмет:</h2>
    <label for="subjectName">Назва предмету:</label>
    <input type="text" id="subjectName" name="subjectName" required><br>
    <button type="submit">Створити</button>
</form>
<form action="${pageContext.request.contextPath}/updateSubject" method="post">
    <h2>Редагувати предмет:</h2>
    <label for="subjectIdU">ID предмету:</label>
    <input type="number" id="subjectIdU" name="subjectIdU" required><br>
    <label for="subjectNameU">Назва предмету:</label>
    <input type="text" id="subjectNameU" name="subjectNameU" required><br>
    <button type="submit">Оновити</button>
</form>
</body>
</html>
