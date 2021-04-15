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
<h3 class="title">Start Learning And Shine!</h3>
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
<br>
<p>Don't Have an account? Create your account here! <a href="signup">Sign Up</a></p>
</div>
</body>
</html>