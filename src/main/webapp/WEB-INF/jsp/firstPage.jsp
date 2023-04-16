<%@ include file="common/header.jspf" %>

        <title>First Page</title>
    </head>
    <body>
        <%@ include file="common/navigation_bar.jspf" %>

        <center>
        <h1>Welcome ${username} !</h1>
        <hr>
        <a href="entries" class="btn btn-success">Show daily entries</a>
        </center>

        <%@ include file="common/footer.jspf" %>