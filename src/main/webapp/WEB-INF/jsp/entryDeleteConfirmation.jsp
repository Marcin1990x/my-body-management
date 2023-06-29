<%@ include file="common/header.jspf" %>

        <title>First Page</title>
    </head>
    <body>
        <%@ include file="common/navigation_bar.jspf" %>

        <center>

            <h2>Are you sure you want to delete this entry?</h2>

            <hr></hr>

            <a href="entries" class="btn btn-success">No</a>
            <a href="delete-entry?id=${idToDelete}" class="btn btn-danger">Yes</a>
        </center>

        <%@ include file="common/footer.jspf" %>