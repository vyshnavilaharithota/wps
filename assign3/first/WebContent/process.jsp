<%@ page import="first.Employee" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="u" class="first.Employee"></jsp:useBean>  
<jsp:setProperty property="empid" name="u"/>  
  




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
</head>
<body style="background-image: url('background.jpeg');background-size: cover;">
	<div class="container" >
		<div class="card-panel" style="background-color: black;margin-top: 20vh;">
			<div class="row">
				<div class="col l2"></div>
				<div class="col l4">
					<pre class="yellow-text">            Profile</pre><br>
					<img src="data:image/jpg;base64,${u.getPhoto()}" width="240" height="300"/>
				</div>
				<div class="col l4">
					<br><br><br><br><br><br><br>
					<pre class="yellow-text">Employee Name  --->  ${u.getName()}</pre><br>
					<pre class="yellow-text">Date of Birth  --->   ${u.getDob()}</pre><br>	
				</div>
			</div>
		</div>
	</div>
</body>
</html>