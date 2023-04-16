<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pl">
    <head>
        <meta charset="utf-8">
        <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
        <title>Entries page</title>
    </head>
    <body>
    <%@ include file="common/navigation_bar.jspf" %>
    <div class="container">
        <h1>Entries page</h1>
            <table class="table">
                <tbody>
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>USERNAME</td>
                            <td>ENTRY DATE</td>
                            <td>WEIGHT</td>
                            <td>STEPS</td>
                            <td>COMMENT</td>
                        </tr>
                    </thead>
                <c:forEach items="${entriesList}" var="entry">
                    <tr>
                        <td>${entry.id}</td>
                        <td>${entry.username}</td>
                        <td>${entry.entryDate}</td>
                        <td>${entry.weight}</td>
                        <td>${entry.steps}</td>
                        <td>${entry.comment}</td>
                        <th><a href="delete-entry?id=${entry.id}" class="btn btn-danger">Delete entry</a></th>
                        <th><a href="update-entry?id=${entry.id}" class="btn btn-warning">Edit entry</a></th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="add-entry" class="btn btn-success">Add entry</a>

            <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
            <script src="webjars/jquery/3.6.4/jquery.min.js"></script>
            <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
        </div>
    </body>
</html>