<%-- 
    Document   : view_students_list
    Created on : Aug 12, 2018, 1:14:41 AM
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
        <ul>
        <c:forEach var="student" items="${theStudents}">
        <li>  ${student.firstName},${student.lastName}, ${student.email}</li>
        </c:forEach>
        </ul>
    </body>
</html>
