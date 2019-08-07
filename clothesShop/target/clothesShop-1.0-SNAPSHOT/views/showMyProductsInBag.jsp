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
    p.ab18 {
        font-family: 'Arial Black', arial;
        font-size: 18px;
    }
    </style>
</head>
<body>
<c:if test="${myProductsSize>0}">

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
            <td>
                <%--<a href="/addToBag.html?productId=${product.id}&size=${"S"}"--%>
                   <%--onclick="if (!(confirm('Czy chcesz dodać produkt do koszyka ?')))--%>
                           <%--return false"><text style="color:green">S</text></a>--%>
                    <a href="/deleteProductFromBag/.html?bagId=${bag.bagId}" onclick="if (!(confirm('Czy chcesz usunąć produkt ${bag.product.name} z koszyka ?')))
                        return false">
            <img src="/resources/images/usun.jpg">
                    </a>
            </td>
        </tr>
    </c:forEach>
</table>
    <c:set var="total" value="${0}"/>
    <c:forEach var="bag" items="${myProducts}">
        <c:set var="total" value="${total + bag.product.price}" />
    </c:forEach>
    <p class="ab24">Podsumowanie </p>
<form:form method="post" action="payPayment?total=${total}">
  <p class="ab18">Do zapłaty: ${total}zł <input type="submit" value="Zapłać"/></p>
</form:form>
</c:if>
<c:if test="${myProductsSize == null || myProductsSize == 0 }">
    <p class="ab24">Twój koszyk jest pusty</p>
</c:if>
</body>


</html>
