<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="dto.MarksCard"%>
<%@page import="java.util.List"%>
<%@page import="dto.Student"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Select Marks Card</title>
	<link rel="stylesheet" href="./cssfile/SelectMarkscard.css">
</head>
<body>
	<div id="smc">
		<%
			Student student = (Student)session.getAttribute("student");
			List<MarksCard> list = student.getCards();
		%>
		<form action="MarksCard.jsp">
			<label for="std">Select Marks Card:</label>
			<select name="std" id="std">
				<%
					for (MarksCard card : list) {
						if (card.isStatus()) {
				%>
				<option value="<%= card.getStandard() %>"><%= card.getStandard() %></option>
				<%
						}
					}
				%>
			</select>
			<br><br>
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>








