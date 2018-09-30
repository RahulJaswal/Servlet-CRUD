<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="Center">Login page!</h1>
	<form action ="Check" method="get" align="center">
	Login Id <input type="text" name="id"><br><br>
	Password <input type="password" name="pwd"><br>
	<input type=submit value="login" name="call">
	<input type="submit" value="Delete" name="call">
	</form>
	
	<form align="center" action="Register.jsp">
	<input type="submit" value="Register"   >
	</form>

	<form align="center" action="Check">
	</form>

</body>
</html>