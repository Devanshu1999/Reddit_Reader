<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Registration</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<style>
		.register{
			margin-top: 1%;
			text-align: center;
			font-style: italic;
			font-size: 3.45rem;
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
		
		.registerbox{
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
		
		.error{
			color:red;
		}
	</style>


</head>
<body>
<div class = "register">REGISTER</div>
<div class = "registerbox">
	<div class = "content">
		<c:if test="${errorMessage != null}">
			 <h3><font color="red">${errorMessage}</font></h3>
		</c:if>
		<form:form action = "${pageContext.request.contextPath}/saveUser" modelAttribute = "theUser" method = "POST">
			<table>
					<tbody>
						<tr>
							<td><font size="5" color="white">Username:</font></td>
							<td><form:input path="username" class="inputbox"/></td>
							<td><form:errors path="username" cssClass="error"/></td>
						</tr>
						
						<tr>
							<td><font size="5" color="white">Password:</font></td>
							<td><form:input path="password" class="inputbox"/></td>
							<td><form:errors path="password" cssClass="error"/></td>
						</tr>
						<tr>
							<td></td>
							<td><input type = "submit" value = "Register" class="btn btn-primary"/>
							<a href = "${pageContext.request.contextPath}" class="btn btn-primary" role = "button">Cancel</a></td>
							<td></td>
						</tr>
					</tbody>
			</table>
		</form:form>
	</div>
</div>
	
</body>
</html>