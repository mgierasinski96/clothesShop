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


<div class="container">
    <h1 class="well " align="center">Formularz rejestracyjny</h1>
    <div class="col-lg-12 well">
        <div class="row">
            <form>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-6 form-group" >
                            <label>Imię</label>
                            <input type="text" placeholder="Wpisz imię..." class="form-control">
                        </div>
                        <div class="col-sm-6 form-group">
                            <label>Nazwisko</label>
                            <input type="text" placeholder="Wpisz nazwisko..." class="form-control">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <label>Login</label>
                            <input type="text" placeholder="Wpisz login..." class="form-control">
                        </div>
                        <div class="col-sm-6 form-group">
                            <label>Hasło</label>
                            <input type="text" placeholder="Wpisz hasło..." class="form-control">
                        </div>

                    </div>

                    <div class="row">
                        <div class="form-group">
                            <label>Adres</label>
                            <textarea placeholder="Wpisz adres..." rows="3" class="form-control"></textarea>
                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group">
                            <label>Numer telefonu</label>
                            <input type="text" placeholder="Wpisz numer telefonu..." class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Adres email</label>
                            <input type="text" placeholder="Wpisz email..." class="form-control">
                        </div>

                    </div>


                    <button type="button" class="btn btn-lg btn-info">Zarejestruj</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>