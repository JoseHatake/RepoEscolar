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
		<form action="Acciones?accion=17&direccion=asociarMaterias.jsp" method="POST">
			<table>
				<caption>Materias asociadas</caption>
				<thead>
					<tr>
						<th>Materia</th>
						<th>Grupo</th>
						<th>Profesor</th>
						<th>Seleccionar curso</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${alumno.clases}" var="clase">
						<tr>
							<td><c:out value="${clase.curso.materia.nombre}"></c:out></td>
							<td><c:out value="${clase.curso.grupo.grupo}"></c:out></td>
							<td><c:out value="${clase.curso.profesor.usuario.persona.nombres} ${clase.curso.profesor.usuario.persona.apellidos}"></c:out></td>
							<td><input type="checkbox" name="claseAsociada" value="${clase.idClase}"></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th colspan="4"><input type="submit" value="Borrar materias"></th>
					</tr>
				</tfoot>
			</table>
		</form>
		<form action="Acciones?accion=18&direccion=asociarMaterias.jsp" method="POST">
			<table>
				<thead>
					<tr>
						<th>Grupo</th>
						<th>Materia</th>
						<th>Profesor</th>
						<th>Inscribir</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todosLosGrupos}" var="grupo">
						<c:forEach items="${grupo.cursos}" var="curso">
							<tr>
								<td><c:out value="${grupo.grupo}"></c:out></td>
								<td><c:out value="${curso.materia.nombre}"></c:out></td>
								<td><c:out value="${curso.profesor.usuario.persona.nombres} ${curso.profesor.usuario.persona.apellidos}"></c:out></td>
								<td><input type="checkbox" name="materiaAInscribir" value="${curso.idCurso}"></td>
							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th><input type="submit" value="Inscribir materias"></th>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>