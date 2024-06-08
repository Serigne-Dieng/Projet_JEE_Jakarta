<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Ajouter utilidateur</title>
    <link rel="stylesheet" href="<c:url value="style/style.css"/>" /> 
</head>
<c:import url="component/header.jsp"/>
<body>
    <form action="adduser" method="post">
        <div class="form-container">
            <div>
                <label for="nom">Prenom:</label>
                <input type="text" name="nom" id="nom"/>
            </div>
            <div>
                <label for="prenom">Nom:</label>
                <input type="text" name="prenom" id="prenom"/>
            </div>
            <div>
                <label for="login">Login:</label>
                <input type="text" name="login" id="login"/>
            </div>
            <div>
                <label for="password">Mot de Passe</label>
                <input type="password" name="password" id="password"/>
            </div>
        </div>
        <div class="button">
            <button type="submit">ajouter</button>
        </div>
    </form>
</body>
<c:import url="component/footer.jsp"/>
</html>
