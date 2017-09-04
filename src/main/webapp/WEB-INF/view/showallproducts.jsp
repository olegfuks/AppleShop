<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>



<div id="odmen">
    <c:forEach items="${products}" var="product">
        <div class="admindivv">
            <img src="${product.productpicture}">
            <p>${product.productname}</p>
            <p>${product.price} $</p>
            <a href="delete-${product.id}"><img src="/IMAGE/button.jpg"></a>
            <a href="edit-${product.id}"><img src="/IMAGE/edit.jpg"></a>
        </div>
    </c:forEach>
</div>

<%@include file="footer.jsp"%>

