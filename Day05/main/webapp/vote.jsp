<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>
</head>
<body>
<h3>${initParam.appTitle}</h3>
Hello, ${lb.user.firstName} ${lb.user.lastName}<hr/>
Vote Done!!
<jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean"/>

${vb.Voted()}

<a href="logout.jsp">Sign Out</a>
</body>
</html>