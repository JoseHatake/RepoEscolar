<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="css/headStyle.css">
<div id="contenedorHeader">
	<a href="index.jsp">
		<img alt="IPN" src="img/ipn.png" class="logo-intitu izquierda">
	</a>
	<div id="nombreInstitu">
		<h1>INSTITUTO POLITÉCNICO NACIONAL</h1>
		<h2>${escuela.nombre}</h2>
	</div>
	<img alt="${escuela.nombre}" src="data:image/jpeg;base64,${escuela.escudo}" class="logo-intitu derecha">
</div>