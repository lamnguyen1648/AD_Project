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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/resource/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/./home.css" /> 
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
        <div class="container">
            <h1>Home Page</h1>
            <div class="card">
                <div class="card-body">
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
                        </c:if>
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
                                <a href="CourseControl?ac=loadUpdate">Add New Course</a>
                            </div>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
