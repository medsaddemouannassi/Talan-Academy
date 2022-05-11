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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>
<ul>
    <c:forEach var="announcement" items="${ announcements }">
        <li><c:out value="${ announcement.title }" /> <c:out value="${ announcement.description }" /> <c:out value="${ announcement.category_id }" /> <c:out value="${ announcement.price }" /> <c:out value="${ announcement.publication_date }" /> <c:out value="${ announcement.description }" /></li>
    </c:forEach>
</ul>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
