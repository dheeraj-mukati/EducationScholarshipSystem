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
<script type="text/javascript">
function noBack() {  window.history.forward(); }
function printpage()
{
window.print();
}
</script>
</head>
<body  onload="noBack();" onpageshow="if (event.persisted) noBack();">
<h3 align="center">${sessionScope.authInstitute.instituteName} Scholarship Test</h3>
<h3 align="right">Welcome ${sessionScope.authUser.userName} | <a href="/EducationScholarshipSystem/logOut">Log out</a></h3 >

<h1> Result </h1>
<table border="1">
  <tr>
  	<td>User Name</td>
  	<td>Institute Name</td>
  	<td>Total Question </td>
  	<td>Correct Question</td>
  	<td>Your Score</td>
  	<td>Passing Score</td>
  	<td>Result</td>
  	<td>Exam Date</td>
  	<td><input type="button" value="Print Score Card" onclick="printpage();"></td>
  </tr>
  
  <tr>
  	<td>${userName}</td>
  	<td>${instituteName}</td>
  	<td>${totalQuestion}</td>
  	<td>${attemptedQuestion}</td>
  	<td>${yourScore}</td>
  	<td>${passingScore}</td>
  	<td>${result}</td>
  	<td>${examDate}</td>
  	<td></td>
  </tr>
</table>
</body>
</html>