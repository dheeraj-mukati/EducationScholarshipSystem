<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="/js/jquery_1.9.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$("#cno1,#cno2,#cno3,#pc").keydown(function(event) {
    // Allow: backspace, delete, tab, escape, and enters
    if ( event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 27 || event.keyCode == 13 ||
         // Allow: Ctrl+A
        (event.keyCode == 65 && event.ctrlKey === true) ||
         // Allow: home, end, left, right
        (event.keyCode >= 35 && event.keyCode <= 39)) {
             // let it happen, don't do anything
             return;
    }
    else {
        // Ensure that it is a number and stop the keypress
        if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) {
            event.preventDefault();
        }  
    }
});
});
</script>
</head>
<body>
<h1>Institute Registration</h1>
<table>
<form:form method="POST" action="/EducationScholarshipSystem/saveInstitute" commandName="institute">

	<tr>
	  <td><form:label path="instituteName">Institute Name:</form:label></td>
	  <td><form:input path="instituteName"/></td>
	  <td><form:errors path="instituteName" ></form:errors></td>
	</tr>
	
	<tr>
	<td><form:label path="email">Email:</form:label></td>
	<td><form:input path="email"/></td>
	<td><form:errors path="email" ></form:errors></td>
	</tr>
	
	<tr>
	<td><form:label path="password">Password:</form:label></td>
	<td><form:password path="password"/></td>
	<td><form:errors path="password" ></form:errors></td>
	</tr>
	
	<tr>
	<td><form:label path="confirmPassword">Confirm Password:</form:label></td>
	<td><form:password path="confirmPassword"/></td>
	<td><form:errors path="confirmPassword" ></form:errors></td>
	</tr>
	
	<tr>
	<td><form:label path="address1">Address 1:</form:label></td>
	<td><form:textarea path="address1"/></td>
	<td><form:errors path="address1" ></form:errors></td>
	</tr>
	
	<tr>
	<td><form:label path="address2">Address 2:</form:label></td>
	<td><form:textarea path="address2"/></td>
	<td><form:errors path="address2" ></form:errors></td>
	</tr>
	
	<tr>
	<td><form:label path="address3">Address 3:</form:label></td>
	<td><form:textarea path="address3"/></td>
	<td><form:errors path="address3" ></form:errors></td>
	</tr>
	
	<tr>
	<td><form:label path="successStory">Success Story :</form:label></td>
	<td><form:textarea path="successStory"/></td>
	<td><form:errors path="successStory" ></form:errors></td>
	</tr>
	
	<tr>
	<td><form:label path="coursesOffered">Courses Offered :</form:label></td>
	<td><form:textarea path="coursesOffered"/></td>
	<td><form:errors path="coursesOffered" ></form:errors></td>
	</tr>
	
	
	<tr>
	  <td><form:label path="contactNo1">Contact No1:</form:label></td>
	  <td><form:input id="cno1" path="contactNo1" maxlength="10"/></td>
	  <td><form:errors path="contactNo1" ></form:errors></td>
	</tr>
	
	<tr>
	  <td><form:label path="contactNo2">Contact No2:</form:label></td>
	  <td><form:input id="cno2" path="contactNo2" maxlength="10"/></td>
	  <td><form:errors path="contactNo2" ></form:errors></td>
	</tr>
	
	<tr>
	  <td><form:label path="contactNo3">Contact No3:</form:label></td>
	  <td><form:input id="cno3" path="contactNo3" maxlength="10"/></td>
	  <td><form:errors path="contactNo3" ></form:errors></td>
	</tr>
	
	<tr>
	  <td><form:label path="passingScore">Passing Score :</form:label></td>
	  <td><form:input id="pc" path="passingScore" maxlength="2"/></td>
	  <td><form:errors path="passingScore" ></form:errors></td>
	</tr>
	
	<tr> 
	<td><input type="submit" value="Register"></input></td>
	</tr>
</form:form>
</table>
</body>
</html>