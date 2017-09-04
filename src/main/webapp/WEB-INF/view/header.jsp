<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Apple shop</title>
    <link rel="stylesheet" href="/TRIGER/style.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js" type="text/javascript"></script>
    <script src="/JS/jquery-3.2.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



</head>
<body>
        <div id="fixedtopelement">
            <%--<a href="/"><img src="/IMAGE/apple.jpg" class="topsign"></a>--%>
            <ul class="nav_1">
                <li><a class="topsignA" href="/"><img src="/IMAGE/apple.jpg" class="topsign"></a></li>
                <li><a href="/">Контакти</a></li>
                <li><a href="/">Доставка</a></li>
                <li class="searchli">
                    <input type="text" name="search" id="searchinput">
                    <input type="submit" id="searchproduct" value="Знайти">
                </li>
                <li>
                    <a href="cart" id="cartt">Корзина (0)</a>
                </li>
                <sec:authorize access="isAuthenticated()">
                <li>
                    <form action="/logout">
                    <a href="/logout">Вийти</a>
                    </form>
                </li>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                <li><a href="toLogin">Увійти</a></li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="admin">АДМІН</a></li>
                </sec:authorize>
            </ul>
        </div>
        <div class="topnavigation">

            <c:forEach items="${categories}" var="cat">
                <div class="topnavigation_cat">
                    <img src="${cat.categorypicture}" class="ava-${cat.id}">
                    <p class="ava-${cat.id}">${cat.categoryname}</p>
                </div>
            </c:forEach>

        </div>

        <div id="content">



