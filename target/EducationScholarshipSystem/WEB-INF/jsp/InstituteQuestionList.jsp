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
<body>
<h1>Question List</h1>
<h3 align="right">${param.success}</h3>
<table border="1">
	<tr>
		<td>Question No</td>
		<td>Question</td>
		<td>Option 1</td>
		<td>Option 2</td>
		<td>Option 3</td>
		<td>Option 4</td>
		<td>Correct Option</td>
	</tr>
<c:forEach items="${questionsList}" var="question">
	<tr>
		<td><c:out value="${question.questionNo }"/></td>
		<td><c:out value="${question.question }"/></td>
		<td><c:out value="${question.option1 }"/></td>
		<td><c:out value="${question.option2 }"/></td>
		<td><c:out value="${question.option3 }"/></td>
		<td><c:out value="${question.option4 }"/></td>
		<td><c:out value="${question.correctOption }"/></td>
		<td><a href="/EducationScholarshipSystem/setUpeditQuestionForm?questionNo=<c:out value="${question.questionNo }"/>">Edit Question</a></td>
	</tr>
</c:forEach>
</table>

</body>
</html>