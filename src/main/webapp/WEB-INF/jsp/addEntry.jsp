<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
        <title>Add entry</title>
    </head>
    <body>
        <h1>Add entry</h1>
        <div class="container">
            <form:form method="post" modelAttribute="entry">
                    <form:label path="entryDate">Date</form:label>
                    <form:input type="text" path="entryDate" required="required"/>

                    <form:label path="weight">Weight</form:label>
                    <form:input type="text" path="weight" required="required"/>

                    <form:label path="steps">Steps</form:label>
                    <form:input type="text" path="steps" required="required"/>

                    <form:label path="comment">Comment</form:label>
                    <form:input type="text" path="comment"/>

                    <form:input type="hidden" path="id"/>
                    <form:input type="hidden" path="username"/>

                <input type="submit" class="btn btn-success" value="Add"/>
            </form:form>
        </div>
        <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.4/jquery.min.js"></script>
        <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    </body>
</html>