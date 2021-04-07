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
<div id = "user-box">
<div class="active">
<h4 style="font-style:bold;">
<small>Hey!, </small>
<% String userName = (String)session.getAttribute("name");
   out.print(userName);
%>
</h4>
</div>
</div> 
<div id = "title-box">
    <h3 class="title">Enroll in a Course</h3>
</div>
  
<div id = "logout-box">
 <a href="/DWP/logout"><button class="logout-btn">Logout</button></a>
</div>
<div class="container">
<p>The WeLearn is the Online Learning Platform Where you can enroll in any of the available courses<br>
Currently we are providing Three Major Course (JAVA,Python, and UI). The best part about enrolling to the course in our
<br> platform is that we provide the levels for each courses (Beginner,Intermediate and Advanced) <br>
So that you may not be wasting time on the concepts that you already Learnt,</p>
<h3>HAppy Learning!</h3>
</div>
<div class="container">
<form action="course-enroll" method="post">
<label>Choose Course</label><br>
<select name="course">
<option value="Java">Java</option>
<option value="Python">Python</option>
<option value="UI">UI/UX</option>
</select><br>
<label>Choose Course Level</label><br>
<input type="radio" name="level" value="beginner" required>Beginner<br>
<input type="radio" name="level" value="intermediate">Intermediate<br>
<input type="radio" name="level" value="advanced">Advanced<br>
<input class="btn" type="submit" value="Enroll" />
</form>
</div>
</body>
</html>