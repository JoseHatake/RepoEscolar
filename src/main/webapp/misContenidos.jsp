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
		<form action="Acciones?accion=X&direccion=misContenidos.jsp" id="formDelDown" method="POST">
			<table>
				<caption>Mis documentos subidos</caption>
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
					<c:forEach items="${profesor.archivos}" var="archivo">
						<tr>
							<td><c:out value="${archivo.materia.nombre}"></c:out></td>
							<td><c:out value="${archivo.materia.nivel}"></c:out></td>
							<td><c:out value="${archivo.nombre}"></c:out></td>
							<td><c:out value="${archivo.fechaSubida}"></c:out></td>
							<td><input type="checkbox" value="${archivo.idArchivo}" name="archivoSelect"></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2"><input type="submit" value="Borrar archivos" onmouseover="replacePrameter('formDelDown','X',12)" onmouseleave="replacePrameter('formDelDown',12,'X')"></td>
						<td colspan="3"><input type="submit" value="Descargar archivos" onmouseover="replacePrameter('formDelDown','X',13)" onmouseleave="replacePrameter('formDelDown',13,'X')"></td>
					</tr>
				</tfoot>
			</table>
		</form>
		<form action="Acciones?accion=8&direccion=misContenidos.jsp" method="POST" enctype="multipart/form-data">
			<div id="contenedorDocumentos">
				<div id="archivoPorSubir">
					<select name="materiaAsociada" required>
						<option value="">Selecciona una materia</option>
						<c:forEach items="${profesor.cursos}" var="curso">
							<option value="${curso.materia.idMaterias}"><c:out value="${curso.materia.nombre}"></c:out></option>
						</c:forEach>
					</select>
					<input type="file" name="archivo" accept="file_extension|audio/*|video/*|image/*|media_type">
				</div>
			</div>
			<table>
				<tbody>
					<tr>
						<td><input type="button" value="Agregar documento" onclick="duplicaElemento('archivoPorSubir','contenedorDocumentos')"></td>
						<td><input type="submit" value="Cargar documentos"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>