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
			<c:forEach items="${academias}" var="academia">
				<button class="tablinks" onclick="openMateria(event, ${academia.idAcademias})"><c:out value="${academia.nombre}"></c:out></button>
			</c:forEach>
		</div>
		<c:forEach items="${academias}" var="academia">
			<div id="${academia.idAcademias}" class="tabcontent">
				<h1><c:out value="${academia.nombre}"></c:out></h1>
				<h3>Jefe de Academia: <c:out value="${academia.jefeAcademia.usuario.persona.nombres} ${academia.jefeAcademia.usuario.persona.apellidos}"></c:out></h3>
				<form action="Acciones?accion=26&direccion=ligarJefeAcademia.jsp&academia=${academia.idAcademias}" method="POST">
					<h4>Cambiar jefe de academia</h4>
					<select name="nuevoJefeAcademia" required>
						<option value="">Selecciona profesor</option>
						<c:forEach items="${profesores}" var="profesor">
							<option value="${profesor.idProfesor}"><c:out value="${profesor.usuario.persona.nombres} ${profesor.usuario.persona.apellidos}"></c:out></option>
						</c:forEach>
					</select>
					<input type="submit" value="Cambiar jefe de academia"  class="centrar botonConfirm">
				</form>
			</div>
		</c:forEach>
	</div>
</body>
</html>