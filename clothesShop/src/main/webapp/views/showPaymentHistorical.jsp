<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <style>
        p.ab24 {
            font-family: 'Arial Black', arial;
            font-size: 24px;
        }
    </style>
</head>
<body>
    <table cellpadding="30px">

        <th>Podgląd</th>
        <th>Nazwa</th>
        <th>Cena</th>
        <th>Rozmiar</th>
        <c:forEach items="${myProducts}" var="bag">

            <tr>
                <td><a href="/showSpecificProduct/.html?productId=${bag.product.id}">><img width="150" height="150"
                                                                                           src="getProductPhoto/<c:out value='${bag.product.id}'/> "></a>
                </td>
                <td>${bag.product.name}</td>
                <td>${bag.product.price}zł</td>
                <td>${bag.productSize}</td>
            </tr>
        </c:forEach>
    </table>
    <c:set var="total" value="${0}"/>
    <c:forEach var="bag" items="${myProducts}">
        <c:set var="total" value="${total + bag.product.price}" />
    </c:forEach>
        <p class="ab24">Aktualna wartość: ${total}zł</p>

</body>


</html>
