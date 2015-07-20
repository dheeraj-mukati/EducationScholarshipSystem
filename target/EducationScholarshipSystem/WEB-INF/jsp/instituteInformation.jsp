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

<h1>Institute Information</h1>
<table border="1">
   <tr>
   <td>Institute Name</td>
   <td>${institute.instituteName}</td>
   </tr>
   
   <tr>
   <td>Institute Email</td>
   <td>${institute.email}</td>
   </tr>
   
   <tr>
   <td>Institute Success Story</td>
   <td>${institute.successStory}</td>
   </tr>
   
   <tr>
   <td>Courses Offered by Institute</td>
   <td>${institute.coursesOffered}</td>
   </tr>
   
   <tr>
   <td>Address1</td>
   <td>${institute.address1}</td>
   </tr>
   
   <tr>
   <td>Address2</td>
   <td>${institute.address2}</td>
   </tr>
   
   <tr>
   <td>Address3</td>
   <td>${institute.address3}</td>
   </tr>
   
   <tr>
   <td>Contact No1</td>
   <td>${institute.contactNo1}</td>
   </tr>
   
   <tr>
   <td>Contact No2</td>
   <td>${institute.contactNo2}</td>
   </tr>
   
   <tr>
   <td>Contact No3</td>
   <td>${institute.contactNo3}</td>
   </tr>
</table>

<a href="/EducationScholarshipSystem/aboutTest?instituteId=${institute.instituteID}">Give scholarship test now</a>
</body>
</html>