<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Gestion des Utilisateurs</title>
    <link rel="stylesheet" href="<c:url value='style/style.css'/>" />
</head>
<body>
    <header>
        <h1>GESTION DES UTILISATEURS</h1>
    </header>
    <nav>
        <a href="<c:url value='list'/>">Accueil</a>
        <a href="<c:url value='adduser'/>">Ajouter</a>
        <a href="<c:url value='list'/>">Lister</a>
    </nav>
</body>
</html>
