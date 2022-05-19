<%--
  Created by IntelliJ IDEA.
  User: msouannassi
  Date: 11/05/2022
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Liste des Annonces</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css"
          integrity="sha384-/frq1SRXYH/bSyou/HUp/hib7RVN1TawQYja658FEOodR/FQBKVqT9Ol+Oz3Olq5" crossorigin="anonymous"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style><%@include file="/WEB-INF/styles/style.css"%></style>
</head>
<body>
<%@ include file="header.jsp" %>
<c:if test="${ !empty announcements }">
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
            <c:if test="${!empty sessionScope.id}">
                <th style="text-align: center">Action</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="announcement" items="${ announcements }">
            <c:forEach var="favorite" items="${ favorites }">
                <c:if test="${announcement.announcement_id == favorite.favorite_id}"><c:set var="fav" value="fav"></c:set></c:if>
            </c:forEach>
            <tr>
                <td><c:out value="${ announcement.announcement_id }"/></td>
                <td><c:out value="${ announcement.title }"/></td>
                <td><c:out value="${ announcement.description }"/></td>
                <td><c:out value="${ announcement.categoryId }"/></td>
                <td><c:out value="${ announcement.price }"/></td>
                <td><c:out value="${ announcement.is_available }"/></td>
                <td><c:out value="${ announcement.publication_date }"/></td>
                <td><c:out value="${ announcement.status }"/></td>
                <td><c:out value="${ announcement.view_number }"/></td>
                <td><c:out value="${ announcement.localisation }"/></td>
                <td><c:out value="${ announcement.user_id }"/></td>
                <c:if test="${!empty sessionScope.id}">
                    <td>
                        <form style="margin: 0 !important;" action="announcements" method="post">
                            <c:if test="${fav != 'fav'}">
                            <button name="action" value="favorite" class="btn btn-sm btn-secondary">
                                </c:if>
                                <c:if test="${fav == 'fav'}">
                                <button name="action" value="unfavorite" class="btn btn-sm btn-warning">
                                    </c:if>
                                    <i class="fa-solid fa-star"></i>
                                    <input hidden name="announcementId" value="${announcement.announcement_id}"/>
                                </button>
                        </form>
                    </td>
                    <c:remove var="fav"></c:remove>
                </c:if>
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
