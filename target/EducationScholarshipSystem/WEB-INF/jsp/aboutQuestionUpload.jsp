<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
            window.history.forward();
            function noBack() { window.history.forward(); }

            function validation(My_form)
            {
                if(!My_form.Term.checked)
                    {
                        alert("You must Read all the information first.");
                        return false;
                    }
                    else
                        return true;
            }

        </script>

</head>
<body>
<h1>Please Read this Information Carefully</h1>
        <ul>
            <li>This is the page where you can upload question's of your Scholoarship test.<br></li>
            <li>There will be 1 text area where you have to enter question.</li>
            <li>There will be 4 text field where you have to enter option's for that particular question.</li>
            <li>Then lastlly you have to select correct option by using drop down list.</li>
            <li>Make sure that all four option's have different values to continue.</li>
            <li>When you finished above all things, click on th "Next Ques." button.</li>
            <li>If question will successfully uploaded then you will get an acknowledge message for that question.</li>
            <li>You can not go for the next question untill you fill question , all 4 option and correct answer.</li>
            <li>Once you upload a question ,you can not go back for that question again so make sure to make all entries carefully.</li>
            <li>You can edit any question later by LogIn.</li>
            <li>You can upload maximum 10 question.</li>
            <li>You can end uploading Question's by clicking on "End with this ques" button.</li>
            
            
        </ul>
        Note:  Remember to select correct option for the question because Option1 will be selected by default.<br><br>

        <form action="/EducationScholarshipSystem/haveRead" name="My_form" onsubmit="return validation(My_form);">
            <input type="checkbox" name="Term">Have Readed all the information.
            <input type="submit" value="Continue">
        </form>

</body>
</html>