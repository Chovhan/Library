<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}" />
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
    <link rel="stylesheet" href="../css/AdminAllBooks.css">
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
            <div class="delete-book">
                <form class="delete-book__from" action="allBooks" method="post">
                    <label for="delete-input">Enter book id you want to delete: </label>
                    <input type="number" name="delete__book" id="delete-input" required>

                    <input type="submit" name="delete__button" id="deleteButton" value="Delete">
                </form>
            </div>
            <table>
                <tr>
                    <td>Book title</td>
                    <td>Author first name</td>
                    <td>Author last name</td>
                    <td>Book instance id</td>
                    <td>Book availability</td>
                </tr>
                <c:forEach var="book" items="${allBooks}">
                    <tr>
                        <td>${book.title}</td>
                        <td>${book.authorFirstName}</td>
                        <td>${book.authorLastName}</td>
                        <td>${book.bookId}</td>
                        <td>${book.bookAvailability}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>


        <%--        <iframe src="" seamless allowtransparency align="center" width="80%" height="90%">--%>

        <%--        </iframe>--%>
    </div>

</div>
</body>
</html>
