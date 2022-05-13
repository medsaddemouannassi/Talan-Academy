<%--
  Created by IntelliJ IDEA.
  User: msouannassi
  Date: 13/05/2022
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier une annonce</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>
<form class="container col-lg-4" method="post" action="announcement">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Title</label>
        <input type="text" class="form-control" name="title" placeholder="${myAnnouncementTitle}" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputDescription" class="form-label">Description</label>
        <input type="text" class="form-control" name="description" value="${myAnnouncementDescription}" id="exampleInputDescription">
    </div>
    <div class="input-group mb-3">
        <label class="input-group-text" for="inputGroupSelect01">Category</label>
        <select class="form-select" name="category" value="${myAnnouncementCategory}" id="inputGroupSelect01">
            <option selected>Choose category</option>
            <option value="1">One</option>
            <option value="2">Two</option>
            <option value="3">Three</option>
        </select>
    </div>
    <div class="mb-3">
        <label for="exampleInputPrice" class="form-label">price</label>
        <input type="number" name="price" value="${myAnnouncementPrice}" class="form-control" id="exampleInputPrice">
    </div>
    <div class="mb-3">
        <label for="exampleInputLocalisation" class="form-label">Localisation</label>
        <input type="text" class="form-control" name="localisation" value="${myAnnouncementLocalisation}" id="exampleInputLocalisation">
    </div>
    <input type="submit" class="form-control" id="submit">
    <c:if test="${ !empty updateAnnouncementMsg }"><small><c:out value="${ updateAnnouncementMsg }" /></small></c:if>
</form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
