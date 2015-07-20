<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Admin Login</h2>
<form action="/EducationScholarshipSystem/loginSubmitAdminForm" method="post" >
<table>

	<tr>
		<td></td>
		<td>${error}</td>
	</tr>
	<tr>
		<td>User Name:</td>
		<td><input name="userName" type="text"/></td>
	</tr>
	
	<tr>
		<td>Password:</td>
		<td><input name="password" type="password"/></td>
	</tr>
	
	<tr>
		<td></td>
		<td><input  value="LogIn" type="submit"/></td>
	</tr>
</table>
</form>
</body>
</html>