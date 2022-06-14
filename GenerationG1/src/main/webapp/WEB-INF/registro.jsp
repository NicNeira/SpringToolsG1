<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
	<div>
		<!-- Pasar informacion desde una vista a una URL (action) -->
		<!-- Por defaul el metodo get, los parametros se ven en la ruta -->
		<!-- Por defaul el metodo post, los parametros no se ven permanecen ocultos -->
		<form action="/registro/usuario" method="Post"
			style="text-align: center">
			<label for="nombre">Nombre: </label>
			<!-- Etiqueta para captar informacion -->
			<input type="text" id="nombre" name="nombre"> <br>
			<!--  salto de linea -->
			<label for="apellido">Apellido: </label>
			<!-- el ford: para relacionar el nombre y marcar input automaticamente -->
			<input type="text" id="apellido" name="apellido"> <br>
			<!--  salto de linea -->
			<label for="edad">Edad: </label>
			<!-- el ford: para relacionar el nombre y marcar input automaticamente -->
			<input type="number" id="edad" name="edad"> <br>
			<!-- submit para el envio de informacion -->
			<input type="submit" value="Registrar">
			<!-- simplemente un botton de momento no hace nada -->
			<input type="button" value="Enviar">
		</form>
	</div>
</body>
</html>