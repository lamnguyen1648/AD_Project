<%-- 
    Document   : addNew
    Created on : Aug 24, 2021, 10:54:57 PM
    Author     : lamsu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Course</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/resource/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Add Course Form:</h1>
            <div class="card">
                <div class="card-body">
                    <form action="CourseControl?ac=add" method="POST">
                        <div class="form-group row">
                            <label for="id" class="col-sm-2 col-form-label">ID:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtId" placeholder="Enter Course ID">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="name" class="col-sm-2 col-form-label">Course Name:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtName" placeholder="Enter Course name">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="desc" class="col-sm-2 col-form-label">Course Description:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtDesc" placeholder="Enter Course description">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="content" class="col-sm-2 col-form-label">Course Content:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtContent" placeholder="Enter Course content">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="schedule" class="col-sm-2 col-form-label">Course Schedule:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtSchedule" placeholder="Enter Course schedule">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="category" class="col-sm-2 col-form-label">Course Category:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtCategory" placeholder="Enter Course category">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="trainer" class="col-sm-2 col-form-label">Course Trainer:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtTrainer" placeholder="Enter Course trainer">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
