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
	</header>
	<div class="contenido centrar">
		<div class="contenedorCentral centrar">
			<h3>Nueva cuenta</h3>
			<form action="Acciones?accion=4&direccion=confirmacion.jsp" enctype="multipart/form-data" method="POST" style="width: 80%;" class="centrar">
				<img src="img/avatarDefault.png" id="portada" class="fotoPerfil centrar" alt="default">
				<input type="file" accept="image/*" id="origenFoto" name="foto" onchange="cambiaFoto('origenFoto','portada');">
				<input type="text" maxlength="45" placeholder="Nombre(s) *" name="nombre" class="log" required>
				<input type="text" maxlength="45" placeholder="Apellidos *" name="apellidos" class="log" required>
				<input type="number" maxlength="15" minlength="8" placeholder="Teléfono de contacto" name="telefono" class="log">
				<input type="email" maxlength="45" placeholder="Correo electrónico *" name="correo" class="log" required>
				<input type="number" maxlength="13" minlength="5" placeholder="Número de acceso *" name="numeroAcceso" class="log" required>
				<input type="password" maxlength="20" minlength="5" placeholder="Contraseña *" id="clave1" name="clave" class="log" onchange="validaClavesIguales('clave1','clave2','registro');" required>
				<input type="password" maxlength="20" minlength="5" placeholder="Repetir contraseña *" id="clave2" name="clave" class="log" onchange="validaClavesIguales('clave1','clave2','registro');"  required>
				<h3>Si eres Administrativo o Profesor</h3>
				<input type="checkbox" name="cargo" value="1" onchange="ifCheckedThenById('cargo',{'claveAcceso1','claveAcceso2'})">Administrativo
				<br>
				<input type="checkbox" name="cargo" value="2" onchange="ifCheckedThenById('cargo',{'claveAcceso1','claveAcceso2'})">Profesor
				<br>
				<label for="claveRegistro">Introduce tu clave de registro</label>
				<input type="password" maxlength="20" minlength="5" placeholder="Clave de acceso" id="claveAcceso1" name="claveAcceso" class="log" onchange="validaClavesIguales('claveAcceso1','claveAcceso2','registro');" required>
				<input type="password" maxlength="20" minlength="5" placeholder="Repetir clave" id="claveAcceso2" name="claveAcceso" class="log" onchange="validaClavesIguales('claveAcceso1','claveAcceso2','registro');"  required>
				<input type="submit" id="registro" value="Registrar" class="centrar botonConfirm">		
			</form>
			<p>* Campos obligatorios</p>
		</div>
	</div>
</body>
</html>