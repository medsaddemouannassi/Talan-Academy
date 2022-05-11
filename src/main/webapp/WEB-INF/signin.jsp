<%--
  Created by IntelliJ IDEA.
  User: msouannassi
  Date: 11/05/2022
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>
<form class="container col-lg-4" method="post" action="signin">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">First Name</label>
        <input type="text" class="form-control" name="firstName" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputLastNamePseudo" class="form-label">Last Name</label>
        <input type="text" class="form-control" name="lastName" id="exampleInputLastNamePseudo">
    </div>
    <div class="mb-3">
        <label for="exampleInputPseudo" class="form-label">pseudo</label>
        <input type="text" class="form-control" name="pseudo" id="exampleInputPseudo">
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail" class="form-label">E-mail</label>
        <input type="email" class="form-control" name="email" id="exampleInputEmail">
    </div>
    <div class="mb-3">
        <label for="exampleInputPwd" class="form-label">Password</label>
        <input type="password" class="form-control" name="password" id="exampleInputPwd">
    </div>
    <div class="mb-3">
        <label for="exampleInputPhone" class="form-label">Phone Number</label>
        <input type="tel" class="form-control" name="phone" id="exampleInputPhone">
    </div>
    <div class="mb-3">
        <label for="exampleInputDescription" class="form-label">Address</label>
        <input type="text" class="form-control" name="address" id="exampleInputDescription">
    </div>
    <input type="submit" class="form-control" id="submit">
</form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>

</html>
