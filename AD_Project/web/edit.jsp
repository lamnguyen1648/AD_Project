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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/resource/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Edit Course Form:</h1>
            <c:set var="c" value="${requestScope['data']}"/>
            <div class="card">
                <div class="card-body">
                    <form action="CourseControl?ac=doUpdate" method="POST">
                        <div class="form-group row">
                            <label for="id" class="col-sm-2 col-form-label">ID:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtId" value="${c.id}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="name" class="col-sm-2 col-form-label">Course Name:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtName" value="${c.name}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="desc" class="col-sm-2 col-form-label">Course Description:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtDesc" value="${c.desc}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="content" class="col-sm-2 col-form-label">Course Content:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtContent" value="${c.content}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="schedule" class="col-sm-2 col-form-label">Course Schedule:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtSchedule" value="${c.schedule}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="category" class="col-sm-2 col-form-label">Course Category:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtCategory" value="${c.category}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="trainer" class="col-sm-2 col-form-label">Course Trainer:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="txtTrainer" value="${c.trainer}">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Update</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
