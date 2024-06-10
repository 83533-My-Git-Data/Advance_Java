<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Syntax</title>
</head>
<body>
    <h2>JSP Syntax!!!</h2>
    
    <!-- HTML Comment -->
    <%-- JSP Comment --%>
    <%-- JSP Declaration --%>
    <%!
      int count = 0;
      
    public void jspInit(){
    	System.out.println("demo1 init() called");
    }
    public void jspDestroy(){
    	System.out.println("demo1 destroy() called");
    }
    %>
    
    <%-- JSP Scriplet --%>
    <%
       Date now = new Date();
       out.println("Server Time: " + now);
    %>
    <br/><br/>
    
    <% count++; %>
    <% if(count % 2 == 0) { %>
      Even Count : <%= count %> 
      <% } else { %>
         Odd Count : <%= count %> <%-- JSP Expression --%>
       <% } %>
       
       <br/><br/>
       
       <%
       if(count % 2 == 0)
    	   out.println("Even count :" +count);
       else
    	   out.println("Odd count :" + count);
       %>
    
</body>
</html>