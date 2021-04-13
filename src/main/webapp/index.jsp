<!DOCTYPE html>
<%@ page session="false" %>
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
<td><label>Password</label></td>
<td><input type="password" name="userPassword" required></td>
</tr>
<tr>
<td><label>Confirm Password</label></td>
<td><input type="password" name="confirmPassword" required></td>
</tr>
<tr><td><label>Role</label></td>
<td><select name="role">
<option value="admin">Admin</option>
<option value="user">Student</option>
</select>
</td>
</tr>
</table>
<input type="submit" value="Sign Up" class="login-btn">
</form>
</div>
<div class="main-container">
<h4>Please Login!</h4>
<form action="login" method="post" class="form-control">
	<table>
	<tr>
	<td>	<label>Name</label> </td>
	<td><input type="text" name="userName"  required/></td>
	</tr>
	<tr>
	<td>	<label>Password</label></td>
	<td><input type="password" name="userPassword"  required/></td>
	</tr>
	</table>
	<input type="submit" value="Login" class="login-btn">
</form>
</div>
</body>
</html>