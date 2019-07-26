<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <script>
        function anErrorOccurred() {
            alert("Niepoprawna nazwa użytkownika lub hasło");
        }
    </script>
    <style>
        .topright {
            position: absolute;
            top: 25%;
            right: 4%;
        }

        .topleftforLogged {
            position: absolute;
            top: 10%;
            right: 0%;
        }

        .toprightWitaj{
            position: absolute;
            top: 25%;
            right: 6%;
        }

        .centerSearch {
            position: absolute;
            top: 15%;
            right: 45%;
        }
        .kontener {
            position: relative;
            text-align: center;
            font-size: 36px;
            color: red;
        }
        .wycentruj {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }

    </style>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href=""></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">

            <li class="nav-item active">
                <a class="nav-link" href="/.html">Strona główna<span class="sr-only">(current)</span></a>
            </li>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="/newProduct">Dodaj produkt</a>--%>
            <%--</li>--%>

            <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="/showAllProducts">Pokaz wszystkie ciuchy</a>--%>
            <%--</li>--%>

            <li class="nav-item dropdown">
<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                <a class="nav-link dropdown-toggle" href="" id="navbarDropdownZarządzaj" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Zarządzaj
                </a>
</sec:authorize>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/showAllProducts">Pokaż wszystkie produkty</a>
                    <a class="dropdown-item" href="/newProduct">Dodaj nowy produkt</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Przeglądaj ciuchy
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/bluzy">Bluzy</a>
                    <a class="dropdown-item" href="/spodnie">Spodnie</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/registerAppUser">Zarejestruj</a>
            </li>

        </ul>
        <div class="centerSearch">
            <form class="form-inline my-2 my-lg-0" action="/szukam">
                <input class="form-control mr-sm-2" type="search" name="search" placeholder="Szukaj" aria-label="Search" size="5">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Szukaj</button>
            </form>
        </div>
        <!-- msg for login-->
        <c:if test="${not empty error}">
            <script>
                anErrorOccurred()
            </script>

        </c:if>
      
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <script>
                function formSubmit() {
                    document.getElementById("logoutForm").submit();
                }
            </script>

            <!-- csrf for log out-->
            <form action="/logout" method="post" id="logoutForm">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

            <div class="toprightWitaj">
            <p class="text-primary">
                Witaj: ${pageContext.request.userPrincipal.name} |
                <a href="javascript:formSubmit()"> Logout</a>
            </p>
            </div>
        </c:if>
        <!-- msg for login-->
        <!-- login form-->
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <div class="topright">
                <form class="form-signin" name='loginForm' action="<c:url value='/login' />" method='POST'>
                    <input type="text" id="inputEmail" placeholder="Login " name="login" required autofocus>
                    <input type="password" id="inputPassword" placeholder="Password" name="password" required>
                    <button type="submit">Zaloguj</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </c:if>
        <!-- login form-->
    </div>

<sec:authorize access="hasAnyRole('ROLE_EMPLOYEE','ROLE_ADMIN','ROLE_USER')">
    <div class="topleftforLogged">
        <div class="kontener">
        <img src="/resources/images/koszyk.jpg" width="40" height="40">
            <div class="wycentruj"> ${iloscMoichProduktow}</div>

        </div>
    </div>
</sec:authorize>
    </div>
</nav>
</body>
</html>
