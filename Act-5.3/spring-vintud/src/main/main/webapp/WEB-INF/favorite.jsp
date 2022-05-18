<%--
  Created by IntelliJ IDEA.
  User: MED SADDEM
  Date: 14/05/2022
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mes Favoris</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css"
          integrity="sha384-/frq1SRXYH/bSyou/HUp/hib7RVN1TawQYja658FEOodR/FQBKVqT9Ol+Oz3Olq5" crossorigin="anonymous"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style><%@include file="/WEB-INF/styles/style.css"%></style>
</head>
<body>
<%@ include file="header.jsp" %>
<c:if test="${ !empty myFavorites }">
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
        <c:forEach var="myFavorite" items="${ myFavorites }">
            <tr>
                <td><c:out value="${ myFavorite.id }"/></td>
                <td><c:out value="${ myFavorite.title }"/></td>
                <td><c:out value="${ myFavorite.description }"/></td>
                <td><c:out value="${ myFavorite.categoryId }"/></td>
                <td><c:out value="${ myFavorite.price }"/></td>
                <td><c:out value="${ myFavorite.is_available }"/></td>
                <td><c:out value="${ myFavorite.publication_date }"/></td>
                <td><c:out value="${ myFavorite.status }"/></td>
                <td><c:out value="${ myFavorite.view_number }"/></td>
                <td><c:out value="${ myFavorite.localisation }"/></td>
                <td><c:out value="${ myFavorite.userId }"/></td>
                <td class="d-flex justify-content-evenly">
                    <form style="margin: 0 !important;" action="favorite" method="post">
                        <button type="submit" name="action" value="delete" class="btn btn-sm btn-danger"><i
                                class="fa-solid fa-trash-can"></i>
                            <input hidden name="myFavoriteId" value="${myFavorite.id}"/>
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
