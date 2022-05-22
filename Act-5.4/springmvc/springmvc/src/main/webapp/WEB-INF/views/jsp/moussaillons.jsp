<%--
  Created by IntelliJ IDEA.
  User: MED SADDEM
  Date: 22/05/2022
  Time: 1:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<table class="table table-hover">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Configuration</th>
    </tr>
    <c:forEach var="moussaillon" items="${moussaillons}">
        <tr>
            <td><c:out value="${moussaillon.firstName}"/></td>
            <td><c:out value="${moussaillon.lastName}"/></td>
            <td><c:out value="${moussaillon.config}"/></td>
        </tr>
    </c:forEach>
</table>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
</body>
</html>
