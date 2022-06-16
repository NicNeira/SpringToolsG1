<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
	<div>
	<!--  en caso de que exita un error enviamos parametro msgError con el texto -->
		<c:if test="${msgError!= null }">
			<c:out value="${msgError }"></c:out>
		</c:if>


		<!-- Estructura para cuando trabajemos con formularios -->
		<form:form action="/registro/usuario" method="post"
			modelAttribute="usuario">
			<form:label path="nombre">Nombre:</form:label>
			<form:input path="nombre" />
			<br>
			<form:label path="apellido">Apellido:</form:label>
			<form:input path="apellido" />
			<br>
			<form:label path="edad">Edad:</form:label>
			<form:input type="number" path="edad" />
			<br>
			<form:label path="password">Contraseña</form:label>
			<form:input path="password" />
			<input type="submit" value="Registrar">
		</form:form>
	</div>
</body>
</html>