<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Entries page</title>
    </head>
    <body>
    <h1>Entries page</h1>
        <table>
            <tbody>
            <c:forEach items="${entriesList}" var="entry">
                <tr>
                    <td>${entry.id}</td>
                    <td>${entry.username}</td>
                    <td>${entry.entryDate}</td>
                    <td>${entry.weight}</td>
                    <td>${entry.steps}</td>
                    <td>${entry.comment}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>