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
		<h3>Grupos registrados</h3>
		<form action="Acciones?accion=20&direccion=gestionarGrupos.jsp" method="POST">
			<table>
				<thead>
					<tr>
						<th>Grupo</th>
						<th>Seleccion</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todosLosGrupos}" var="grupo">
						<tr>
							<td><c:out value="${grupo.grupo}"></c:out></td>
							<td><input type="checkbox" value="${grupo.idGrupo}" name="gruposAEliminar"></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th><input type="submit" value="Eliminar grupos"></th>
					</tr>
				</tfoot>
			</table>
		</form>
		<h3>Registrar grupos</h3>
		<form action="Acciones?accion=19&direccion=gestionarGrupos.jsp" method="POST">
			<div id="crearGrupos">
				<div id="grupoNuevo">
					<input type="number" max="5" name="niveles" placeholder="Nivel del grupo" required>
					<select name="turno" required>
						<option value="">Selecciona turno</option>
						<option value="M">Matutino</option>
						<option value="V">Vespertino</option>
					</select>
					<input type="number" max="20" name="numeroGrupo" placeholder="Numero de grupos" required>
				</div>
			</div>
			<input type="button" value="Otro nivel" class="centrar botonConfirm" onclick="duplicaElemento('grupoNuevo','crearGrupos')">
			<input type="submit" value="Registrar" class="centrar botonConfirm">
		</form>
	</div>
</body>
</html>