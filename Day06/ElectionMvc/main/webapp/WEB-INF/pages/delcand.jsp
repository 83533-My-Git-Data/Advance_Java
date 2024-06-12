<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Candidate</title>
</head>
<body>
   <h3>${initParam.appTitle}</h3>
   <jsp:useBean id="dcb" class="com.sunbeam.beans.FindCandidateBean"/>
   <jsp:setProperty name="dcb" property="*"/>
   ${dcb.deleteCandidate()}
   <c:choose>
         <c:when test="${dcb.count==1}">
              <c:redirect url ="ctl?page=result"/>
         </c:when>
         <c:otherwise>
             Failed!!! <br/><br/>
         </c:otherwise>
   </c:choose>
</body>
</html>