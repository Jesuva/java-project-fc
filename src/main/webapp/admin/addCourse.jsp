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
<div class="container" >
<p>WeLearn is a Learning Management system with various courses and each of them are classified into <br>
three major categories for the convenience of the user. So When adding the course please make sure you<br>
stick to our policy of letting the user to choose their levels!</p>
<h3>Happy Teaching!</h3>
<form action="add-course" method="post">
<label>Course Name</label><br>
<input type="text" name="courseName" required><br>
<label>Chapters</label><br>
<input type="text" name="chapters" required><br>
<label>Course Description</label><br>
<textarea style="resize:none" name="courseDiscription"></textarea><br>
<input type="submit" value="Add Course">
</form>
</div>
<a href="../admin/dashboard"><button>Back to Dashboard</button></a>
</body>
</html>