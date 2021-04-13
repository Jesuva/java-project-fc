<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<h3 class="title">Enroll Now!</h3>
<form action="course-enroll" method="post" >
<label>Choose Course</label><br>
<select name="course">
<c:forEach var="item" items="${courseList }">
<option value="${item.name }">${item.name }</option>
</c:forEach>
</select><br>
<label>Choose Course Level</label><br>
<input type="radio" name="level" value="beginner" required>Beginner<br>
<input type="radio" name="level" value="intermediate">Intermediate<br>
<input type="radio" name="level" value="advanced">Advanced<br>
<input class="btn" type="submit" value="Enroll" />
</form>
</div>
<div class="container">
<h3 class="title">Available Courses</h3>
<table style="margin:auto;">
<tr>
<th>Si.No</th>
<th>Course Name</th>
<th>Course Description</th>
<th>Chapters</th>
<th>Price</th>
</tr>
<c:forEach var="course" items="${courseList }" varStatus="counter">
<tr>
<td>${counter.count }</td>
<td>${course.name }</td>
<td>${course.description }</td>
<td>${course.chapters }</td>
<td>${course.price }</td>
</tr>
</c:forEach>
</table>
</div>

<br><br>
</body>
</html>