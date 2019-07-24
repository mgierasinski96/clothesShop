<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
        p.ab {
            font-family: 'Arial Black', arial;
            text-align: center;
        }
        p.ab36 {
            font-family: 'Arial Black', arial;
            font-size: 36px;


        }
        div.relative {
            position: relative;
            width: 380px;
            height: 380px;
            text-align: center;

        }

        div.absolute {
            position: absolute;
            top: 385px;
            width: 100%;
            text-align: center;


        }

    </style>
    <link href="http://pl.allfont.net/allfont.css?fonts=arial-black" rel="stylesheet" type="text/css" />
    <p class="ab36"> Ilość produktów  ${searchSize} </p>
</head>
<body>
<table cellpadding="30px" >
    <% int i=1; %>
    <c:forEach items="${searchProducts}" var="product">

        <td>
            <div class="relative"><a href="/showSpecificProduct/.html?productId=${product.id}">><img width="380" height="350" src="getProductPhoto/<c:out value='${product.id}'/> "></a>
                <div class="absolute" ><p class="ab">${product.name} ${product.price}zł</p></div>
            </div>
        </td>
        <%

            if (i%3==0) {
                i++;

        %>
        <tr></tr>


        <%} else {
            i++;
        }
        %>
    </c:forEach>

</table>

</body>
</html>
