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
    <p class="ab36"> Ilosc produktow  ${spodnieSize} </p>
</head>
<body>

<table cellpadding="30px">
    <% int i=1; %>
    <c:forEach items="${spodnie}" var="spodnie">

        <td>
            <div class="relative"><a href="/showSpecificProduct/.html?productId=${spodnie.id}">><img width="380" height="350" src="getProductPhoto/<c:out value='${spodnie.id}'/> "></a>
                <div class="absolute" ><p class="ab">${spodnie.name} ${spodnie.price}zł</p></div>
            </div>
        </td>
        <%
            i++;
            if (i%4==0) {
        %>
        <tr></tr>


        <%} else {}
        %>
    </c:forEach>


</table>

</body>
</html>
