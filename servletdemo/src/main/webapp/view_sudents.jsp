<%-- 
    Document   : view_sudents
    Created on : Aug 12, 2018, 12:59:03 AM
    Author     : Dark
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- The servlet is called and redirect the request to the JSP-->
        <c:forEach var="tempStudent" items="${student_list}">
            ${tempStudent} <br/>
        </c:forEach>
    </body>
</html>
