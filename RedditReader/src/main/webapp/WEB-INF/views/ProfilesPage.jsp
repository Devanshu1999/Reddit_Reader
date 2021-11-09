<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Profiles</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<style type="text/css">
		.tophead{
			margin-top: 1%;
			text-align: center;
			font-style: italic;
			font-size: 55.2px;
  			font-weight: 700;
  			color: #FF5733;
  			font-family: Segoe UI;
		}
		
		.tablehead{
			color: white;
			font-size: 30px;
			font-family: sans-serif;	
			text-align: center;
			background-color: #067B25;
		}
		
		.table{
			border-collapse: collapse;
			margin: 25px 0;
			color: white;
			font-family: sans-serif;
			min-width: 200px;
			box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);	
		}
		
		.tdata{
			font-size: 20px;
			text-align: center;
		}
		
	</style>
</head>
<body style="background-color: #272727">
<div class = "tophead">
	WELCOME - ${theUsername} 
	&emsp;<a href = "${pageContext.request.contextPath}/showLoginPage" class="btn btn-danger" role = "button">Logout</a>
</div>
<hr>
<a href="${pageContext.request.contextPath}/userProfile/addProfilePage" class="btn btn-primary" role = "button">Add Profile</a>
<hr>
<table class = "table">
	<tr>
		<td class = "tablehead">Profiles</td>
		<td class = "tablehead">Action</td>
	</tr>
	<c:forEach var = "profile" items="${theProfiles}">
		<c:url var = "renameLink" value = "/userProfile/renameProfile">
			<c:param name="profile" value = "${profile}"/>
		</c:url>
		
		<c:url var = "deleteLink" value = "/userProfile/deleteProfile">
			<c:param name="profile" value = "${profile}"/>
		</c:url>
		
		<c:url var = "displayLink" value = "/showProfile/initializing">
			<c:param name="profile" value = "${profile}"/>
		</c:url>
		
		<tr>
			<td class = "tdata">${profile}</td>
			<td class = "tdata"><a href = "${displayLink}" class="btn btn-success" role = "button">Go!!</a>
							|
				<a href = "${renameLink}" class="btn btn-primary" role = "button">Rename</a> <!-- "renameLink" is same as defined above -->
							|
				<a href = "${deleteLink}" class="btn btn-danger" role = "button"
						  onClick = "if (!(confirm('Sure to delete customer?'))) return false">Delete</a>
			</td>
		</tr>
		
	</c:forEach>
	
	<tr>
		<td>
			<c:if test="${errorMessage != null}">
	 			<h3><font color="red">${errorMessage}</font></h3>
			</c:if>
		</td>
		<td></td>
	</tr>
</table>
</body>
</html>