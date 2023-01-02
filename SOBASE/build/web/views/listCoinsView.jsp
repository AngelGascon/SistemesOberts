<%-- 
    Document   : listCoinsView
    Created on : 15 dic 2022, 16:18:33
    Author     : angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <link href="<c:url value="/resources/css/TetrisCode.css" />" rel="stylesheet">
        <title>CryptoStore: coinList</title>
    </head>
    <body>
        <header class="d-flex">
            <h1 class="p-2 flex-grow-1 header-text-color"><a href="http://localhost:8080/SOBASE/coin.do" style="text-decoration: none; color: inherit">CryptoStore</a></h1>
            <div class="p-2 " style="width: 50px"></div>
            <h2 class="p-2 header-text-color">Register</h2>
            <div class="p-2" style="width: 50px"></div>
            <h2 class="p-2 header-text-color"><a href="http://localhost:8080/SOBASE/login.do" style="text-decoration: none; color: inherit">Login</a></h2>
            <div class="p-2" style="width: 50px"></div>
        </header>
        
        <div class="Main-Info">          
            <h2 id="order" style="margin-bottom: 50px">Cryptocurrency Available</h2>
            
            <c:forEach var="listValue" items="${coinList}">
                <a href="http://localhost:8080/SOBASE/coinInfo.do?id=${listValue.id}" target="_blank" >
                    <img src='resources/img/${listValue.name}.png' width='80' height='80' /></a>
                
                <b style="padding-left: 10px">${listValue.name}</b>
                </br>
                </br>
                ${listValue.description}
                <p>Price history: ${listValue.lastQuotation}</p><br><br><br><br>
            </c:forEach>
            <c:if test = "${not empty auth}">
                <p>${auth.username} </p>
            </c:if>
        </div>      
      
    </body>
    
    <script>
        $( "#order" ).click(function() {
            window.location.replace("http://localhost:8080/SOBASE/coin.do?order=asc");
        });
        
    </script>
</html>
