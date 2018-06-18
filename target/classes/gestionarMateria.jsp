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
		<div>
			<c:forEach items="${academia.materias}" var="materia">
				<button class="tablinks" onclick="openMateria(event, ${materia.idMaterias})"><c:out value="${materia.nombre}"></c:out></button>
			</c:forEach>
		</div>
		<c:forEach items="${academia.materias}" var="materia">
			<div id="${materia.idMaterias}" class="tabcontent">
				<h1><c:out value="${materia.nombre}"></c:out></h1>
				<form action="Acciones?accion=10&direccion=gestionarMateria.jsp&materia=${materia.idMaterias}" method="POST">
					<table>
						<thead>
							<tr>
								<th>Nombre profesor</th>
								<th>Grupo</th>
								<th>Seleccionar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${materia.cursos}" var="curso">
								<tr>
									<td><c:out value="${curso.profesor.usuario.persona.nombres} ${curso.profesor.usuario.persona.apellidos}"></c:out></td>
									<td><c:out value="${curso.grupo.grupo}"></c:out></td>
									<td><input type="checkbox" name="borrarProfesorDeMateria" value="${curso.profesor.idProfesor}" onchange="checarCheckbox('borrarProfesorDeMateria')"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<input type="submit" value="Borrar profesor">
				</form>
				<form action="Acciones?accion=11&direccion=gestionarMateria.jsp&materia=${materia.idMaterias}" method="POST">
					<h1>Agregar profesores</h1>
					<div id="profesoresARegistrar">
						<div id="selectProfesorGrupo">
							<select name="listaProfesores" required>
								<option value="">Selecciona un profesor</option>
								<c:forEach items="${profesores}" var="profesor">
									<option value="${profesor.idProfesor}"><c:out value="${profesor.usuario.persona.nombres} ${profesor.usuario.persona.apellidos}"></c:out></option>
								</c:forEach>
							</select>
							<select name="listaGrupos" required>
								<option value="">Selecciona un grupo</option>
								<c:forEach items="${todosLosGrupos}" var="grupo">
									<option value="${grupo.idGrupo}"><c:out value="${grupo.grupo}"></c:out></option>
								</c:forEach>
							</select>
						</div>
					</div>
					<table>
						<tbody>
							<tr>
								<td><input type="button" value="Otro profesor" onclick="duplicaElemento('selectProfesorGrupo','profesoresARegistrar')"></td>
								<td><input type="submit" value="Registrar profesores"></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</c:forEach>
	</div>
</body>
</html>