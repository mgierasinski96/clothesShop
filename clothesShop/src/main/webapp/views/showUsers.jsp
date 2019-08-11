<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
    <style>
        * {
            box-sizing: border-box;
        }

        #myInput {
            background-position: 10px 10px;
            background-repeat: no-repeat;
            width: 100%;
            font-size: 16px;
            padding: 12px 20px 12px 40px;
            border: 1px solid #ddd;
            margin-bottom: 12px;
        }

        #myTable {
            border-collapse: collapse;
            width: 100%;
            border: 1px solid #ddd;
            font-size: 18px;
        }

        #myTable th, #myTable td {
            text-align: left;
            padding: 12px;
        }

        #myTable tr {
            border-bottom: 1px solid #ddd;
        }

        #myTable tr.header, #myTable tr:hover {
            background-color: #f1f1f1;
        }
    </style>

</head>
<body>
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Szukaj po imieniu lub nazwisku">

<table id="myTable">
    <tr class="header">
        <th>Nazwisko</th>
        <th>Imię</th>
        <th>Telefon</th>
        <th>Email</th>
        <th>Adres</th>
        <th>Historia zamowień</th>
        <th>Akcja</th>
    </tr>
    <c:forEach items="${allUsers}" var="user">

        <tbody>
        <tr>
            <td>${user.lastName}</td>
            <td>${user.firstName}</td>
            <td> ${user.telephone}</td>
            <td> ${user.email}</td>
            <td> ${user.address}</td>

            <td>
                <form:form action="orderHistory?userId=${user.userId}&firstName=${user.firstName}&lastName=${user.lastName}">
                    <input type="submit" value="Pokaż"/>
                </form:form>
            </td>
            <td>
                <a href="deleteUser/${user.userId}.html"
                   onclick="if (!(confirm('Czy chcesz usunąć użytkownika i całą historię zamowień ? ?')))
                           return false">Usuń</a></td>
        </tr>

        </tbody>
    </c:forEach>
</table>

<script>
    function myFunction() {
        var input, filter, table, tr, td, i, txtValue,td1,txtValue1;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[1];
            td1 = tr[i].getElementsByTagName("td")[0];

            if (td) {
                txtValue = td.textContent || td.innerText;
                txtValue1 = td1.textContent || td1.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                }
                else if(txtValue1.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                }

                else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>


</body>
</html>
