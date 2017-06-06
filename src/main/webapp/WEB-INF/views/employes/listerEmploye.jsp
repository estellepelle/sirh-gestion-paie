<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIRH - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
	
	<header>
		<a href="lister">Employes</a>
		<a href="#">Bulletins</a>
	</header>
	
	<h1 style="text-align:center">Liste des employés</h1>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Date/Heure création</th>
				<th>Matricule</th>
				<th>Grade</th>
			</tr>
		</thead>
	
		<tbody>
			<c:forEach var="employe" items="${employe}">
	 		<tr>
				<td>${employe.dateCreation}</td>
				<td>${employe.matricule}</td>
				<td>${employe.grade.code}</td>
			</tr>
		 </c:forEach>
		</tbody>
	 	
	</table>
</body>
</html>