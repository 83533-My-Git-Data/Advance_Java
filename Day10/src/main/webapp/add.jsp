<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product page</title>
</head>
<body>
<%--data transfer from request parameter to javabeans props --%>
<jsp:setProperty property="*" name="product_bean"/>
<%-- req param name must be match with java bean property--%>
<%--Invoke bussi logic method of java bean to add the product --%>
<h5>${sessionScope.product_bean.addNewProduct()}</h5>
</body>
</html>