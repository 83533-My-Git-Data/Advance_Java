<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Announcement</title>
</head>
<body>
<jsp:useBean id="ab" class="com.sunbeam.beans.AnnouncementBean" scope="application"/>
<jsp:setProperty name="ab" property="message" param="ann" />

<c:redirect url="ctl?page=result"/>
  
</body>
</html>