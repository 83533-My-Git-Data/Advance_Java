<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Announcement</title>
</head>
<body>
<jsp:useBean id="ab" class="com.sunbeam.beans.AnnouncementBean" scope="application"/>
<jsp:setProperty name="ab" property="message" param="ann" />

<jsp:forward page="result.jsp"/>
  
</body>
</html>