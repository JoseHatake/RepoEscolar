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
	<div id="contenidoEscuelas" class="centrar">
		<h1 id="nombreApp">RepoEscolar</h1>
		<div id="containerEscuelas">
			<c:forEach items="${escuelas}" var="escuela">
				<a href="Acciones?accion=2&direccion=inicioSesion.jsp&escuela=${escuela.id}">
					<div class="distribucion">
						<div class="escuela centrar">
							<img alt="${escuela.nombre}" src="data:image/jpeg;base64,${escuela.escudo}">
							<hr>
							<p>${escuela.nombre}</p>
						</div>
					</div>
				</a>
			</c:forEach>
		</div>
	</div>
	<footer id="footer">
		<!-- Aquí se carga el footer -->
	</footer>
</body>
</html>