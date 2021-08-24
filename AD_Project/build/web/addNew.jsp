<%-- 
    Document   : addNew
    Created on : Aug 24, 2021, 10:54:57 PM
    Author     : lamsu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Course</title>
    </head>
    <body>
        <h1>Add New Course</h1>
        
        <form action="CourseControl?ac=add" method="POST">
            <label for="fname">ID:</label><br>
            <input type="text" name="txtId"><br>
            <label for="fname">Name:</label><br>
            <input type="text" name="txtName"><br>
            <label for="fname">Description:</label><br>
            <input type="text" name="txtDesc"><br>
            <label for="fname">Content:</label><br>
            <input type="text" name="txtContent"><br>
            <label for="fname">Schedule:</label><br>
            <input type="text" name="txtSchedule"><br>
            <label for="fname">Category:</label><br>
            <input type="text" name="txtCategory"><br>
            <label for="fname">Trainer:</label><br>
            <input type="text" name="txtTrainer"><br>
            <br>
            <br>
            <input type="submit" value="Add New">
        </form>
    </body>
</html>
