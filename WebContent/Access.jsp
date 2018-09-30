<%@ page import="com.project.DaoLayer" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(session.getAttribute("user")==null)
{
	response.sendRedirect("join.html");
}
%>

<%String st=(String)session.getAttribute("user");
DaoLayer obj=(DaoLayer)session.getAttribute("obj");		//type cast because getAttribute will give me object of object class
%>

<%
	if(obj.marks<1)			//flag if user does not exist
	{
		response.sendRedirect("join.html");
	}
%>
	<%if (session.getAttribute("mode") == "Register" && obj.flag==true) //to check which page is requesting 
	{
		out.print("You are registered successfully! ");
		 out.print("Welcome"+st); 
		out.print("Your marks are "+obj.marks); 
	}
	
	else if(session.getAttribute("mode")=="Register" && obj.flag !=true)  //if user already exists
	{
		response.sendRedirect("error.jsp");
	}
	
	else if(session.getAttribute("mode")=="delete" && obj.flag==true)   //account deleted 
	{
		out.print("Record deleted Successfully");
	}
	else if (session.getAttribute("mode")=="delete" && obj.flag==false)
	{
		response.sendRedirect("error.jsp");
	}
	%>
	
	<%
	if(session.getAttribute("mode")=="login")                          //login successfully
	{
		out.print("You are logged in successfulyl!");
		 out.print("Welcome"+st); 
		out.print("Your marks are "+obj.marks); 
	}
		%>

		
	
<form action="Logout" method="get" >
<input type="submit" value="Log-out">
</form>

</body>
</html>