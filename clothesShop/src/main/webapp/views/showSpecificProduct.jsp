<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
    <style>
        div.relative {
            position: relative;
            width: 500px;
            height: 500px;

        }

        div.absolute {
            position: absolute;
            top: 50px;
            right: -100%;
            width: 500px;
            height: 100px;
            font-family: 'Arial Black', arial;
            font-size: 20px;

        }

        div.absoluteBelow {
            position: absolute;
            top: 110px;
            right: -100%;
            width: 500px;
            height: 100px;
            font-family: 'Arial Black', arial;
            font-size: 20px;

        }
        div.absoluteBeloww {
            position: absolute;
            top: 140px;
            right: -100%;
            width: 500px;
            height: 100px;
            font-family: 'Arial Black', arial;
            font-size: 20px;

        }
    </style>
</head>
<body>



<div class="relative"><img width="500" height="500" src="getProductPhoto/<c:out value='${product.id}'/>">
    <div class="absolute">${product.name} <p>Cena: <text style="color:#005cbf">${product.price}zł</text></p> </div>
    <div class="absoluteBelow">
       Rozmiary:
<c:forEach items="${quantity}" var="quantity">
    <c:if test="${quantity.size == 'S' && quantity.quantity gt 0}">
        <text style="color:green">S</text>
</c:if>

    <c:if test="${quantity.size == 'S' && quantity.quantity le 0}">
        <text style="color:red">S</text>
</c:if>

    <c:if test="${quantity.size == 'M' && quantity.quantity gt 0}">
        <text style="color:green">M</text>
</c:if>
    <c:if test="${quantity.size == 'M' && quantity.quantity le 0}">
        <text style="color:red">M</text>
</c:if>

    <c:if test="${quantity.size == 'L' && quantity.quantity gt 0}">
        <text style="color:green">L</text>
</c:if>
    <c:if test="${quantity.size == 'L' && quantity.quantity le 0}">
        <text style="color:red">L</text>
</c:if>

    <c:if test="${quantity.size == 'XL' && quantity.quantity gt 0}">
        <text style="color:green">XL</text>
</c:if>
    <c:if test="${quantity.size == 'XL' && quantity.quantity le 0}">
        <text style="color:red">XL</text>
</c:if>

</c:forEach>




    </div>
    <div class="absoluteBeloww"></div>
</div>



</body>
</html>
