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
	</header>
	<div class="contenedorCentral centrar">
		<h3>Iniciar sesión</h3>
		<form action="Acciones?accion=3&direccion=inicioSesion.jsp" method="POST" style="width: 210px;" class="centrar">
			<input type="number" maxlength="13" minlength="5" placeholder="Número de boleta" name="numeroBoleta" class="log" required>
			<input type="password" maxlength="20" minlength="5" placeholder="Contraseña" name="clave" class="log" required>
			<input type="submit" value="Iniciar" class="centrar botonConfirm">
		</form>
		<a class="resaltarLink">Nueva cuenta</a>
		<br>
		<a class="resaltarLink">Recuperar contraseña</a>
	</div>
</body>
</html>