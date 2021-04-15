<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WeLearnn</title>
<style type="text/css">
<%@ include file="../css/style.css" %>
</style>
</head>
<body>
<%@ include file="../partials/header.jsp" %>
<p>
<div class="container">
<h3 class="title">Available Courses</h3>
<form action="view-course" method="post">
<table style="margin:auto;">
<tr>
<th>Si.No</th>
<th>Course Name</th>
<th>Course Description</th>
<th>Chapters</th>
<th>Price</th>
<th>Actions</th>
</tr>
<c:forEach var="course" items="${courseList }" varStatus="counter">
<tr>
<td>${counter.count }</td>
<td>${course.name }</td>
<td>${course.description }</td>
<td>${course.chapters }</td>
<td>${course.price }</td>
<td><button type="submit" name="deleteThisCourse" value="${course.courseId }" >Delete</button></td>
</tr>
</c:forEach>
</table>
</form>
<a href="/DWP/admin/dashboard" style="float:right;"><button>Back to Dashboard</button></a>
</div>

</body>
</html>