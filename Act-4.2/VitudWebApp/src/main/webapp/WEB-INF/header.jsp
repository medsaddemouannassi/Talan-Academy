<%--
  Created by IntelliJ IDEA.
  User: msouannassi
  Date: 11/05/2022
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar-expand-lg navbar navbar-light mb-5" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Vintud</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="http://localhost:8080/vintud/myannouncements">My Announcements</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="http://localhost:8080/vintud/announcements">Announcements</a>
                </li>
                <li class="nav-item">
                    <c:if test="${ empty sessionScope.id }"><a class="nav-link"
                                                               href="http://localhost:8080/vintud/login">Create
                        Announcement</a></c:if>
                    <c:if test="${ !empty sessionScope.id }"><a class="nav-link"
                                                                href="http://localhost:8080/vintud/create/announcement">Create
                        Announcement</a></c:if>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/vintud/signin">Sign In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/vintud/login">Log In</a>
                </li>
            </ul>
            <c:if test="${ !empty sessionScope.firstName && !empty sessionScope.lastName }">
                <ul class="navbar-nav mr-auto mb-2 mb-lg-0">
                    <li class="nav-item dropdown">
                        <c:out value="${ sessionScope.firstName }"/> <c:out value="${ sessionScope.lastName }"/>
                    </li>
                </ul>
            </c:if>
        </div>
    </div>    <!-- Navbar content -->
</nav>
