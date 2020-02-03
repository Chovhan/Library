<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="userpage" />

<% if(request.getCharacterEncoding() == null) {
    request.setCharacterEncoding("UTF-8");
} %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="icon"  type="image/x-icon" href="http://loveferrari.l.o.pic.centerblog.net/99fce96a.png">
    <link rel="stylesheet" href="../css/User.css">
    <title>Document</title>
</head>
<body>
<div class="wrap">
    <div class="strip">
        <form class="Exit" action="LogOut" method="get">
            <input type="submit" name="Exit__button" id="Exit" value="Exit">
        </form>
        <form class="take" action="User" method="post">
            <label for="take-input"><fmt:message key="label.lang.takeBookText"/> </label>
            <input type="number" name="take-number__book" id="take-input">
            <input type="submit" name="take__button" id="take" value="<fmt:message key="label.lang.takeBook"/>">
        </form>
    </div>
    <div class="wrapper">
        <div class="area">
            <div class="title-library"><fmt:message key="label.lang.heading"/></div>
            <div class="roll"></div>
            <div class="center">
                <c:forEach var="book" items="${allBooks}">
                    <section>
                        <div class="photo"><img class="photo" src="https://i.pinimg.com/originals/4c/6c/b0/4c6cb0c4df30819cf1c03ec54008af6e.jpg"></div>
                        <div class="text">
                            <div class="title"><fmt:message key="label.lang.title"/>: </div>
                            <div class="author"><fmt:message key="label.lang.author"/>: </div>
                            <div class="id"><fmt:message key="label.lang.bookId"/>: </div>
                            <div class="annotation"><fmt:message key="label.lang.annotation"/>: </div>
                        </div>
                        <div class="input-text">
                            <div class="input-text__title">${book.title}</div>
                            <div class="input-text__author">${book.authorFirstName} ${book.authorLastName}</div>
                            <div class="input-text__id">${book.bookInstanceId}</div>
                            <div class="input-text__annotation">Some annotation</div>
                        </div>
                    </section>
                </c:forEach>
            </div>
            <div class="roll down"></div>
        </div>

        <div class="translate">
            <a href="#" class="language"><img class="language" src="../images/eng.png" alt="ENG"></a>
            <a href="#" class="language"><img class="language" src="../images/ru.png" alt="RU"></a>
            <a href="#" class="language"><img class="language" src="../images/ua.png" alt="UA"></a>
        </div>

    </div>
    <footer>
        <div class="title-library footer-title"><fmt:message key="label.lang.heading"/></div>
        <ul class="menu__item">
            <li class="fa phone">
                <i class="fa fa-phone" aria-hidden="true"></i>
                <div> +38(063)-046-1982</div>
            </li>
            <li class="fa map">
                <i class="fa fa-map-marker" aria-hidden="true"></i>
                <div> 67700 Dagenham St England, GB</div>
            </li>
        </ul>
    </footer>
</div>
</body>
</html>
