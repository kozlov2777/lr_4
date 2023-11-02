<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список вчителів</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Список вчителів</h1>
<table>
    <tr>
        <th>ID</th>
        <th>ПІБ</th>
        <th>Вік</th>
        <th>Місце роботи</th>
        <th>Стаж</th>
        <th>Дії</th>
    </tr>
    <c:forEach items="${teachers}" var="teacher">
        <tr>
            <td><c:out value="${teacher.id}" /></td>
            <td><c:out value="${teacher.fullName}" /></td>
            <td><c:out value="${teacher.age}" /></td>
            <td><c:out value="${teacher.workplace}" /></td>
            <td><c:out value="${teacher.experience}" /></td>
            <td>
                <!-- Форма для видалення вчителя -->
                <form action="${pageContext.request.contextPath}/deleteTeacher" method="post">
                    <input type="hidden" name="teacherId" value="${teacher.id}">
                    <button type="submit">Видалити</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="${pageContext.request.contextPath}/createTeacher" method="post">
    <h2>Створити нового вчителя:</h2>
    <label for="fullName">ПІБ:</label>
    <input type="text" id="fullName" name="fullName" required><br>
    <label for="age">Вік:</label>
    <input type="number" id="age" name="age" required><br>
    <label for="workplace">Місце роботи:</label>
    <input type="text" id="workplace" name="workplace" required><br>
    <label for="experience">Стаж:</label>
    <input type="number" id="experience" name="experience" required><br>
    <button type="submit">Створити</button>

</form>
<form action="${pageContext.request.contextPath}/updateTeacher" method="post">
    <h2>Редагувати вчителя:</h2>
    <label for="teacherIdU">ID вчителя:</label>
    <input type="number" id="teacherIdU" name="teacherIdU" required><br>
    <label for="fullNameU">ПІБ:</label>
    <input type="text" id="fullNameU" name="fullNameU" required><br>
    <label for="ageU">Вік:</label>
    <input type="number" id="ageU" name="ageU" required><br>
    <label for="workplaceU">Місце роботи:</label>
    <input type="text" id="workplaceU" name="workplaceU" required><br>
    <label for="experienceU">Стаж:</label>
    <input type="number" id="experienceU" name="experienceU" required><br>
    <button type="submit">Оновити</button>
</form>
</body>
</html>
