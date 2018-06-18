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
		<h2>Perfil de usuario</h2>
		<c:choose>
			<c:when test="${perfil.avatar != null}">
				<img alt="avatar" src="data:image/jpeg;base64,${perfil.avatar}" class="fotoPerfil elementosEnLinea">
			</c:when>
			<c:otherwise>
				<img alt="avatarDefault" src="img/avatarDefault.png" class="fotoPerfil elementosEnLinea">
			</c:otherwise>
		</c:choose>
		<table class="elementosEnLinea">
			<tbody>
				<tr>
					<th align="left">Nombre</th>
					<td><c:out value="${usuario.persona.nombres} ${usuario.persona.apellidos}"></c:out></td>
				</tr>
				<tr>
					<th align="left">Numero de acceso</th>
					<td><c:out value="${usuario.nick}"></c:out></td>
				</tr>
				<tr>
					<th align="left">Teléfono</th>
					<td><c:out value="${usuario.persona.telefono}"></c:out></td>
				</tr>
				<tr>
					<th align="left">Correo</th>
					<td><c:out value="${usuario.persona.correo}"></c:out></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2"><a href="editarPerfil.jsp"><input type="button" value="Editar perfil" class="centrar botonConfirm"></a></th>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>