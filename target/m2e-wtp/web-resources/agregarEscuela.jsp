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
			<h3>Nueva escuela</h3>
			<form action="Acciones?accion=21&direccion=confirmacion.jsp" method="POST" enctype="multipart/form-data" style="width: 80%;" class="centrar">
				<img src="img/escudo.png" id="portada" class="fotoEscuela centrar" alt="default">
				<input type="file" accept="image/*" id="origenFoto" name="foto" onchange="cambiaFoto('origenFoto','portada');">
				<input type="text" maxlength="100" placeholder="Nombre *" name="nombre" class="log" required>
				<input type="text" maxlength="100" placeholder="Dirección *" name="direccion" class="log" required>
				<input type="number" maxlength="15" minlength="8" placeholder="Teléfono de contacto *" name="telefono" class="log" required>
				<input type="number" maxlength="5" minlength="3" placeholder="Extensión *" name="extensionTele" class="log" required>
				<input type="text" maxlength="80" minlength="5" placeholder="Sitio web oficial *" name="sitioWeb" class="log" required>
				<input type="text" maxlength="10" minlength="3" placeholder="Referencia de la escuela *" name="referencia" class="log"required>
				<input type="text" maxlength="20" minlength="5" placeholder="Clave de acceso administrativo" name="claveAccesoAdmin" class="log" required>
				<input type="text" maxlength="20" minlength="5" placeholder="Clave de acceso profesor" name="claveAccesoProfesor" class="log" required>
				<input type="submit" id="registro" value="Registrar" class="centrar botonConfirm">
			</form>
			<p>* Campos obligatorios</p>
		</div>
	</div>
</body>
</html>