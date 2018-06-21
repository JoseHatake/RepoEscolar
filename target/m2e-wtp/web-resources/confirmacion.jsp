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
	</header>
	<div class="contenido centrar">
		<div class="contenedorCentral centrar">
			<c:choose>
				<c:when test="${mensaje == 1}">
					<h1>Cuenta nueva creada con éxito!</h1>
					<p>Nick de la cuenta: <c:out value="${nick}"></c:out></p>
					<p>Nombre del propietario: <c:out value="${nombre}"></c:out></p>
				</c:when>
				<c:when test="${mensaje == 2}">
					<h1>Esa cuenta ya EXISTE!</h1>
					<p>El número de cuenta que proporcionaste no ha sido registrado o ya ha sido asignado a alguien más, intenta con otro.</p>
				</c:when>
				<c:when test="${mensaje == 6}">
					<h1>El número de acceso (Boleta) no ha sido registrado!</h1>
					<p>El número de boleta que has proporcionado no ha sido registrado, consulta con tu administrador escolar para más información.</p>
				</c:when>
				<c:when test="${mensaje == 3}">
					<h1>Nueva escuela creada con éxito!</h1>
					<p>Nombre: <c:out value="${escuela.nombre}"></c:out></p>
					<p>Dirección: <c:out value="${escuela.direccion}"></c:out></p>
					<p>Teléfono: <c:out value="${escuela.telefono}"></c:out></p>
					<p>Extensión: <c:out value="${escuela.extension}"></c:out></p>
					<p>Sitio web: <a href="${escuela.sitioWeb}"><c:out value="${escuela.sitioWeb}"></c:out></a></p>
					<p>Clave Administrativo: <c:out value="${claveAdmin}"></c:out></p>
					<p>Clave Profesor: <c:out value="${claveProfesor}"></c:out></p>
				</c:when>
				<c:when test="${mensaje == 4}">
					<h1>No se pudo crear la escuela!</h1>
					<p>Ocurrió un problema al crear la escuela.</p>
				</c:when>
				<c:when test="${mensaje == 5}">
					<h1>Se generaron todas las boletas!</h1>
					<p>Las boletas generadas son</p>
					<select>
						<option>Boletas genradas</option>
						<c:forEach begin="${boletaInicial}" end="${boletaFinal}" var="boleta">
							<option><c:out value="${boleta}"></c:out></option>
						</c:forEach>
					</select>
					<a href="inicioRepoEscolar.jsp" class="resaltarLink">Ir a inicio</a>
				</c:when>
			</c:choose>
			<br><br>
			<c:choose>
				<c:when test="${mensaje == 1 || mensaje == 2 || mensaje == 6}">
					<a href="inicioSesion.jsp" class="resaltarLink">Iniciar sesión</a>
					<a href="nuevaCuenta.jsp" class="resaltarLink">Nueva cuenta</a>
				</c:when>
				<c:when test="${mensaje == 3 || mensaje == 4}">
					<a href="inicioRepoEscolar.jsp" class="resaltarLink">Ir a inicio</a>
					<a href="agregarEscuela.jsp" class="resaltarLink">Nueva escuela</a>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>