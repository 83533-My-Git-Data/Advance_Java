<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<%-- 
   <h3>Online Voting</h3>
 --%>  
 <h3>${initParam.appTitle }</h3>
 <!--  <form method= "post" action="login.jsp"> -->
   <form method= "post" action="ctl?page=login">
   Email: <input type="text" name="email"/><br/><br/>
   Password: <input type="password" name="passwd"/><br/><br/>
   <input type="submit" value="Sign In"/>
   <!--  <a href="newuser.jsp">Sign Up</a>-->
   <a href="ctl?page=newuser"/>Sign Up</a>
   </form>
</body>
</html>