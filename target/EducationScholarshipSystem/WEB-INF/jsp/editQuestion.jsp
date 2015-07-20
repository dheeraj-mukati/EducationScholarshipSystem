<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Create Account</h3>
<h3 align="right">${param.success}</h3>
<table>
<form:form method="POST" name="myForm" id="myForm" action="/EducationScholarshipSystem/submitEditQuestionForm" commandName="question">

    <tr>
    <td></td>
    <td><form:errors path="questionNo" ></form:errors></td>
    <td></td>
    </tr>
    <tr>
	  <td><form:label path="question">Enter Question No ${quetionno} </form:label></td>
	  <td><form:input path="question"/></td>
	  <td><form:errors path="question" ></form:errors></td>
	</tr>
	<tr>
	  <td><form:label path="option1">Option1</form:label></td>
	  <td><form:input id="op1" path="option1"/></td>
	  <td><form:errors path="option1" ></form:errors></td>
	</tr>
	
	<tr>
	  <td><form:label path="option2">Option2</form:label></td>
	  <td><form:input id="op2" path="option2"/></td>
	  <td><form:errors path="option2" ></form:errors></td>
	</tr>
	
	<tr>
	  <td><form:label path="option3">Option3</form:label></td>
	  <td><form:input id="op3" path="option3"/></td>
	  <td><form:errors path="option3" ></form:errors></td>
	</tr>
	
	<tr>
	  <td><form:label path="option4">Option4</form:label></td>
	  <td><form:input id="op4" path="option4"/></td>
	  <td><form:errors path="option4" ></form:errors></td>
	</tr>
	<tr>
	<td><form:label path="correctOption">Option4</form:label></td>
	<td>
	<form:select id="optionlist" path="correctOption">
	<form:option value="-1">Choose One</form:option>
	 <form:option value="op1">Option 1</form:option>
	 <form:option value="op2">Option 2</form:option>
	 <form:option value="op3">Option 3</form:option>
	 <form:option value="op4">Option 4</form:option>
	</form:select>
	</td>
	<td><form:errors path="correctOption" ></form:errors></td>
	</tr>
	<tr> 
	<td><input type="submit" value="Register"></input></td>
	
	</tr>
</form:form>
</table>
</body>
</html>