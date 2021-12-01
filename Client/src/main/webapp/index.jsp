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
        <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP - Hello World</title>
    </head>
    <body class="body">
        <div class="container">
            <c:import url="/menu.jsp"/>
            <div>
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
