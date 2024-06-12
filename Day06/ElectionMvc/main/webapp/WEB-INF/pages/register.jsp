<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Beans</title>
</head>
<body>
<h3>${initParam.appTitle}</h3>
   <jsp:useBean id="rb" class="com.sunbeam.beans.RegistrationBean" scope="page"/>
   
   <jsp:setProperty property="firstName" name="rb" param="firstName"/>
   <jsp:setProperty property="lastName" name="rb" param="lastName"/>
   <jsp:setProperty property="email" name="rb" param="email"/>
   <jsp:setProperty property="password" name="rb" param="password"/>
   <jsp:setProperty property="birth" name="rb" param="birth"/>
   
   
   
   <%-- 
   <% int c=rb.register(); %>
   --%>
   ${rb.register()}
   <%-- 
   <% if(rb.getCount()== 1){ %>
         Successfully resgistered!!<br/> 
         <a href="index.jsp">Sign In</a>
         
    <% } else { %>
         registration failed!!
         <a href="newuser.jsp">Sign Up</a>
     <% } %>
     --%>
     
     <c:choose>
         <c:when test = "${rb.count == 1}">
              Succesfully registered!!!
              <a href = "ctl?page=index">Sign In</a>
         </c:when>
         <c:otherwise>
               Registration failed!!!!
               <a href= "ctl?page=newuser">Sign Up</a>
         </c:otherwise>
     </c:choose>
    
</body>
</html>