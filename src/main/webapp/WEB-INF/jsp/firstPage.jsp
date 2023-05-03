<%@ include file="common/header.jspf" %>

        <title>First Page</title>
    </head>
    <body>
        <%@ include file="common/navigation_bar.jspf" %>

        <center>
            <h1>Welcome ${username}!</h1>
            <table class="table">
                <tbody>
                    <c:forEach items="${monthly}" var="summary">
                        <thead>
                            <tr>
                                <th>${summary.month}</th>
                            </tr>
                        </thead>
                            <tr>
                                <td>
                                    <ul class="list-group">
                                      <li class="list-group-item">Your monthly weight progress: ${summary.startWeight} --> ${summary.endWeight}</li>
                                      <li class="list-group-item">Total monthly steps: ${summary.totalSteps}</li>
                                      <li class="list-group-item">Total active days: ${summary.activeDaysCount}</li>
                                      <li class="list-group-item">Total regeneration days: ${summary.regenerationDaysCount}</li>
                                    </ul>
                                </td>
                            </tr>
                    </c:forEach>
                </tbody>
            </table>

            <hr>
            <a href="entries" class="btn btn-success">Show daily entries</a>
        </center>

        <%@ include file="common/footer.jspf" %>