document.onreadystatechange = function() {
	if (id('head-logo'))
		loadContentById('#head-logo','templates/head.jsp');
	if (id('menu-navegacion'))
		loadContentById('#menu-navegacion','templates/menuNavegacion.jsp');
	if (id('menu-perfil-1'))
		loadContentById('#menu-perfil-1','templates/menuPerfilAlumno.jsp');
	if (id('menu-perfil-2'))
		loadContentById('#menu-perfil-2','templates/menuPerfilMaestro.jsp');
}