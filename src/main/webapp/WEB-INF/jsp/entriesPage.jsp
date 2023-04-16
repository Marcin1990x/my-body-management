
<%@ include file="common/header.jspf" %>

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
                            <td>ENTRY DATE</td>
                            <td>WEIGHT</td>
                            <td>STEPS</td>
                            <td>COMMENT</td>
                        </tr>
                    </thead>
                <c:forEach items="${entriesList}" var="entry">
                    <tr>
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
    </div>
<%@ include file="common/footer.jspf" %>