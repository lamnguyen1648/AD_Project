<%-- 
    Document   : newjsp
    Created on : Aug 24, 2021, 9:43:35 PM
    Author     : lamsu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FPT Internal Training System</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <style>
        table, th, td {
            width: 40%;
            text-align: center;
            border: 1px solid black;
        }
        .center{
            margin-left: auto;
            margin-right: auto;
        }
    </style>
    <body>
        <h1 style="text-align: center;">Home</h1>
        <table class="center">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Content</th>
                <th>Schedule</th>
                <th>Category</th>
                <th>Trainer</th>
            </tr>
            <c:if test="${empty requestScope['listC']}">
                <jsp:forward page="/CourseControl?ac=view"/>
            </c:if>>
            <c:forEach items="${requestScope['listC']}" var="x">
                <tr>
                    <td>${x.id}</td>
                    <td>${x.name}</td>
                    <td>${x.desc}</td>
                    <td>${x.content}</td>
                    <td>${x.schedule}</td>
                    <td>${x.category}</td>
                    <td>${x.trainer}</td>
                    <td><a href="CourseControl?ac=edit&id=${x.id}">Update</td>
                    <td><a href="CourseControl?ac=del&id=${x.id}">Delete</td>
                </tr>
            </c:forEach>
                <div>
                    <a href="CourseControl?ac=loadUpdate" style="text-align: center">Add New Course</a>
                </div>
        </table>>
    </body>
</html>
