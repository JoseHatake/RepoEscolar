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
			<h2>Editar perfil</h2>
			<form action="Acciones?accion=27&direccion=verPerfil.jsp" enctype="multipart/form-data" method="POST" style="width: 80%;" class="centrar">
				<h4>Nick: <c:out value="${usuario.nick}"></c:out></h4>
				<c:choose>
						<c:when test="${perfil.avatar != null}">
							<img alt="avatar" id="foto" src="data:image/jpeg;base64,${perfil.avatar}" class="fotoPerfil centrar">
						</c:when>
						<c:otherwise>
							<img alt="avatarDefault" id="foto" src="img/avatarDefault.png" class="fotoPerfil centrar">
						</c:otherwise>
					</c:choose>
					<input type="file" accept="image/*" id="origenFoto" name="foto" onchange="cambiaFoto('origenFoto','foto');">
				<input type="text" maxlength="45" placeholder="Nombre(s) *" value="${usuario.persona.nombres}" name="nombre" class="log" required>
				<input type="text" maxlength="45" placeholder="Apellidos *" value="${usuario.persona.apellidos}" name="apellidos" class="log" required>
				<input type="number" maxlength="15" minlength="8" placeholder="Teléfono de contacto" value="${usuario.persona.telefono}" name="telefono" class="log">
				<input type="email" maxlength="45" placeholder="Correo electrónico *" name="correo" value="${usuario.persona.correo}" class="log" required>
				<input type="submit" id="registro" value="Editar" class="centrar botonConfirm">
			</form>
			<p>* Campos obligatorios</p>
		</div>
	</div>
</body>
</html>