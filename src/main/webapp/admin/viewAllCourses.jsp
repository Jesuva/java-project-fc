<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WeLearn</title>
</head>
<style type="text/css">
<%@ include file="../css/style.css" %>	
</style>
<body>
<%@ include file="../partials/header.jsp" %>
<div class="container">
<h3 class="title">Available Courses</h3>
<form action="course-enroll" method="post">
<table style="margin:auto;">
<tr>
<th>Si.No</th>
<th>Course Name</th>
<th>Course Description</th>
<th>Chapters</th>
<th>Price</th>
<th>Action</th>
</tr>
<c:forEach var="course" items="${courseList }" varStatus="counter">
<tr>
<td>${counter.count }</td>
<td>${course.name }</td>
<td>${course.description }</td>
<td>${course.chapters }</td>
<td>${course.price }</td>
<td><button type="submit" name="selectedCourse" value="${course.courseId }">Enroll</button></td>
</tr>
</c:forEach>
</table>
</form>
<a href="#" style="float:right;"><button>View Enrolled Courses</button></a>
</div>

<br><br>
</body>
</html>