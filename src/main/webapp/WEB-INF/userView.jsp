<%@page import="bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Tables des Utilisateurs</title>
		<link rel="stylesheet" href="<c:url value ="style/style.css"/>" /> 
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<c:import url="component/header.jsp"/>
	<body>
		<c:choose>
			<c:when test="${empty utilisateurs}">
				<p class="error-message">Liste d'utilisateurs vide !</p>	
			</c:when>
			<c:otherwise>
				<div class="centered-content">
				<table class="centered-table">
						<thead>
							<tr>
							<th>Id</th>
							<th>Nom</th>
							<th>Prenom</th>
							<th>Login</th>
							<th>Mot De passe</th>
							<th colspan="2" class="action-column">Action</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="utilisateur" items="${utilisateurs}">
							<tr>
								<td>${utilisateur.id}</td>
								<td>${utilisateur.prenom}</td>
								<td>${utilisateur.nom}</td>
								<td>${utilisateur.login}</td>
								<td>${utilisateur.password}</td>
								<td class="action"><a href="<c:url value="update?id=${utilisateur.id}"/>"><i class="fa fa-edit" style="font-size:24px;color:blue"></i></a></td>
								<td class="action"><a href="<c:url value="delete?id=${utilisateur.id}"/>"><i class="fa fa-trash-o" style="font-size:24px;color:red"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table></div>
			</c:otherwise>
		</c:choose>
	</body>
	<c:import url="component/footer.jsp"/>
</html>
