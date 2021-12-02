<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="lib/css/general.css" rel="stylesheet" type="text/css"/>
        <link href="lib/css/bouton.css" rel="stylesheet" type="text/css"/>
        <link href="lib/css/formulaire.css" rel="stylesheet" type="text/css"/>
        <link href="lib/css/tableau.css" rel="stylesheet" type="text/css"/>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>JSP - Hello World</title>
    </head>
    <body class="body">
        <div class="main-container">
            <c:import url="/menu.jsp"/>
            <div style="flex : 1">
                <c:if test="${pageR != null}">
                    <c:import url="${pageR}"/>
                </c:if>
                <c:if test="${erreurR != null}">
                    <c:import url="/erreur.jsp"/>
                </c:if>
            </div>
        </div>
    </body>
</html>
