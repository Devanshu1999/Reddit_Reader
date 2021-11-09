<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<style type="text/css">
		.logon{
			margin-top: 1%;
			text-align: center;
			font-style: italic;
			font-size: 55.2px;
  			font-weight: 700;
  			color: #FF5733;
  			font-family: Segoe UI;
		}
	
		body {
			background-image: url("${pageContext.request.contextPath}/resources/HomePage.jpg");
			background-repeat: no-repeat;
			background-attachment: fixed;
			background-size: 100% 100%;
		}
		
		.loginbox{
			align-items: center;
			display: flex;
			justify-content: center;
			padding-top: 10%;
		}
		
		.content{
			border-style: hidden;
			background-color: #4f5c6b;
			border-radius: 32px;
			padding: 35px;
		}
		
		#inputbox{
			height:28px;
    		font-size:20px;
    		background-color: #D3D3D3;
		}
		
		#inputbox:focus {
			border: 3px solid #555;
		}
		
	</style>
</head>
<body>
<div class = "logon">SIGN IN</div>
<div class = "loginbox">
	<div class = "content">			
		<form:form action = "${pageContext.request.contextPath}/authenticateTheUser" method = "POST" modelAttribute = "myUser">
						<!-- If user enters wrong credentials, then the url will have "?error" appended to it. Below code checks for this -->
						<c:if test = "${param.error != null}">
							<i><font color="red" size="4">Sorry! You entered invalid username/password.</font></i><br>
						</c:if>
				<font size="5" color="white">Username:</font>
				<form:input type = "text" name = "username" path="username" id = "inputbox"/><br><br>
				<font size="5" color="white">Password: </font>
				<form:input type = "password" name = "password" path="password" id = "inputbox"/><br><br>
					<input type = "submit" value = "Login" class="btn btn-success"/>
			<a href = "${pageContext.request.contextPath}/register" class="btn btn-primary" role = "button">Register</a>
		</form:form>
	</div>
</div>
</body>
</html>