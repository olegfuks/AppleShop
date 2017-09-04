<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<div>
    <nav class="nav">
        <li><a><b>First name</b></a></li>
        <li><a><b>Last name</b></a></li>
        <li><a><b>E-mail</b></a></li>
        <li><a><b>Login</b></a></li>
        <li><a><b>Locked/Unlocked</b></a></li>
    </nav>
    <h3>Non locked accs</h3>
    <nav class="nav">
    <c:forEach items="${nonlockeduser}" var="user">
            <li><a>${user.firstname}</a></li>
            <li><a>${user.lastname}</a></li>
            <li class="useremail"><a>${user.email}</a></li>
            <li><a>${user.username}</a></li>
            <li><a href="lockuser-${user.id}"><img src="/IMAGE/true.jpg"></a></li><br>
    </c:forEach>
        <h3>Locked accs</h3>
    <c:forEach items="${lockeduser}" var="user">
        <li><a>${user.firstname}</a></li>
        <li><a>${user.lastname}</a></li>
        <li><a>${user.email}</a></li>
        <li><a>${user.username}</a></li>
        <li> <a href="unlockuser-${user.id}"><img src="/IMAGE/false.png"></a></li><br>
    </c:forEach>
    </nav>
</div>

<%@include file="footer.jsp"%>

