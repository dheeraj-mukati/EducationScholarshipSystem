<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="/js/jquery_1.9.1.js"></script>
<script type="text/javascript">

window.history.forward();
function noBack() {  window.history.forward(); }

function valbutton(thisform)
{
	

    // place any other field validations that you require here
    // validate myradiobuttons
    myOption = -1;
    for (i=thisform.optionSelected.length-1; i > -1; i--)
    {

        if (thisform.optionSelected[i].checked)
        {

         myOption = i; i = -1;
        }
    }
    if (myOption == -1)
    {

    alert("You must select a answer.");
    return false;
    }
    else
        return true;
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

<form:form name="myForm" method="POST" action="/EducationScholarshipSystem/nextQuestion" commandName="result" onsubmit="return valbutton(myForm);">

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
 

<table>
    <tr>
	  <td><form:label path="question.question">Question No ${questionNo} </form:label></td>
	  <td><form:input path="question.question" /></td>
	</tr>
	
	<tr>
	  <td><form:label path="question.option1">Option1</form:label></td>
	  <td><form:radiobutton path="optionSelected" name="optionSelected" id="opiont1" value="${option1}" />${option1}</td>
	</tr>
	
	<tr>
	  <td><form:label path="question.option2">Option2</form:label></td>
	  <td><form:radiobutton path="optionSelected" name="optionSelected" id="opiont2"  value="${option2}" />${option2}</td>
	</tr>
	
	<tr>
	  <td><form:label path="question.option3">Option3</form:label></td>
	  <td><form:radiobutton path="optionSelected" name="optionSelected" id="opiont3" value="${option3}" />${option3}</td>
	</tr>
	
	<tr>
	  <td><form:label path="question.option4">Option4</form:label></td>
	  <td><form:radiobutton path="optionSelected" name="optionSelected" id="opiont4" value="${option4}" />${option4}</td>
	</tr>
	
	<tr> 
	<td><input type="submit" id="submitButton" value="Register"></input></td>
	</tr>
	</table>
	<form:hidden path="question.questionNo"/>
	<form:hidden path="questionNo" />
</form:form>
</body>
</html>