<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddMarks</title>
<link href="./cssfile/Addmarks.css" rel="stylesheet">

</head>
<body>
<h1>Enter <%=request.getParameter("standard") %> Class Details</h1><br>
<form action="SaveMarks" method="post">
Class:<input type="text" name="std" value=<%=request.getParameter("standard")%> readonly="readonly"><br>
Mathematics Marks:<input type="text" name="maths"><br>
English :<input type="text" name="english"><br>
Science :<input type="text" name="science"><br>
Kannada :<input type="text" name="kannada"><br>
Hindi :<input type="text" name="hindi"><br>
Social Science :<input type="text" name="socialscience"><br>
<br>
<button type="reset">Cancel</button>
<button type="submit">Save</button>
</form>
<br>
<a href="StudentHome.jsp"><button type="button">Home</button></a>
</form>

</body>
</html>