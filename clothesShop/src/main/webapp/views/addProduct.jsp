<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/mainbody.css">
</head>
<body>
<div class="center">
    <form:form method="post" action="addNewProduct.html" modelAttribute="product" enctype="multipart/form-data">
        <table>
            <tr>
                <td><form:hidden path="id"/>
            </tr>
            <tr>
                <td><form:label path="name">Nazwa produktu</form:label></td>
                <td><form:input path="name"/></td>
                <td><form:errors path="name"/></td>
            </tr>
            <tr>
                <td><form:label path="price">Cena</form:label></td>
                <td><form:input path="price"/></td>
                <td><form:errors path="price"/></td>
            </tr>

            <tr>
                <td><form:label path="productType">Typ produktu</form:label></td>
                <td><form:input path="productType"/></td>
                <td><form:errors path="productType"/></td>
            </tr>

            <tr>

                <td>Ilość</td>
                <td><input type="text" name="quantity"></td>
            </tr>
            <tr>
                <td>Rozmiar</td>
                <td>
                    <select name="size" size="4" multiple="true">
                        <option value="S">S</option>
                        <option value="M">M</option>
                        <option value="L">L</option>
                        <option value="XL">XL</option>
                    </select>
                <td>
            </tr>

            <tr>
                <td>Wybierz plik:</td>
                <td><input type="file" name="fileUpload" size="20"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Dodaj produkt"/>
                </td>
            </tr>
            </td>

            </tr>

        </table>
    </form:form>
</div>


</body>
</html>
