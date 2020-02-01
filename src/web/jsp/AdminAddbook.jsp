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
    <link rel="stylesheet" href="../css/AdminAddBook.css">
    <title>Add book</title>
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

        <section>
            <div class="photo"><img class="photo" src="https://i.pinimg.com/originals/4c/6c/b0/4c6cb0c4df30819cf1c03ec54008af6e.jpg"></div>
            <div class="text">
                <form class="Add" action="addBook" method="post">
                    <label><fmt:message key="label.lang.bookTitle"/>: </label>
                    <input name="title__name" id="input-text title"  type="text" >
                    <label><fmt:message key="label.lang.fName"/>: </label>
                    <input name="author__name" id="input-text author"  type="text" >
                    <label><fmt:message key="label.lang.extraAuthor"/>: </label>
                    <div class="data-country">
                        <input type="date" id="input-text date" name="birth__date">
                        <input name="country__name-author" id="input-text country"  type="text" >
                    </div>
                    <label><fmt:message key="label.lang.phName"/>: </label>
                    <input name="house__name" id="input-text house"  type="text" >
                    <label><fmt:message key="label.lang.phLocation"/>: </label>
                    <div class="address">
                        <input name="country__name-pb" id="input-text country-address"  type="text" >
                        <input name="city__name" id="input-text city"  type="text" >
                        <input name="street__name" id="input-text Street"  type="text" >
                    </div>
                    <label>ISBN: </label>
                    <input name="ISBN__name" id="input-text ISBN"  type="number" >
                    <label><fmt:message key="label.lang.annotation"/>: </label>
                    <textarea name="title__annotation" id="input-text annotation" cols="40" rows="3"></textarea>

                    <input type="submit" name="Add__button" id="Add1" value="Add book">
                </form>
            </div>
        </section>
    </div>

</div>
</body>
</html>
