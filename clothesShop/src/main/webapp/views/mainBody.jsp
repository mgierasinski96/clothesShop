<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>

    <link rel="stylesheet" type="text/css" href="../resources/css/mainbody.css">
</head>
<body>
<div class="topleftcorner">
    <img src="/resources/images/logo.jpg">

</div>

<div class="underemporio">
    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <a href="/showSpecificProduct/.html?productId=14">
                <img src="/resources/images/bluzaKaruleza.jpg" width="400px" height="400px">
                </a>
            </div>
            <div class="carousel-item">
                <a href="/showSpecificProduct/.html?productId=17">
                <img src="/resources/images/dresyKaruzela.jpg" width="400px" height="400px">
                </a>


            </div>
            <div class="carousel-item">
                <a href="/showSpecificProduct/.html?productId=24">
                <img src="/resources/images/bluzaMoroKaruzela.jpg" width="400px" height="400px">
                </a>

            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>


</div>
</body>
</html>
