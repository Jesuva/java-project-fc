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
<h2 class="title">WeLearn</h2>
<div class="confirm-course-container">
<h4>Thanks for Adding New Course!</h4>
<h3>Hi ${sessionScope.name } !<br>
Thanks for adding a new course titled as ${param.courseName } !</h3>
<h1>Happy Teaching!</h1>
<a href="/DWP/admin/add-course"><button>Back To course</button></a>
</div>

</body>
</html>