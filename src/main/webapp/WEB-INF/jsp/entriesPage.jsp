
<%@ include file="common/header.jspf" %>

        <title>Entries page</title>

        <style>
            a[href$="page=${activePage}"]{
                background-color: #f7cac9;
            }
        </style>

    </head>
    <body>
    <%@ include file="common/navigation_bar.jspf" %>
    <div class="container">
        <h1>Entries page</h1>
        <hr>
            <a href="add-entry" class="btn btn-success">Add entry</a>
        <hr>
            <table class="table">
                <tbody>
                    <thead>
                        <tr>
                            <th>ENTRY DATE</th>
                            <th>WEIGHT</th>
                            <th>STEPS</th>
                            <th>COMMENT</th>
                            <th>DELETE</th>
                            <th>UPDATE</th>
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

        <%@ include file="paginationButtons.jspf" %>

    </div>
<%@ include file="common/footer.jspf" %>