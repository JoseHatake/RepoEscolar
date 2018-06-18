<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="css/headStyle.css">
<div id="contenedorHeader">
	<a href="index.jsp">
		<div class="logo-intitu izquierda">
			<img alt="IPN" src="img/ipn.png" class="imgAll centrar">
		</div>
	</a>
	<div id="nombreInstitu" class="centrar">
		<h1>INSTITUTO POLITÉCNICO NACIONAL</h1>
		<h2>${escuela.nombre}</h2>
	</div>
	<div class="logo-intitu derecha">
		<img alt="${escuela.nombre}" src="data:image/jpeg;base64,${escuela.escudo}" class="imgAll centrar">
	</div>
</div>