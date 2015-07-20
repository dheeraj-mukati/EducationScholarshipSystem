<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$("#cno").keydown(function(event) {
    // Allow: backspace, delete, tab, escape, and enter
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
<h3>User Registration</h3>
<table>
<form:form method="POST" action="/EducationScholarshipSystem/saveUser" commandName="user">


    <tr>
	  <td><form:label path="email">Email :</form:label></td>
	  <td><form:input path="email"/></td>
	  <td><span style="color:red"><form:errors path="email" ></form:errors></span></td>
	</tr>
	<tr>
	  <td><form:label path="userName">User Name :</form:label></td>
	  <td><form:input path="userName"/></td>
	  <td><span style="color:red"><form:errors path="userName" ></form:errors></span></td>
	</tr>
	<tr>
	<td><form:label path="password">Password :</form:label></td>
	<td><form:password path="password"/></td>
	<td><span style="color:red"><form:errors path="password" ></form:errors></span></td>
	</tr>
		<tr>
	<td><form:label path="confirmPassword">Password :</form:label></td>
	<td><form:password path="confirmPassword"/></td>
	<td><span style="color:red"><form:errors path="confirmPassword" ></form:errors></span></td>
	</tr>
	<tr>
	<td>Gender :</td>
	<td><form:radiobutton path="gender" value="Male" label="M" /><form:radiobutton path="gender" value="Female" label="F" /></td>
	<td><span style="color:red"><form:errors path="gender" ></form:errors></span></td>
	</tr>
	<tr>
	<td><form:label path="address">Address :</form:label></td>
	<td><form:textarea path="address"/></td>
	<td><span style="color:red"><form:errors path="address" ></form:errors></span></td>
	</tr>
	<tr>
	  <td><form:label path="contNO">contactNo :</form:label></td>
	  <td><form:input id="cno" path="contNO" maxlength="15"/></td>
	  <td><span style="color:red"><form:errors path="contNO" ></form:errors></span></td>
	</tr>
	<tr> 
	<td><input type="submit" value="Register"></input></td>
	</tr>
</form:form>
</table>
</body>
</html>