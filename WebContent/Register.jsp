<%@ page import="com.project.DaoLayer" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<% session.setAttribute("mode","Register"); %>
<form action="Check"  method="get">
	Name: <input type="text" name="id"><br><br>
	Password:<input type="text" name="pwd"><br><br>
	Marks:<input type="text" name="marks"><br>
	<input type="submit" value="Submit">
	
	



</form>
</head>
<body>

</body>
</html>