<%@include file="header.jsp"%>

<a href="showallproducts">Show all products</a><br>
<a href="showallusers">Show all users</a><br><br>
<sf:form action="savecategory" method="post" modelAttribute="emptyCategory" enctype="multipart/form-data">
    <label>Input category name : </label> <sf:input path="categoryname"/><br>
    <label>Choose category picture : </label><input type="file" name="pic"><br>
    <input type="submit" value="Add!">
</sf:form><br><br>

<sf:form action="saveproduct" method="post" modelAttribute="emptyProduct" enctype="multipart/form-data">
    <label>Input product name : </label><sf:input path="productname"/><br>
    <label>Input product price : </label><sf:input path="price"/><br>
    <label>Input product description : </label><br><sf:textarea path="productdescription" rows="7" cols="40"/><br>
    <label>Choose product picture : </label><input type="file" name="picture"><br><br>
    <label>Choose category of the product : </label><sf:select path="category">
    <c:forEach items="${categories}" var="cat">
        <sf:option value="${cat.id}">${cat.categoryname}</sf:option>
    </c:forEach>
</sf:select><br>
    <input type="submit" value="Add!">
</sf:form>

<%@include file="footer.jsp"%>
