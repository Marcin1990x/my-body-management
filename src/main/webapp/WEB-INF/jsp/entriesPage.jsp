<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
        <title>Entries page</title>
    </head>
    <body>
    <h1>Entries page</h1>
        <table>
            <tbody>
                <tr>
                    <td>ID</td>
                    <td>USERNAME</td>
                    <td>ENTRY DATE</td>
                    <td>WEIGHT</td>
                    <td>STEPS</td>
                    <td>COMMENT</td>
                </tr>
            <c:forEach items="${entriesList}" var="entry">
                <tr>
                    <td>${entry.id}</td>
                    <td>${entry.username}</td>
                    <td>${entry.entryDate}</td>
                    <td>${entry.weight}</td>
                    <td>${entry.steps}</td>
                    <td>${entry.comment}</td>
                    <td><a href="delete-entry?id=${entry.id}"><button>Delete entry</button></a></td>
                    <td><a href="update-entry?id=${entry.id}"><button>Edit entry</button></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="add-entry"><button>Add entry</button></a>

        <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.4/jquery.min.js"></script>
        <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    </body>
</html>