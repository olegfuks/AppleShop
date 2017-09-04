<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
    <div id="registration">
        <div class="loginform">
            <label>Якщо у Вас ще немає акаунту, зареєструйтесь за <a href="registration">посиланням</a>.</label>
        </div>
    </div>

    <div id="login">
    <form action="/login" method="post" class="loginform">
        <label>Увійти в свій особистий кабінет :</label><br><br>
        <label>Логін :</label><br>
        <input type="text" name="username" class="text_input"><br>
        <label>Пароль :</label><br>
        <input type="password" name="password" class="text_input"><br>
        <input type="submit" value="Увійти" id="login-button">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
    </div>

<%@include file="footer.jsp"%>
