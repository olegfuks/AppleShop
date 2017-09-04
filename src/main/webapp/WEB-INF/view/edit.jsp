<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<div class="edit_product">
    <form action="editproduct-${product.id}" method="post" enctype="multipart/form-data">
        <label>Edit product name : </label><input type="text" name="productname" value="${product.productname}" class="text_input"><br>
        <label>Edit product price : </label><input type="text" name="price" value="${product.price}"><br>
        <label>Edit product description : </label><br><textarea name="productdescription" rows="7" cols="40">${product.productdescription}</textarea><br>
        <label>Edit product picture : </label><input type="file" name="picture"><br><br>
        <input type="submit" value="Edit!">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
    <div class="previousphoto">
    <h3>Попереднє фото</h3>
    <img src="${product.productpicture}">
    </div>
</div>
<%@include file="footer.jsp"%>
