<%--
  Created by IntelliJ IDEA.
  User: msouannassi
  Date: 12/05/2022
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mes Annonces</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>
<c:if test="${ !empty myAnnouncements }">
    <table class="table table-hover table-striped table-sm">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Category</th>
            <th>Price</th>
            <th>Availability</th>
            <th>Publication date</th>
            <th>Status</th>
            <th>Views</th>
            <th>Localisation</th>
            <th>User ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="announcement" items="${ myAnnouncements }">
            <tr>
                <td><c:out value="${ myAnnouncements.id }"/></td>
                <td><c:out value="${ myAnnouncements.title }"/></td>
                <td><c:out value="${ myAnnouncements.description }"/></td>
                <td><c:out value="${ myAnnouncements.categoryId }"/></td>
                <td><c:out value="${ myAnnouncements.price }"/></td>
                <td><c:out value="${ myAnnouncements.is_available }"/></td>
                <td><c:out value="${ myAnnouncements.publication_date }"/></td>
                <td><c:out value="${ myAnnouncements.status }"/></td>
                <td><c:out value="${ myAnnouncements.view_number }"/></td>
                <td><c:out value="${ myAnnouncements.localisation }"/></td>
                <td><c:out value="${ myAnnouncements.userId }"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
