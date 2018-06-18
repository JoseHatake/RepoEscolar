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
			<h3>Materias registradas de la academia: <c:out value="${academia.nombre}"></c:out></h3>
			<form action="Acciones?accion=29&direccion=agregarMaterias.jsp" method="POST" style="width: 80%;" class="centrar">
				<table>
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Seleccion</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${materias}" var="materia">
							<tr>
								<td><c:out value="${materia.nombre}"></c:out></td>
								<td><input type="checkbox" value="${materia.idMaterias}" name="materiaAEliminar" class="centrar"></td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<th colspan="2"><input type="submit" value="Eliminar materia" class="centrar botonConfirm"></th>
						</tr>
					</tfoot>
				</table>
			</form>
			<h3>Agregar materias</h3>
			<form action="Acciones?accion=30&direccion=agregarMaterias.jsp&academia=${academia.idAcademias}" method="POST" style="width: 80%;" class="centrar">
				<div id="contieneMaterias">
					<div id="materia">
						<input type="text" maxlength="45" minlength="5" placeholder="Nombre de materia" name="materiaNueva" required>
						<input type="number" maxlength="2" placeholder="Nivel de la materia" name="nivelMateria" required>
					</div>
				</div>
				<input type="button" value="Agregar otra materia" onclick="duplicaElemento('materia','contieneMaterias')" class="centrar botonConfirm">
				<input type="submit" id="registro" value="Generar registros" class="centrar botonConfirm">
			</form>
		</div>
	</div>
</body>
</html>