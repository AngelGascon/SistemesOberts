<%-- 
    Document   : loginSuccessView
    Created on : 31 dic 2022, 11:30:24
    Author     : angel
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login success</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link href="<c:url value="/resources/css/TetrisCode.css" />" rel="stylesheet">
</head>
<body>
    <header class="d-flex">
        <h1 class="p-2 flex-grow-1 header-text-color"><a href="http://localhost:8080/SOBASE/coin.do" style="text-decoration: none; color: inherit">CryptoStore</a></h1>
    </header>
    <div class="Main-Info" style="font-size: 18px;">
        <p>First Name: ${client.name}</p>
        <p>Email: ${client.email}</p>
        <p>Phone: ${client.phone}</p>
        <p>Password: ${client.password.password}</p>
        <p>Authenticated: ${client.auth}</p>
        <a class="button" href="${goBack}" style="background-color: #4CAF50; /* Green */
                                                border: none;
                                                color: black;
                                                padding: 15px 32px;
                                                text-align: center;
                                                text-decoration: none;
                                                display: inline-block;
                                                font-size: 16px;
                                                border-radius: 9999px;"> Go Back</a>
    </div>
</body>
</html>