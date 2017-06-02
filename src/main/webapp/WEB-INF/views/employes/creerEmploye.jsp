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
	<h1>Ajouter un employé</h1>
	
	<form class="form-horizontal">
<fieldset>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Matricule">Matricule</label>  
  <div class="col-md-4">
  <input id="Matricule" name="Matricule" type="text" placeholder="" class="form-control input-md">
    
  </div>
</div>

<!-- ENTREPRISE -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Entreprise">Entreprise</label>
  <div class="col-md-4">
    <select id="Entreprise" name="Entreprise" class="form-control">
    <c:forEach var="entreprise" items="${entreprise}"> 
    	 <option value="">${entreprise.denomination}</option>
    </c:forEach>
    </select>
  </div>
</div>



<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Profil">Profil</label>
  <div class="col-md-4">
    <select id="Profil" name="Profil" class="form-control">
    <c:forEach var="profil" items="${profil}"> 
    	 <option value="">${profil.code}</option>
    </c:forEach>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Grade">Grade</label>
  <div class="col-md-4">
    <select id="Grade" name="Grade" class="form-control">
    <option value=""></option>
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

</fieldset>
</form>
</body>
</html>