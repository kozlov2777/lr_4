<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список курсів</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Список курсів</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Назва курсу</th>
        <th>Посилання</th>
        <th>Вартість</th>
        <th>Дата початку</th>
        <th>ID предмета</th>
        <th>Дії</th>
    </tr>
    <c:forEach items="${courses}" var="course">
        <tr>
            <td><c:out value="${course.id}" /></td>
            <td><c:out value="${course.name}" /></td>
            <td><c:out value="${course.link}" /></td>
            <td><c:out value="${course.cost}" /></td>
            <td><c:out value="${course.startDate}" /></td>
            <td><c:out value="${course.subject.id}" /></td>
            <td>
                <!-- Форма для видалення курсу -->
                <form action="${pageContext.request.contextPath}/deleteCourse" method="post">
                    <input type="hidden" name="courseId" value="${course.id}">
                    <button type="submit">Видалити</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="${pageContext.request.contextPath}/createCourse" method="post">
    <h2>Створити новий курс:</h2>
    <label for="courseName">Назва курсу:</label>
    <input type="text" id="courseName" name="courseName" required><br>
    <label for="courseLink">Посилання:</label>
    <input type="text" id="courseLink" name="courseLink" required><br>
    <label for="courseCost">Вартість:</label>
    <input type="number" step="0.01" id="courseCost" name="courseCost" required><br>
    <label for="startDate">Дата початку:</label>
    <input type="date" id="startDate" name="startDate" required><br>
    <label for="subjectId">ID предмета:</label>
    <input type="number" id="subjectId" name="subjectId" required><br>
    <button type="submit">Створити</button>
</form>
<form action="${pageContext.request.contextPath}/updateCourse" method="post">
    <h2>Редагувати курс:</h2>
    <label for="courseIdU">ID курсу:</label>
    <input type="number" id="courseIdU" name="courseIdU" required><br>
    <label for="courseNameU">Назва курсу:</label>
    <input type="text" id="courseNameU" name="courseNameU" required><br>
    <label for="courseLinkU">Посилання:</label>
    <input type="text" id="courseLinkU" name="courseLinkU" required><br>
    <label for="courseCostU">Вартість:</label>
    <input type="number" step="0.01" id="courseCostU" name="courseCostU" required><br>
    <label for="startDateU">Дата початку:</label>
    <input type="date" id="startDateU" name="startDateU" required><br>
    <label for="subjectIdU">ID предмета:</label>
    <input type="number" id="subjectIdU" name="subjectIdU" required><br>
    <button type="submit">Оновити</button>
</form>
</body>
</html>
