<%-- 
    Document   : edit
    Created on : Aug 24, 2021, 9:44:07 PM
    Author     : lamsu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Course</title>
    </head>
    <body>
        <h1>Edit Course</h1>
        
        <c:set var="c" value="${requestScope['data']}"/>
        <form action="CourseControl?ac=doUpdate" method="POST">
            <label for="fname">ID:</label><br>
            <input type="text" name="txtID" value="${c.id}"><br>
            <label for="fname">Name:</label><br>
            <input type="text" name="txtName" value="${c.name}"><br>
            <label for="fname">Description:</label><br>
            <input type="text" name="txtDesc" value="${c.desc}"><br>
            <label for="fname">Content:</label><br>
            <input type="text" name="txtContent" value="${c.content}"><br>
            <label for="fname">Schedule:</label><br>
            <input type="text" name="txtSchedule" value="${c.schedule}"><br>
            <label for="fname">Category:</label><br>
            <input type="text" name="txtCategory" value="${c.category}"><br>
            <label for="fname">Trainer:</label><br>
            <input type="text" name="txtTrainer" value="${c.trainer}"><br>
            <br>
            <br>
            <input type="submit" value="Update">
        </form>
    </body>
</html>
