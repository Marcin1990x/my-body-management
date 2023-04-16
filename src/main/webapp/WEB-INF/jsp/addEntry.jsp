<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="pl">
    <head>
        <meta charset="utf-8">
        <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
        <title>Add entry</title>
    </head>
    <body>
    <%@ include file="common/navigation_bar.jspf" %>
        <h1><center>Add entry</center></h1>
        <hr>
        <div class="container">
            <form:form method="post" modelAttribute="entry">
                <div class="form-group row">
                    <form:label class="form-label" path="entryDate">Date</form:label>
                    <form:input type="text" path="entryDate" required="required"/>
                    <form:errors path="entryDate" cssClass="text-warning"/>
                </div>
                <div class="form-group row">
                    <form:label class="form-label" path="weight">Weight</form:label>
                    <form:input type="text" path="weight" required="required"/>
                    <form:errors path="weight" cssClass="text-warning"/>
                </div>
                <div class="form-group row">
                    <form:label class="form-label" path="steps">Steps</form:label>
                    <form:input type="text" path="steps" required="required"/>
                    <form:errors path="steps" cssClass="text-warning"/>
                <div class="form-group row">
                    <form:label class="form-label" path="comment">Comment</form:label>
                    <form:input type="text" path="comment"/>
                    <form:errors path="comment" cssClass="text-warning"/>
                </div>
                    <form:input type="hidden" path="id"/>
                    <form:input type="hidden" path="username"/>
                <div class="form-group">
                    <input type="submit" class="btn btn-success" value="Add"/>
                </div>
            </form:form>
        </div>
        </script>
        <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.4/jquery.min.js"></script>
        <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
                <script type="text/javascript">
                    $('#entryDate').datepicker({
                    format: 'yyyy-mm-dd'
                    });
                </script>
    </body>
</html>

