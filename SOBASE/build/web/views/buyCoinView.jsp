<%-- 
    Document   : main-page
    Created on : 15 dic 2022, 16:18:34
    Author     : angel
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Crypto</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link href="<c:url value="/resources/css/TetrisCode.css" />" rel="stylesheet">
</head>
    </head>
    <body>
        <header class="d-flex">
            <h1 class="p-2 flex-grow-1 header-text-color"><a href="http://localhost:8080/SOBASE/coin.do" style="text-decoration: none; color: inherit">CryptoStore</a></h1>
            <div class="p-2 " style="width: 50px"></div>
            <c:if test = "${not empty client}">
                <h2 class="p-2 header-text-color"> Welcome, ${client.name}. </h2>    <!--//TODO show profile-->
                <div class="p-2" style="width: 25px"></div>
                <div class="p-2 header-text-color">
                    <div class="dropdown">
                    <button type="button" class="btn btn-success dropdown-toggle" data-bs-toggle="dropdown">
                      My profile
                    </button>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item">Email: ${client.email}</a></li>
                      <li><a class="dropdown-item">Phone: ${client.phone}</a></li>
                    </ul>
                  </div>    <!--//TODO show profile-->
                <div class="p-2" style="width: 100px"></div>
            </c:if>
        </header>
        
        <div class="Main-Info">
            <div class="col-md-offset-2 col-md-7">
                    <h2 class="text-center">Login form</h2>
                    <div class="panel panel-info">
                            <div class="panel-heading">
                                    <div class="panel-title">Welcome back</div>
                            </div>
                        <div class="panel-body" style="color:black; font-size: 15px">
                                    <form action="login.do" class="form-horizontal"
                                            method="post">

                                            <div class="form-group">
                                                    <label for="username" class="col-md-3 control-label">Username</label>
                                                    <div class="col-md-9">
                                                            <input type="text" name="username" value="${user.username}" class="form-control" />
                                                    </div>
                                            </div>
                                            <div class="form-group">
                                                    <label for="password" class="col-md-3 control-label">Password</label>
                                                    <div class="col-md-9">
                                                            <input type="text" name="password" value="${user.password}" class="form-control" />
                                                    </div>
                                            </div>
                                            <div class="form-group">
                                                    <!-- Button -->
                                                    <div class="col-md-offset-3 col-md-9">
                                                            <input type="submit" value="Submit" />
                                                    </div>
                                            </div>
                                    <form>
                                    <c:if test="${not empty message}">
                                        <div class="alert alert-danger" role="alert">
                                            ${message}
                                        </div>
                                    </c:if>
                            </div>
                    </div>
            </div>
        </div>
    </body>
    
    <script>

    </script>
</html>
