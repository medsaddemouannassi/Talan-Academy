<%--
  Created by IntelliJ IDEA.
  User: msouannassi
  Date: 11/05/2022
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Déposer une annonce</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style><%@include file="/WEB-INF/styles/style.css"%></style>
</head>
<body style="background-image: url('https://wallpaper.dog/large/984634.jpg'); background-size: cover">
<%@ include file="header.jsp" %>
<form class="container col-lg-4 form" method="post" action="announcement">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Title</label>
        <input type="text" class="form-control" name="title" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputDescription" class="form-label">Description</label>
        <input type="text" class="form-control" name="description" id="exampleInputDescription">
    </div>
    <div class="input-group mb-3">
        <label class="input-group-text" for="inputGroupSelect01">Category</label>
        <select class="form-select" name="category" id="inputGroupSelect01">
            <option selected>Choose category</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>
    </div>
    <div class="mb-3">
        <label for="exampleInputPrice" class="form-label">price</label>
        <input type="number" name="price" class="form-control" id="exampleInputPrice">
    </div>
    <div class="mb-3">
        <label for="exampleInputLocalisation" class="form-label">Localisation</label>
        <input type="text" class="form-control" name="localisation" id="exampleInputLocalisation">
    </div>
    <input type="submit" class="form-control" id="submit">
    <c:if test="${ !empty createAnnouncementMsg }"><small><c:out value="${ createAnnouncementMsg }" /></small></c:if>
    <c:if test="${ !empty updateAnnouncementMsg }"><small><c:out value="${ updateAnnouncementMsg }" /></small></c:if>
</form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
