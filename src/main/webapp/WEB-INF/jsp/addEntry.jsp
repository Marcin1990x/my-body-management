<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
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

                <input type="submit" class="btn" value="Add"/>
            </form:form>
        </div>
    </body>
</html>