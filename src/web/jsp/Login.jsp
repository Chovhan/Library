<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="startpage" />

<% if(request.getCharacterEncoding() == null) {
    request.setCharacterEncoding("UTF-8");
} %>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="icon"  type="image/x-icon" href="http://loveferrari.l.o.pic.centerblog.net/99fce96a.png">
    <link rel="stylesheet" href="../css/Login.css">
    <title>Login</title>
</head>
<body>

<div class="wrap">
    <div class="wrapper">
        <label class="heading log"><fmt:message key="label.lang.headingLog" /></label>
        <label class="heading sign"><fmt:message key="label.lang.headingSign" /></label>
        <div class="forms">
            <input class="switch" id="switch1" type="checkbox" >
            <label for="switch1" class="switch-for" ></label>
            <div class="Login">
                <form action="login" method="post">
                    <label for="Log-in__email"><fmt:message key="label.lang.eMail" /></label>
                    <input type="email" name="Log-in__email" id="Log-in__email" required>
                    <label for="Log-in__password"><fmt:message key="label.lang.password" /></label>
                    <input type="password" name="Log-in__password" id="Log-in__password">
                    <input type="submit" name="Log-in__button" id="loginButton" value="<fmt:message key="label.lang.headingLog" />">
                </form>
            </div>

            <div class="Signup">
                <form action="sing" method="post">
                    <label for="Signup__name"><fmt:message key="label.lang.name"/></label>
                    <input name="Signup__name" id="Signup__name"  type="text"  required>

                    <label for="Signup__surname"><fmt:message key="label.lang.surname"/></label>
                    <input name="Signup__surname" id="Signup__surname"  type="text"  required>

                    <label for="Signup__tel"><fmt:message key="label.lang.phoneNumber"/></label>
                    <input name="Signup__tel" id="Signup__tel"  type="tel"  required>

                    <label for="Signup__email"><fmt:message key="label.lang.eMail"/></label>
                    <input type="email" name="Signup__email" id="Signup__email" required>

                    <label for="Signup__password"><fmt:message key="label.lang.password"/></label>
                    <input type="password" name="Signup__password" id="Signup__password" required>

                    <input type="submit" name="Signup__button" id="signButton" value="<fmt:message key="label.lang.headingSign" />">
                </form>
            </div>
        </div>
        <div class="translate">
            <a href="?lang=en" class="language"><img class="language" src="../images/eng.png" alt="ENG" ></a>
            <a href="?lang=ru" class="language"><img class="language" src="../images/ru.png" alt="RU"></a>
            <a href="?lang=ua" class="language"><img class="language" src="../images/ua.png" alt="UA"></a>

        </div>
    </div>
</div>

</body>
</html>
