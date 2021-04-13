<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@ include file="../css/style.css" %>
</style>
<meta charset="ISO-8859-1">
<title>WeLearn</title>
</head>
<body>
<%@ include file="../partials/header.jsp" %>

<div class="container">
<h3>Hi,  ${sessionScope.name }</h3>
<p>You can add the new Course that you want to share with your students!<br>
Make sure you stick to our policy of fragmenting the course into three categories!<br>
(Beginner, Intermediate and Advanced)<br>
</p>
<h2>Happy Teaching!</h2>
<div class="title">
<a href="/DWP/admin/add-course"><button>Add Course</button></a>
<a href="/DWP/admin/view-course"><button>View Courses</button></a>
</div>
</body>
</html>