<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subreddits</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<style type="text/css">
	
		.heading{
			text-align: center;
			
		}
	
		.image{
		
		}
		
		.content{
			vertical-align:top;
			width: auto;
		}
		
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
		
		hr{
			height:2px;
			border-width:0;
			color:gray;
			background-color:gray;
		}
		
	</style>
</head>
<body style="background-color: #DCDCDC">
	<h2 align="center"><font color = "green">Selected profile - <u>${theProfile}</u></font></h2>
	
	<hr>
	<a href="${pageContext.request.contextPath}/showProfile/addSubreddit" class="btn btn-success" role = "button">Add Subreddit</a>
	<a href="${pageContext.request.contextPath}/userProfile/welcome" class="btn btn-primary" role = "button">Profiles page</a>
	<hr>
	
	<c:forEach var = "dataItem" items = "${dataList}">
		<div class = "heading">
			<form action="${pageContext.request.contextPath}/showProfile/deleteSubreddit" method = "GET">
				<font size="6" color="red">r/${dataItem[0].subreddit}</font> &ensp;
				<input type = "hidden" name = "subredditName" value = "${dataItem[0].subreddit}"/>
	    		<input type="submit" value="Delete" class="btn btn-danger"/>
			</form>
		</div>
		<br>
		<br>
		<c:forEach var = "thePost" items = "${dataItem}">
			<table class = "theTable">
				
				<tr>
					<td class = "image"><img width="300" height = "300" src="${thePost.url_overridden_by_dest}" alt = "Not found" onerror=this.src="${pageContext.request.contextPath}/resources/reddit-banner.png"></td>
					<td class = "content">
						<font size = "5"><a href = "${thePost.permalink}">${thePost.title}</a></font>
						<br>
						<!--  <p><font size = "4">${thePost.selftext}</font></p> -->
						<p><font size = "4">${thePost.selftext}</font></p>
						<br>
						<pre><font size = "4" color="grey">Score: ${thePost.score}    Comments: ${thePost.num_comments}</font></pre>
					</td>
				</tr>
				
			</table>
			<hr>
		</c:forEach>
		<hr>
		<hr>
	</c:forEach>
	
</body>
</html>