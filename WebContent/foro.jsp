<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="com.uniovi.sdi.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Foro SDI- UO258367</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<!-- Redirect login-->
<c:if test="${sessionScope.usuario == null}">
	<c:redirect url="/login.jsp" />
</c:if>

<!-- Contenido -->
<div class="container" id="contenedor-principal">
		<h2>5.2 Foro SDI - UO258367</h2>
		<form class="form-Comentario" method="post" action="addComentario">
			<div>
				<input type=text />
				<button type="submit" class="btn btn-primary">Agregar</button>
			</div>
			<div>
			<c:forEach var="com" items="${listaComentarios}">
				<div>
				<p>Author: ${com.getAuthor()}</p>
				<p>${com.getMessage()}</p>
				</div>
			</c:forEach>
			</div>
		</form>
	</div>
</body>
</html>