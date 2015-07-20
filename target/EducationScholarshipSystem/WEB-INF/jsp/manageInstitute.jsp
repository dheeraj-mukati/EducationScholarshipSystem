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
<h1>InstituteList</h1>
<h3 align="right">${success}</h3>
<table border="1">
	<tr>
		<td>Institute Name</td>
		<td>Email</td>
		<td>Address1</td>
		<td>Address2</td>
		<td>Address3</td>
		<td>Success Story</td>
		<td>Courses Offered</td>
		<td>Contact No1</td>
		<td>Contact No2</td>
		<td>Contact No2</td>
		<td>Passing Score</td>
	</tr>
<c:forEach items="${instituteList}" var="institute">
	<tr>
		<td><c:out value="${institute.instituteName }"/></td>
		<td><c:out value="${institute.email }"/></td>
		<td><c:out value="${institute.address1 }"/></td>
		<td><c:out value="${institute.address2 }"/></td>
		<td><c:out value="${institute.address3 }"/></td>
		<td><c:out value="${institute.successStory }"/></td>
		<td><c:out value="${institute.coursesOffered }"/></td>
		<td><c:out value="${institute.contactNo1 }"/></td>
		<td><c:out value="${institute.contactNo2 }"/></td>
		<td><c:out value="${institute.contactNo3 }"/></td>
		<td><c:out value="${institute.passingScore }"/></td>
		<td><a href="/EducationScholarshipSystem/deleteInstitute?instituteID=<c:out value="${institute.instituteID }"/>">Delete Institute</a></td>
	</tr>
</c:forEach>
</table>

</body>
</html>