<%@ include file="common/header.jspf" %>

        <title>Add entry</title>
    </head>
    <body>
    <%@ include file="common/navigation_bar.jspf" %>
        <h1><center>Add entry</center></h1>
        <hr>
        <div class="container">
            <form:form method="post" modelAttribute="entry">
                <div class="form-group row">
                    <form:label class="form-label" path="entryDate">Date:</form:label>
                    <form:input type="text" path="entryDate" required="required"/>
                    <form:errors path="entryDate" cssClass="text-warning"/>
                </div>
                <div class="form-group row">
                    <form:label class="form-label" path="weight">Weight:</form:label>
                    <form:input type="text" path="weight" required="required"/>
                    <form:errors path="weight" cssClass="text-warning"/>
                </div>
                <div class="form-group row">
                    <form:label class="form-label" path="steps">Steps:</form:label>
                    <form:input type="text" path="steps" required="required"/>
                    <form:errors path="steps" cssClass="text-warning"/>
                </div>
                <div class="form-group row">
                    <form:label class="form-label" path="comment">Comment:</form:label>
                    <form:input type="text" path="comment"/>
                    <form:errors path="comment" cssClass="text-warning"/>
                </div>
                <div class="form-group row">
                    <form:input type="hidden" path="id"/>
                    <form:input type="hidden" path="username"/>
                </div>
                <div class="form-group row">
                    <hr>
                    <input type="submit" class="btn btn-success" value="Add"/>
                </div>
            </form:form>
        </div>

        <%@ include file="common/footer.jspf" %>

                <script type="text/javascript">
                    $('#entryDate').datepicker({
                    format: 'yyyy-mm-dd'
                    });
                </script>

