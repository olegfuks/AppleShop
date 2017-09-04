<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<form action="registr" method="post" class="loginform">
    <label>Якщо Ви зареєстровані, перейдіть на <a href="toLogin">сторінку</a> із входом в систему.</label><br><br>
    <label>Логін :</label><br>
    <input type="text" name="username" class="text_input"><br>
    <label>First name :</label><br>
    <input type="text" name="firstname" class="text_input"><br>
    <label>Last name :</label><br>
    <input type="text" name="lastname" class="text_input"><br>
    <label>Е-мейл :</label><br>
    <input type="text" name="email" class="text_input"><br>
    <label>Пароль :</label><br>
    <input type="password" name="password" class="text_input"><br>
    <input type="submit" value="Зареєструвати" id="registrr">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>


<%@include file="footer.jsp"%>