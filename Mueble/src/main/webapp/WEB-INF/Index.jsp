<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ingresa el auto que deseas registrar</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>
	<div class="p-3 mb-2 bg-primary text-white">
		<!--  en caso de que exita un error enviamos parametro msgError con el texto -->
		<c:if test="${msgError!= null }">
			<c:out value="${msgError }"></c:out>
		</c:if>

		<form:form action="/guardar" method="post" modelAttribute="mueble"
			autocomplete="off">
			<form:label path="tipoMueble" class="form-label">Tipo Mueble:</form:label>
			<form:input path="tipoMueble" class="form-control" />
			<br>
			<form:label path="tipoMadera" class="form-label">Tipo Madera utilizada:</form:label>
			<form:input path="tipoMadera" class="form-control" />
			<br>
			<form:label path="color" class="form-label">Color:</form:label>
			<form:input path="color" class="form-control" />
			<br>
			<input type="submit" value="Registrar" class="btn btn-primary">

		</form:form>
	</div>
</body>
</html>