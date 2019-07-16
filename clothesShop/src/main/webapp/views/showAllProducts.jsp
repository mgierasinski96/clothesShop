<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
    <script type="text/javascript">
        function makeTableScroll() {
            // Constant retrieved from server-side via JSP
            var maxRows = 4;

            var table = document.getElementById('myTable');
            var wrapper = table.parentNode;
            var rowsInTable = table.rows.length;
            var height = 0;
            if (rowsInTable > maxRows) {
                for (var i = 0; i < maxRows; i++) {
                    height += table.rows[i].clientHeight;
                }
                wrapper.style.height = height + "px";
            }
        }
    </script>
    <link rel="stylesheet" type="text/css" href="../resources/css/mainbody.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body onload="makeTableScroll();">
<div class="scrollingTable">

    <table class="table table-striped" border="1">
        <thead>
        <tr>
            <th scope="col">Podgląd</th>
            <th scope="col">Nazwa</th>
            <th scope="col">Cena</th>
            <th scope="col">Typ</th>
            <th scope="col">Dostępne rozmiary</th>
            <th scope="col">Akcja</th>
        </tr>
        </thead>
        <c:forEach items="${allProducts}" var="product">
        <tbody>
        <tr>


            <td><img width="100" height="100" src="getProductPhoto/<c:out value='${product.id}'/>"></td>
            <td>${product.name}</td>
            <td> ${product.price}</td>
            <td> ${product.productType}</td>
            <td>
            <c:forEach items="${product.quantity}" var="productSize">

            ${productSize.size}-${productSize.quantity}szt

            </c:forEach>
            </td>
            <td><a href="newProduct.html?productId=${product.id}">Edytuj</a>
            <a href="delete/${product.id}.html"
                   onclick="if (!(confirm('Czy chcesz usunąć ubranie i wszystkie rozmiary ?')))
                           return false">Usuń</a></td>
        </tr>

        </tbody>
        </c:forEach>
    </table>

</div>

</body>
</html>
