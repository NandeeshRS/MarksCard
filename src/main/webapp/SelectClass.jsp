<%@page import="dto.Student"%>
<%@page import="controller.StudentSignup"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Select Class to Add Marks</title>
	<link href="./cssfile/Selectclass.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<header>
			<h1>Select Class for Which You Want to Add Marks</h1>
		</header>
		
		<main>
			<%Student student=(Student)session.getAttribute("student"); 
			int std=student.getStandard();
			%>
			<form action="AddMarks.jsp">
				<label>Select Class:</label>
				<select name="standard">
					<option>8</option>
					<%if(std>8) {%>
					<option>9</option>
					<% }%>
					<%if(std>9) {%>
					<option>10</option>
					<% }%>
				</select>
				<br>
				<button type="submit">Submit</button>
			</form>
			<br>
			<a href="StudentHome.jsp"><button>Home</button></a>
		</main>
		
		<footer>
			<p>&copy; 2023 School Name. All rights reserved.</p>
		</footer>
	</div>
</body>
</html>
