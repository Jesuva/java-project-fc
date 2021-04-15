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
<h3 class="title">WeLearn</h3>
<hr>
<div class="main-container">
<h3 class="title">Create New Account Here!</h3>
<form action="signup" method="post" class="fomr-control">
<table>
<tr>
<td><label>Name</label>
<td><input type="text" name="userName" required></td>
</tr>
<tr>
<td><label>Email</label></td>
<td><input type="email" name="userEmail" required></td>
</tr>
<tr>
<td><label>Password</label></td>
<td><input type="password" name="userPassword" required></td>
</tr>
</table>
<input type="submit" value="Sign Up" class="login-btn">
</form>
</div>
</body>
</html>