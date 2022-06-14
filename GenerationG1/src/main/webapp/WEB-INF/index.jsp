<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--  La biblioteca de etiquetas estándar de JSP (JSTL) 
	representa un conjunto de etiquetas para simplificar el 
	desarrollo de JSP.  -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nicolas Neira</title>
</head>
<body>

	<h1 style="text-align: center; color: red;">
		<c:out value="${nombres}"></c:out>
		<c:out value=" ${apellidos}"></c:out>
	</h1>
	<!-- $ = place holder -->
	<h2 style="text-align: center">
		<c:out value="${edad}"></c:out>
	</h2>
	<p style="color:red; background-color: Black;">It is a long established fact that a reader will be distracted
		by the readable content of a page when looking at its layout. The
		point of using Lorem Ipsum is that it has a more-or-less normal
		distribution of letters, as opposed to using 'Content here, content
		here', making it look like readable English. Many desktop publishing
		packages and web page editors now use Lorem Ipsum as their default
		model text, and a search for 'lorem ipsum' will uncover many web sites
		still in their infancy. Various versions have evolved over the years,
		sometimes by accident, sometimes on purpose (injected humour and the
		like).</p>

	<p style="text-align: center;">
		<c:out value="${usuario.apellido}${usuario.edad}"></c:out>
	</p>
	
	<p style="text-align: center;">
	<c:out value="${usuario}"></c:out>
	</p>
	
</body>
</html>
