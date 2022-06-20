<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de muebles ingresados</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>

	<h1 style="text-align: center">Los datos se han ingresado
		exitosamente!</h1>

	<div class="container">
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Tipo de mueble</th>
					<th scope="col">Tipo de madera</th>
					<th scope="col">Color</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="mueble" items="${mueblesCapturados}">
					<!--  mostramos los atributos de  la captura -->
					<!-- <p>${auto.marca}${auto.modelo}${auto.color}${auto.patente}</p> -->
					<tr>
						<th scope="row">${mueble.id}</th>
						<td>${mueble.tipoMueble}</td>
						<td>${mueble.tipoMadera}</td>
						<td>${mueble.color}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>

</body>
</html>