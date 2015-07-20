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
/* window.history.forward();
function noBack() { window.history.forward(); } */
function validation()
{                
	
	var abc=document.getElementById('abcd').checked;
	if(!abc)
	{
		alert("You must Agree with Terms and Condition to give Scholarship Test.");
		return false;
	}
	else{
	return true;
	}
}

</script>
</head>
<body>
       <ul>
            <li>This is the scholarship test of <b>${institute.instituteName}</b> Institute.</li>
            <li>This is the Objective test and the test will contain total 10 question.</li>
            <li>Passing Score for scholarship test will be ${institute.passingScore}.</li>
            <li>One Question will appear at a time and you must have to select one option for that particular question.</li>
            <li>You can not go for the next question until you select an option for the question.</li>
            <li>After choosing correct option ,click on the "Next Ques." button.</li>
            <li>After clicking on the "Next Ques." ,the next question will automatically appear.</li>
            <li>You must do same for all the Question.</li>
            <li>You can not go back to the previous question once you click on the "Next Ques." button</li>
            <li>At the end of the Exam, there will be a Summary of your Scholarship test.</li>
            <li>This will show you all the question's and answer which you did in the test.</li>
            <li>There will be a hyperlink "Change Answer" for each question to change the answer.</li>
            <li>If you have any doubt about the answer you selected then by clicking on the hyperlink you can change the answer you selected before.</li>
            <li>If you have completed your Scholarship Test then just click on the "Finish" button.</li>
            <li>At the end,your score card will appear in the browser window which contain total no. of question,correct question and your score.</li>
            <li>Print this Score card by click on the "print" button and bring this to the <b>${institute.instituteName}</b> Institute for the fee concession.</li>
            <li>In the end Log Out your session.</li>
            <li>The <b>${institute.instituteName}</b> Institute may have their own "Terms and conditions" and our web site will not be responsible for that.</li>
            <li>The procedure of fee concession after the Scholarship Test will be handled by the <b>${institute.instituteName}</b> Institute.</li>
        </ul>
        
        Note: There will be no negative marking.<br><br>
        
       <%-- <form action="/EducationScholarshipSystem/test" name="My_form" onsubmit="return validation(My_form);">
       <input type="checkbox" name="IName" />Agree to the Terms and Condition.
       <input type="submit"  value="Continue">    
       </form> --%>
       <input type="checkbox" id="abcd" />Agree to the Terms and Condition.
       <a href="/EducationScholarshipSystem/test?instituteId=${institute.instituteID}" onclick="return validation();" >Continue</a>
       
</body>
</html>