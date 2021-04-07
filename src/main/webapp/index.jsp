<%@ page session="false" %>
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
<%@ include file="header.jsp" %>
<hr>
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