<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Welcome!!</title>
	<style>
		body {
			background-image: url("${pageContext.request.contextPath}/resources/HomePage.jpg");
			background-repeat: no-repeat;
			background-attachment: fixed;
			background-size: 100% 100%;
		}
		
		#operations{
			padding-left: 70%;
			padding-top: 10%;
		}
		
		.welcome{
			margin-top: 1%;
			text-align: center;
			font-style: italic;
			font-size: 55.2px;
  			font-weight: 700;
  			color: #FF5733;
  			font-family: Segoe UI;
		}
		
		.button {
			display: inline-block;
			border-radius: 4px;
			background-color: #f4511e;
			border: none;
			color: #FFFFFF;
			text-align: center;
			font-size: 28px;
			padding: 20px;
			width: 200px;
			transition: all 0.5s;
			cursor: pointer;
			margin: 5px;
		}

		.button span {
			cursor: pointer;
			display: inline-block;
			position: relative;
			transition: 0.5s;
		}

		.button span:after {
			content: '\00bb';
			position: absolute;
			opacity: 0;
			top: 0;
			right: -20px;
			transition: 0.5s;
		}
		
		.button:hover span {
			padding-right: 25px;
		}
		
		.button:hover span:after {
			opacity: 1;
			right: 0;
		}
	</style>
</head>
<body>
	<div class = "welcome">WELCOME TO YOUR CUSTOM REDDIT APP</div>
	<br>
	<div id = "operations">
		<a href = "${pageContext.request.contextPath}/showLoginPage"><button class="button" style="vertical-align:middle"><span>LOGIN </span></button></a>
		<br>
		<br>
		<a href = "${pageContext.request.contextPath}/register"><button class="button" style="vertical-align:middle"><span>REGISTER </span></button></a>
	</div>
</body>
</html>