<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register!!!</title>
</head>
<body>
<%-- 
<h3>Online Voting</h3>
--%>
<h3>${initParam.appTitle}</h3>
 <form method= "post" action="register.jsp">
   First Name: <input type="text" name="firstName"/><br/><br/>
   Last Name: <input type="text" name="lastName"/><br/><br/>
   Email: <input type="text" name="email"/><br/><br/>
   Password: <input type="password" name="password"/><br/><br/>
   DOB: <input type="date" name="birth"/><br/><br/>
 
   <input type="submit" value="Register"/>
   </form>
</body>
</html>