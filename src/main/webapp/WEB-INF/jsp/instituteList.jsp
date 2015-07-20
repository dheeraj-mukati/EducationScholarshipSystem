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
</script>
</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
<h1>InstituteList</h1>
<h3 align="right">${param.alreadyGiven}</h3>
<c:forEach items="${instituteList}" var="institute">
<a href="/EducationScholarshipSystem/instituteInformation?instituteId=<c:out value="${institute.instituteID }"/>"><c:out value="${institute.instituteName}"></c:out></br></a>
</c:forEach>

</body>
</html>