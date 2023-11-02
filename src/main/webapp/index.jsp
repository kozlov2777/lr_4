<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Головна сторінка</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Головна сторінка</h1>
<p>Виконати дії з книгами</p>
<a href="${pageContext.request.contextPath}/readBooks">Книги</a>
<br>
<p>Виконати дії з курсами</p>
<a href="${pageContext.request.contextPath}/readCourses">Курси</a>
<br>
<p>Виконати дії з предметами</p>
<a href="${pageContext.request.contextPath}/readSubjects">Предмети</a>
<br>
<p>Виконати дії з вчителями</p>
<a href="${pageContext.request.contextPath}/readTeachers">Вчителі</a>
</body>
</html>

