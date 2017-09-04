<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<div class="content-left">
    <div class="changeview">
        <h2 class="changeviewww">Вид  </h2>
        <h2 class="threeproduct">|||</h2>
        <h2 class="fourproduct">||||</h2>
    </div>
    <div class="lastseen">
    </div>
</div>
<div class="content-right">
        <div class="content-right-cat">
<c:forEach items="${categories}" var="cat">
        <div class="categorycontent">
                        <h3 class="ava-${cat.id}">${cat.categoryname}</h3>
                        <img src="${cat.categorypicture}" class="ava-${cat.id}">

        </div>
</c:forEach>
        </div>
</div>
<%@include file="footer.jsp"%>
