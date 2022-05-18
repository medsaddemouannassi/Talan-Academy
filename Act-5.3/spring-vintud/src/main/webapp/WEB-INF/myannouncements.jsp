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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css"
          integrity="sha384-/frq1SRXYH/bSyou/HUp/hib7RVN1TawQYja658FEOodR/FQBKVqT9Ol+Oz3Olq5" crossorigin="anonymous"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style><%@include file="/WEB-INF/styles/style.css"%></style>
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
            <th style="text-align: center">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="myAnnouncement" items="${ myAnnouncements }">
            <tr>
                <td><c:out value="${ myAnnouncement.id }"/></td>
                <td><c:out value="${ myAnnouncement.title }"/></td>
                <td><c:out value="${ myAnnouncement.description }"/></td>
                <td><c:out value="${ myAnnouncement.categoryId }"/></td>
                <td><c:out value="${ myAnnouncement.price }"/></td>
                <td><c:out value="${ myAnnouncement.is_available }"/></td>
                <td><c:out value="${ myAnnouncement.publication_date }"/></td>
                <td><c:out value="${ myAnnouncement.status }"/></td>
                <td><c:out value="${ myAnnouncement.view_number }"/></td>
                <td><c:out value="${ myAnnouncement.localisation }"/></td>
                <td><c:out value="${ myAnnouncement.userId }"/></td>
                <td class="d-flex justify-content-evenly">
                    <form style="margin: 0 !important;" action="update-announcement" method="get">
                        <button name="action" value="edit" class="btn btn-sm btn-secondary"><i
                                class="fa-solid fa-pen-to-square"></i>
                            <input hidden name="myAnnouncementId" value="${myAnnouncement.id}"/>
                            <input hidden name="myAnnouncementTitle" value="${myAnnouncement.title}"/>
                            <input hidden name="myAnnouncementDescription" value="${myAnnouncement.description}"/>
                            <input hidden name="myAnnouncementPrice" value="${myAnnouncement.categoryId}"/>
                            <input hidden name="myAnnouncementCategory" value="${myAnnouncement.price}"/>
                            <input hidden name="myAnnouncementLocalisation" value="${myAnnouncement.localisation}"/>
                        </button>
                    </form>
                    <form style="margin: 0 !important;" action="myannouncements" method="post">
                        <button type="submit" name="action" value="delete" class="btn btn-sm btn-danger"><i
                                class="fa-solid fa-trash-can"></i>
                            <input hidden name="id" value="${myAnnouncement.id}"/>
                            <input hidden name="userId" value="${myAnnouncement.userId}"/>
                        </button>
                    </form>
                </td>
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
