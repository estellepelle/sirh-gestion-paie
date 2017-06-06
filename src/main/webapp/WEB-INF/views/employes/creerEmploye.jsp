<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
	
	<h1 style="text-align:center">Ajouter un employé</h1>
	
	<form class="form-horizontal"  method="post">
<fieldset>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Matricule">Matricule</label>  
  <div class="col-md-4">
  <input id="Matricule" name="matricule" type="text" placeholder="" class="form-control input-md">
    
  </div>
</div>

<!-- ENTREPRISE -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Entreprise">Entreprise</label>
  <div class="col-md-4">
    <select id="Entreprise" name="entreprise" class="form-control">
    <c:forEach var="entreprise" items="${entreprise}"> 
    	 <option value="${entreprise.id}">${entreprise.denomination}</option>
    </c:forEach>
    </select>
  </div>
</div>



<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Profil">Profil</label>
  <div class="col-md-4">
    <select id="Profil" name="profil" class="form-control">
    <c:forEach var="profil" items="${profil}"> 
    	 <option value="${profil.id}">${profil.code}</option>
    </c:forEach>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Grade">Grade</label>
  <div class="col-md-4">
    <select id="Grade" name="grade" class="form-control">
    <c:forEach var="grade" items="${grade}"> 
    	 <option value="${grade.id}">${grade.code}</option>
    </c:forEach>
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="ajout"></label>
  <div class="col-md-4">
    <button id="ajout" name="ajout" class="btn btn-primary">Ajouter</button>
  </div>
</div>
<sec:csrfInput/>
</fieldset>
</form>
</body>
</html>