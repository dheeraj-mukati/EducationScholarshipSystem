<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#729328">
<h1>User List</h1>
<h3 align="right">${success}</h3>
<table border="1">
	<tr>
		<td>User Name</td>
		<td>Email</td>
		<td>Gender</td>
		<td>Address</td>
		<td>Contact No</td>
	</tr>
<c:forEach items="${userList}" var="user">
	<tr>
		<td><c:out value="${user.userName }"/></td>
		<td><c:out value="${user.email }"/></td>
		<td><c:out value="${user.gender }"/></td>
		<td><c:out value="${user.address }"/></td>
		<td><c:out value="${user.contNO }"/></td>
		<td><a href="/EducationScholarshipSystem/deleteUser?userID=<c:out value="${user.userID }"/>">Delete User</a></td>
	</tr>
</c:forEach>
</table>

</body>
</html>