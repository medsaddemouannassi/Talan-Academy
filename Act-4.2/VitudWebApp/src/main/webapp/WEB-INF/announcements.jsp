<%--
  Created by IntelliJ IDEA.
  User: msouannassi
  Date: 11/05/2022
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Annonces</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>
<c:if test="${ !empty announcements }">
    <table class="table table-hover table-striped table-sm">
        <thead class="table-dark">
        <tr>
            <th class="col-lg-0">ID</th>
            <th class="col-lg-1">Title</th>
            <th class="col-lg-2">Description</th>
            <th class="col-lg-1">Category</th>
            <th class="col-lg-1">Price</th>
            <th class="col-lg-1">Availability</th>
            <th class="col-lg-2">Publication date</th>
            <th class="col-lg-1">Status</th>
            <th class="col-lg-1">Views</th>
            <th class="col-lg-1">Localisation</th>
            <th class="col-lg-1">User ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="announcement" items="${ announcements }">
            <tr>
                <td><c:out value="${ announcement.id }"/></td>
                <td><c:out value="${ announcement.title }"/></td>
                <td><c:out value="${ announcement.description }"/></td>
                <td><c:out value="${ announcement.categoryId }"/></td>
                <td><c:out value="${ announcement.price }"/></td>
                <td><c:out value="${ announcement.is_available }"/></td>
                <td><c:out value="${ announcement.publication_date }"/></td>
                <td><c:out value="${ announcement.status }"/></td>
                <td><c:out value="${ announcement.view_number }"/></td>
                <td><c:out value="${ announcement.localisation }"/></td>
                <td><c:out value="${ announcement.userId }"/></td>
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
