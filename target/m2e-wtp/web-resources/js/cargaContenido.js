document.onreadystatechange = function() {
	if (id('head-logo'))
		loadContentById('#head-logo','templates/head.jsp');
	if (id('menu-navegacion'))
		loadContentById('#menu-navegacion','templates/menuNavegacion.jsp');
	if (id('menu-perfil-1'))
		loadContentById('#menu-perfil-1','templates/menuPerfilAlumno.jsp');
	if (id('menu-perfil-2'))
		loadContentById('#menu-perfil-2','templates/menuPerfilProfesor.jsp');
	if (id('menu-perfil-3'))
		loadContentById('#menu-perfil-3','templates/menuPerfilAdministracion.jsp');
	if (id('menu-perfil-4'))
		loadContentById('#menu-perfil-4','templates/menuPerfilAdministrativo.jsp');
	if (id('menu-perfil-5'))
		loadContentById('#menu-perfil-5','templates/menuPerfilJefeAcademia.jsp');
	if (id('footer'))
		loadContentById('#footer','templates/footer.jsp');
}