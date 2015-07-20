<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="right"><h3>${success}</h3></div>
<h4 align="right">Welcome ${sessionScope.sessionInstitute.instituteName} | <a href="/EducationScholarshipSystem/instituteLogOut">Log Out</a></h4>
<h2><a href="/EducationScholarshipSystem/setUpeditInstituteForm">Edit Profile</a></h2>
<h2><a href="/EducationScholarshipSystem/instituteQuestionsList">Edit Questions</a></h2>
</body>
</html>