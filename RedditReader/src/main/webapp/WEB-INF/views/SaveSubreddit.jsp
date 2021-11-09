<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Save Subreddit</title>
	<script>
	   function checkingInput() {
	      var subreddit = document.forms["subreddit"]["theSubreddit"].value;
	      if (subreddit == null || subreddit.trim() == "") {
	         alert("Please enter > the subreddit name. Can't be blank or empty !!!");
	         return false;
	      }
	   }
	</script>
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
<!-- <body>
<h2>Welcome - ${theUsername}</h2>
<br>
<h2>Add subreddit for Profile - ${theProfile}</h2>
<br>
	<c:if test="${errorMessage != null}">
		 <h3><font color="red">${errorMessage}</font></h3>
	</c:if>
	
	<form:form action = "${pageContext.request.contextPath}/showProfile/saveSubreddit" method = "POST" name = "subreddit" onsubmit="return checkingInput()">
		<input type = "text" name = "theSubreddit" required="required"/>
		<br>
	<input type = "submit" value = "Save"/>
</form:form>
</body>
</html> -->
<body style="background-color: #272727">
<div class = "tophead">Add subreddit for profile - ${theProfile}</div>
<div class = "content">
	
		<c:if test="${errorMessage != null}">
			 <h3><font color="red">${errorMessage}</font></h3>
		</c:if>
	<form:form action = "${pageContext.request.contextPath}/showProfile/saveSubreddit" method = "POST" name = "subreddit" onsubmit="return checkingInput()">
		<font size="5" color="white">Subreddit name: </font><br>
		<input type = "text" name = "theSubreddit" required="required"/>
		<br><br>
		<input type = "submit" value = "Save" class="btn btn-success"/>
		<a href="${pageContext.request.contextPath}/showProfile/mySubreddits" class="btn btn-danger" role = "button">Cancel</a>
	</form:form>
</div>
</body>
</html>