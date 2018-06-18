<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="css/menuNav.css">
<ul id="menu-top-nav">
	<a href="inicioRepoEscolar.jsp">
		<li><div>Inicio</div></li>
	</a>
	<a href="http://www.ipn.mx/SiteCollectionDocuments/Calendario-IPN/Recalendarizacion_todas-las-UA.pdf" target="_blanck">
		<li><div>Calendario escolar</div></li>
	</a>
	<a href="Acciones?accion=6&direccion=academiasMaterias.jsp">
		<li><div>Academias y materias</div></li>
	</a>
	<a href="http://www.ipn.mx/Paginas/inicio.aspx" target="_blanck">
		<li><div>Sitio oficial IPN</div></li>
	</a>
	<a href="${escuela.sitioWeb}" target="_blanck">
		<li><div>Sitio oficial escuela</div></li>
	</a>
	<li onmouseover="switchEstado('menu-perfil-${perfil.rol}');">	
		<c:choose>
			<c:when test="${perfil.avatar != null}">
				<img alt="avatar" src="data:image/jpeg;base64,${perfil.avatar}">
			</c:when>
			<c:otherwise>
				<img alt="avatarDefault" src="img/avatarDefault.png">
			</c:otherwise>
		</c:choose>
		<div>${perfil.nombre}</div>
	</li>
</ul>