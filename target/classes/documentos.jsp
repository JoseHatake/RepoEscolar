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
		<form action="Acciones?accion=13" method="POST">
			<table>
				<caption>Repositorio de documentos</caption>
				<thead>
					<tr>
						<th>Materia</th>
						<th>Nivel</th>
						<th>Nombre del documento</th>
						<th>Fecha de subida</th>
						<th>Selecciona</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${archivos}" var="archivo">
						<tr>
							<td><c:out value="${archivo.materia.nombre}"></c:out></td>
							<td><c:out value="${archivo.materia.nivel}"></c:out></td>
							<td><c:out value="${archivo.nombre}"></c:out></td>
							<td><c:out value="${archivo.fechaSubida}"></c:out></td>
							<td><input type="checkbox" value="${archivo.idArchivo}" onclick="checarCheckbox('archivoSelect')" name="archivoSelect" required></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5"><input type="submit" value="Descargar archivos" onmouseover="replacePrameter('formDelDown','X',13)" onmouseleave="replacePrameter('formDelDown',13,'X')"></td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>