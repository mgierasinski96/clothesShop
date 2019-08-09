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
<p class="ab24">Historia zamówień użytkownika: ${lastName} ${firstName}</p>
<c:if test="${orderHistoryForUserSize>0}">

    <table class="table table-striped" border="1">
        <thead>
        <tr>
            <th scope="col">Data</th>
            <th scope="col">Należność</th>
            <th scope="col">Szczegóły</th>

        </tr>
        </thead>

        <c:forEach items="${orderHistoryForUser}" var="payment">
<%-- form --%>
        <tbody>
            <tr>
                <td>${payment.paymentDate}</td>
                <td>${payment.charge}zł</td>
                <td>
                    <form:form action="paymentDetails?paymentId=${payment.paymentId}">
                        <input type="submit" value="Pokaż szczegóły"/>
                    </form:form>
                </td>

            </tr>
        <tbody>
        </c:forEach>

    </table>


</c:if>
<c:if test="${orderHistoryForUserSize == null || orderHistoryForUserSize == 0 }">
    <p class="ab18">Brak zamówień</p>
</c:if>
</body>


</html>
