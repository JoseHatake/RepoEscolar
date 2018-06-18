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
		<form action="Acciones?accion=14&direccion=documentos.jsp" method="POST">
			<table>
				<caption>Documentos por academia y materia</caption>
				<thead>
					<tr>
						<th>Academia</th>
						<th>Materia</th>
						<th>Nivel</th>
						<th>Select materia</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cursos}" var="curso">
						<tr>
							<td><c:out value="${curso.materia.academia.nombre}"></c:out></td>
							<td><c:out value="${curso.materia.nombre}"></c:out></td>
							<td><c:out value="${curso.materia.nivel}"></c:out></td>
							<td><input type="radio" value="${curso.materia.idMaterias}" name="selectMateria" onchange="checarCheckbox('selectMateria')" required></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td><input type="radio" value="false" checked>Todos los archivos</td>
						<td><input type="radio" value="true">Filtrar por profesor</td>
						<td colspan="4"><input type="submit" value="Ver documentos"></td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>