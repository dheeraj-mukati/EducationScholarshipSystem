<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

window.history.forward();
function noBack() {  window.history.forward(); }


function submitForm(qID){
	
	
	document.getElementById('questionID').value=qID;
	var a=document.getElementById('questionID').value;
	
	document.getElementById("myForm").submit();

}


var mins,secs,TimerRunning,TimerID;
TimerRunning=false;

function Init(min,sec) //call the Init function when u need to start the timer
{
	
    mins=min;
    secs=sec;
    StopTimer();
    StartTimer();
}

function StopTimer()
{
    if(TimerRunning)
    clearTimeout(TimerID);
    TimerRunning=false;
}

function StartTimer()
{
    TimerRunning=true;
    document.getElementById('t1').value=Pad(mins);
    document.getElementById('t2').value=Pad(secs);

    TimerID=self.setTimeout("StartTimer()",1000);

    Check();

    if(mins==0 && secs==0)
    StopTimer();

    if(secs==0)
    {
        mins--;
        secs=60;
    }
    secs--;

}

 function Check()
{
    if(mins==1 && secs==0)
   alert("You have only one minutes remaining");
    else if(mins==0 && secs==0)
    {
        alert("Time is Over");
        window.location="/EducationScholarshipSystem/resultProcess";
    }
}

function Pad(number) //pads the mins/secs with a 0 if its less than 10
{
    if(number<=10)
    number=0+""+number;
    return number; 
}


</script>
</head>
<body onload="noBack(); Init('${min}','${sec}');" onpageshow="if (event.persisted) noBack();" onunload="">
<h3 align="center">${sessionScope.authInstitute.instituteName} Scholarship Test</h3>
<h3 align="right">Welcome ${sessionScope.authUser.userName}</h3>


<form:form method="POST" id="myForm"  action="/EducationScholarshipSystem/changeAnswer" commandName="result">

<div align="right">
<table>
<tr>
<td>
Time Remaining</td>
<td width="20"> <input type="text" id="t1" name="min" maxlength="2" size="2" value="${min}" readonly/></td>
<td>:</td>
<td width="20">
<input type="text" id="t2" name="sec" value="${sec}" maxlength="2" size="2"  readonly/>
</td>
</tr>
</table>

</div> 
<form:hidden id="questionID" path="question.questionID"/>

<h3>${answerChanged}</h3>

<table border="1">
 	<tr>
		<td>Question No.</td>
		<td>Question</td>
		<td>option1</td>
		<td>option2</td>
		<td>option3</td>
		<td>option4</td>
		<td>Selected Option</td>
		<td>Action</td>
	</tr>
<c:forEach var="results" items="${results}">
<tr>
		<td><c:out value="${results.question.questionNo}"></c:out></td>
		<td><c:out value="${results.question.question}"></c:out></td>
		<td><c:out value="${results.question.option1}"></c:out></td>
		<td><c:out value="${results.question.option2}"></c:out></td>
		<td><c:out value="${results.question.option3}"></c:out></td>
		<td><c:out value="${results.question.option4}"></c:out></td>
		<td><c:out value="${results.optionSelected}"></c:out></td>
		<td><input type="button" value="Change Answer" onclick="submitForm('${results.question.questionID}')" /></td>
	</tr>
</c:forEach>
</table>
</br>
<a href="/EducationScholarshipSystem/resultProcess">Finish Exam</a>
</form:form>
</body>
</html>