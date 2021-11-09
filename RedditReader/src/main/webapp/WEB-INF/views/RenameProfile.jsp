<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Rename Profile</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<style type="text/css">
		.tophead{
			margin-top: 1%;
			text-align: center;
			font-style: italic;
			font-size: 35.2px;
  			font-weight: 700;
  			color: #FF5733;
  			font-family: Segoe UI;
		}
		
		.content{
			
			padding-left: 43%;
			justify-content: center;
			padding-top: 10%;
		}
		
		input[type=text] {
			background-color: #D3D3D3;
		}
		
		input[type=text]:focus {
			border: 3px solid #555;
		}
		
	</style>
</head>
<body style="background-color: #272727">
<div class = "tophead">RENAME PROFILE <br> Old profile name - ${oldProfile}</div>
<div class = "content">
	
		<c:if test="${errorMessage != null}">
			 <h3><font color="red">${errorMessage}</font></h3>
		</c:if>
	<form:form action = "${pageContext.request.contextPath}/userProfile/saveNewProfile" method = "POST" modelAttribute = "oldProfile">
		<input type = "hidden" name = "oldProfile" value = "${oldProfile}"/>
		<font size="5" color="white">New profile name: </font><br>
		<input type = "text" name = "newProfile" />
		<br><br>
		<input type = "submit" value = "Save" class="btn btn-success"/>
		<a href="${pageContext.request.contextPath}/userProfile/welcome" class="btn btn-danger" role = "button">Cancel</a>
	</form:form>
</div>
</body>
</html>