<%--
  Created by IntelliJ IDEA.
  User: msouannassi
  Date: 11/05/2022
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar-expand-lg navbar navbar-light mb-5" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Vintud</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <c:if test="${ !empty sessionScope.id }">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="http://localhost:8080/vintud/favorite">Mes Favoris</a>
                    </li>
                </c:if>
                <c:if test="${ !empty sessionScope.id }">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="http://localhost:8080/vintud/myannouncements">Mes annonces</a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="http://localhost:8080/vintud/announcements">Annonces</a>
                </li>
                <li class="nav-item">
                    <c:if test="${ empty sessionScope.id }"><a class="nav-link"
                                                               href="http://localhost:8080/vintud/login">Créer une
                        annonce</a></c:if>
                    <c:if test="${ !empty sessionScope.id }"><a class="nav-link"
                                                                href="http://localhost:8080/vintud/create/announcement">Créer
                        une
                        annonce</a></c:if>
                </li>
                <c:if test="${ empty sessionScope.id }">
                    <li class="nav-item">
                        <a class="nav-link" href="http://localhost:8080/vintud/signin">S'inscrire</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="http://localhost:8080/vintud/login">Se connecter</a>
                    </li>
                </c:if>
            </ul>
            <c:if test="${ !empty sessionScope.firstName && !empty sessionScope.lastName }">
                <ul class="navbar-nav mr-auto mb-2 mb-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <c:out value="${ sessionScope.firstName }"/> <c:out value="${ sessionScope.lastName }"/>
                        </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <form style="margin-bottom: 0 !important;" action="login" method="post">
                                <li><button type="submit" name="action" value="logout" class="dropdown-item">Se déconnecter</button></li>
                                </form>
                            </ul>
                    </li>
                </ul>
            </c:if>
        </div>
    </div>    <!-- Navbar content -->
</nav>
