<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>User Login Here</h1>
<table>
<form:form method="POST" action="/EducationScholarshipSystem/checkUser" commandName="user">

	<tr>
	  <td><form:label path="email">Email :</form:label></td>
	  <td><form:input path="email"/></td>
	  <td><form:errors path="email" ></form:errors></td>
	</tr>
	
	<tr>
	<td><form:label path="password">Password :</form:label></td>
	<td><form:password path="password"/></td>
	<td><form:errors path="password" ></form:errors></td>
	</tr>
	
	<tr> 
	<td><input type="submit" value="LogIn"></input></td>
	<td><a href="/EducationScholarshipSystem/createUser">Create Account Here</a></td>
	</tr>
</form:form>
</table>
</body>
</html>