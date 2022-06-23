<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Licencia</title>
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

		<!-- Creamos un formulario para la pagina licencia.jsp -->
		<form:form action="/licencia/guardar" method="post"
			modelAttribute="licencia" autocomplete="off">
			<form:label path="numero" class="form-label">numero:</form:label>
			<form:input path="numero" type="number" class="form-control" />
			<br>
			<form:label path="fechaVencimiento" class="form-label">Fecha Vencimiento:</form:label>
			<form:input path="fechaVencimiento" type="date" min="2018-01-01"
				max="2030-01-01" class="form-control" />
			<br>
			<form:label path="clase" class="form-label">Clase:</form:label>
			<form:input type="text " path="clase" class="form-control" />
			<br>
			<form:label path="estado" class="form-label">Estado:</form:label>
			<form:input path="estado" type="text" class="form-control" />
			<br>
			<!-- Usuario -->
			<form:select path="usuario" class="form-select">
				<form:option value="0">Seleccione un usuario</form:option>

				<!--  Recorremos lista de usario -->
				<c:forEach items="${listaUsuarios}" var="usuario">
					<!-- Se aplicó una condición, si usuario.licencia.id aun no existe, la muestra  -->
					<c:if test="${usuario.licencia.id == null}">
						<!-- Em el value lo que nosostros pasamos es la primaryKey -->
						<form:option value="${usuario.id}">${usuario.nombre} ${usuario.apellido} </form:option>
					</c:if>
				</c:forEach>
			</form:select>
			<button type="submit" class="btn btn-outline-primary">Guardar
				Licencia</button>
		</form:form>
		<br>
		<div class="container">
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Id</th>
						<th scope="col">Numero</th>
						<th scope="col">Fecha Vencimiento</th>
						<th scope="col">Estado</th>
						<th scope="col">Usuario</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="licencia" items="${listaLicencias}">
						<!--  mostramos los atributos de  la captura -->
						<tr>
							<th scope="row">${licencia.id}</th>
							<td>${licencia.numero}</td>
							<td>${licencia.fechaVencimiento}</td>
							<td>${licencia.clase}</td>
							<td>${licencia.estado}</td>
							<!-- Atraves de la licencia, accedemos al usuario que tiene asociado -->
							<td>${licencia.usuario.nombre}${usuario.apellido}</td>
							<!-- LAZY -->
							<!-- Agregar editar y eliminar la licencia -->

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>