<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}" />
<fmt:setLocale value="ru"/>
<fmt:setBundle basename="admin" />

<% if(request.getCharacterEncoding() == null) {
    request.setCharacterEncoding("UTF-8");
} %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="icon"  type="image/x-icon" href="http://loveferrari.l.o.pic.centerblog.net/99fce96a.png">
    <link rel="stylesheet" href="../css/Admin.css">
    <title>Admin</title>
</head>
<body>
<div class="wrap">
    <div class="wrapper">
        <div class="menu">
            <form class="statistics" action="Admin" method="get">
                <input type="submit" name="statistics__button" id="statistics" value="<fmt:message key="label.lang.viewStatistics"/>">
            </form>
            <form class="Add" action="addBook" method="get">
                <input type="submit" name="Add__button" id="Add" value="<fmt:message key="label.lang.addBook"/>">
            </form>
            <form class="All" action="allBooks" method="get">
                <input type="submit" name="All__button" id="All" value="<fmt:message key="label.lang.allBooks"/>">
            </form>
            <form class="Exit" action="LogOut" method="get">
                <input type="submit" name="Exit__button" id="Exit" value="<fmt:message key="label.lang.exit"/>">
            </form>
        </div>

        <div class="table">
            <table>
                <tr>
                    <td>Book title</td>
                    <td>Author first name</td>
                    <td>Author last name</td>
                    <td>Book instance id</td>
                    <td>Book give time</td>
                    <td>Visitor first name</td>
                    <td>Visitor last name</td>
                    <td>Visitor phone number</td>
                    <td>Visitor email</td>
                </tr>
                <c:forEach var="data" items="${dataTransferArray}">
                    <tr>
                        <td>${data.bookTitle}</td>
                        <td>${data.authorFirstName}</td>
                        <td>${data.authorLastName}</td>
                        <td>${data.bookInstanceId}</td>
                        <td>${data.bookGiveTime}</td>
                        <td>${data.visitorFirstName}</td>
                        <td>${data.visitorLastName}</td>
                        <td>${data.visitorPhoneNumber}</td>
                        <td>${data.visitorEmail}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

<%--        <div class="translate">--%>
<%--            <a href="?lang=en" class="language"><img class="language" src="../images/eng.png" alt="ENG" ></a>--%>
<%--            <a href="?lang=ru" class="language"><img class="language" src="../images/ru.png" alt="RU"></a>--%>
<%--            <a href="?lang=ua" class="language"><img class="language" src="../images/ua.png" alt="UA"></a>--%>
<%--        </div>--%>

<%--        <iframe src="" seamless allowtransparency align="center" width="80%" height="90%">--%>

<%--        </iframe>--%>
    </div>

</div>
</body>
</html>
