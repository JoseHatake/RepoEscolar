<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta name="author" content="Jose Miguel Gutierrez Guevara">
	<meta name="author" content="Hermilo Zahis Hernandez Garcia">
	<title>RepoEscolar</title>
	<!-- Estilos css -->
	<link rel="stylesheet" type="text/css" href="css/normalize.css">
	<link rel="stylesheet" type="text/css" href="css/label.css">
	<link rel="stylesheet" type="text/css" href="css/classStyle.css">
	<link rel="stylesheet" type="text/css" href="css/idStyle.css">
	<link rel="stylesheet" type="text/css" href="css/responsiveClassStyle.css">
	<!-- Estilos css -->

	<!-- JavaScript -->
	<script type="text/javascript" src="js/generales.js"></script>
	<script type="text/javascript" src="js/cargaContenido.js"></script>
	<!-- JavaScript -->
</head>
<body>
	<header>
		<div id="head-logo" style="padding: 10px;"></div>
		<nav id="menu-navegacion"></nav>
		<div id="menu-perfil-${perfil.rol}" style="display: none;" onmouseleave="switchEstado('menu-perfil-${perfil.rol}')"></div>
	</header>
	<div class="contenido centrar">
		<div class="contenedorCentral centrar">
			<h3>Agregar boletas de alumnos</h3>
			<form action="Acciones?accion=22&direccion=confirmacion.jsp" method="POST" style="width: 80%;" class="centrar">
				<input type="number" maxlength="10" minlength="10" placeholder="Boleta inicial" name="inicial" class="log" required>
				<input type="number" maxlength="10" minlength="10" placeholder="Boleta final" name="final" class="log"required>
				<input type="submit" id="registro" value="Generar registros" class="centrar botonConfirm">
			</form>
		</div>
	</div>
</body>
</html>