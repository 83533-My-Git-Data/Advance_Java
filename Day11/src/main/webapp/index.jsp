<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>
		Welcome !
	</h5>
	<h5>
	<c:url var="url" value="/products/view?minP=20&maxP=700"></c:url>
	<a href="${url}">Product List</a>
	</h5>
</body>
</html>