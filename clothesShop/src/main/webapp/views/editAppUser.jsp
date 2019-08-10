<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->



    <style>

        div.row {
            width: 500px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 10px;
        }
        div.form-group {
            width: 476px;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 10px;
        }

    </style>
</head>
<body>
<form:form method="post" action="editAppUser.html" modelAttribute="appUser">
    <form:hidden path="userId"/>
    <div class="container">
        <h1 class="well " align="center">Edytuj dane użytkownika ${appUser.lastName} ${appUser.firstName} </h1>
        <div class="col-lg-12 well">
            <div class="row">
                <form>
                    <div class="col-sm-12">
                        <div class="row">
                            <div class="col-sm-6 form-group" >


                                <form:label path="firstName">Imię</form:label>
                                </p>
                                <form:input path="firstName" placeholder="Wpisz imię..."/>
                                <form:errors path="firstName"/>
                            </div>
                            <div class="col-sm-6 form-group">
                                <form:label path="lastName">Nazwisko</form:label>
                                </p>
                                <form:input path="lastName" placeholder="Wpisz nazwisko..."/>
                                <form:errors path="lastName"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 form-group">
                                <form:label path="login">Login</form:label>
                                </p>
                                <form:input path="login" placeholder="Wpisz login..."/>
                                <form:errors path="login"/>
                            </div>
                            <div class="col-sm-6 form-group">
                                <form:label path="password">Hasło</form:label>
                                </p>
                                <form:input type="password" path="password" placeholder="Wpisz hasło..."/>
                                <form:errors path="password"/>
                            </div>

                        </div>

                        <div class="row">
                            <div class="form-group">
                                <form:label path="address">Adres</form:label>
                                </p>
                                <form:input size="61" path="address" placeholder="Wpisz adres..."/>
                                <form:errors path="address"/>
                            </div>
                        </div>


                        <div class="row">
                            <div class="form-group">
                                <form:label path="telephone">Numer telefonu</form:label>
                                </p>
                                <form:input size="61" path="telephone" placeholder="Wpisz numer telefonu..."/>
                                <form:errors path="telephone"/>
                            </div>
                            <div class="form-group">
                                <form:label path="email">Email</form:label>
                                </p>
                                <form:input size="61" path="email" placeholder="Wpisz email..."/>
                                <form:errors path="email"/>
                            </div>

                        </div>


                        <input type="submit" class="btn btn-lg btn-info" value="Edytuj"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</form:form>
</body>
</html>