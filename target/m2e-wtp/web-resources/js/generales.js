function loadContentById(selector,direccion) {
	var request = new XMLHttpRequest();
	request.open('GET', direccion, true);
	request.onload = function() {
	  if (request.status >= 200 && request.status < 400) {
	    var resp = request.responseText;

	    document.querySelector(selector).innerHTML = resp;
	  }
	};
	request.send();
}
function id(tag) {
	return document.getElementById(tag);
}
function className(name) {
	return document.getElementsByClassName(name);
}
function elementsName(name) {
	return document.getElementsByName(name);
}
function selecciona(nameItem) {
	var item = id(nameItem);
	if (item.checked)
		item.checked = false;
	else
		item.checked = true;
}
function enableItem(item) {
	var elem = id(item);
	elem.disabled = false;
}
function desableItem(item) {
	var elem = id(item);
	elem.disabled = true;
}
function activeItem(item,estado) {
	if (estado)
		enableItem(item);
	else
		desableItem(item);
}
function styleDisplayItem(item,estado) {
	var elem = id(item);
	if (estado)
		elem.style.display = 'block';
	else
		elem.style.display = 'none';
}
function switchEstado(item) {
	var elem = id(item);
	var estado = elem.style.display;
	if (estado == 'block')
		styleDisplayItem(item,false);
	else
		styleDisplayItem(item,true);
}
function asignaImg(idImg,imagen){
    var img = id(idImg);
    img.src = "data:image/jpeg;base64," + imagen;
}
function crearOption(select,value,text) {
	var x = id(select);
	var option = document.createElement("option");
	option.value = value;
	option.text = text;
	x.add(option);
}
function duplicaElemento(item,contenedor) {
	var x = id(item);
	var nuevo = x.cloneNode(true);
	destino = id(contenedor);
	destino.appendChild(nuevo);
}
function borrarCombo(combo,numItems) {
	var x = id(combo);
	for (n = 0; n <= numItems; n++) {
		x.remove(x[n]);
	}
}
function hash(itemGet) {
	var clave = id(itemGet).value;
	var hash = 0;
	
    for (i = 0; i < clave.length; i++) {
        chr = clave.charCodeAt(i);
        hash = ((hash << 5) - hash) + chr;
        hash = hash & hash; // Convierte a un entero de 32bit 
    }
    return hash;
}
function codificarClave(clavePlano,claveLog) {
	id(claveLog).value = hash(clavePlano);
}
function cambiaFoto(inputFile,img) {
	var files = id(inputFile).files;
	var f = files[0];
	var leerArchivo = new FileReader();
	leerArchivo.onload = (function(elArchivo) {
		return function(e) {
			id(img).src = e.target.result;
		};
	})(f);
	leerArchivo.readAsDataURL(f);
}
function checarCheckbox(elementName) {
	var checkbox = elementsName(elementName);
	var flag = true;
	for (var i = 0; i < checkbox.length; i++) {
		if (checkbox[i].checked) {
			flag = false;
			break;
		}
	}
	for (var i = 0; i < checkbox.length; i++) {
		checkbox[i].required = flag;
	}
}
function ifCheckedThenById(groupName,colectionElementsId) {
	var group = elementsName(groupName);
	var flag = false;
	for (var i = 0; i < group.length; i++) {
		if (group[i].checked) {
			flag = true;
			break;
		}
	}
	for ( var element in colectionElements) {
		object = id(element);
		object.required = flag;
	}
}
function styleValidateInput(item,estado) {
	var elem = id(item);
	switch(estado){
		case 1:
			elem.style.borderColor = '#DDDDDD';
			elem.style.borderWidth = '1px';
			break;
		case 2:
			elem.style.borderColor = 'red';
			elem.style.borderWidth = '3px';
			break;
		case 3:
			elem.style.borderColor = 'green';
			elem.style.borderWidth = '3px';
			break;
	}
}
function validaClavesIguales(item1,item2,itemSubmit) {
	var campo1,campo2,campo1Valor,campo2Valor;
	campo1 = id(item1);
	campo2 = id(item2);
	campo1Valor = campo1.value;
	campo2Valor = campo2.value;
	if (campo1Valor.length == campo2Valor.length) {
		if (campo1Valor == campo2Valor) {
			styleValidateInput(item1,3);
			styleValidateInput(item2,3);
		}
		else{
			styleValidateInput(item1,2);
			styleValidateInput(item2,2);
			ActiveItem(itemSubmit,false);
		}
	}
	else{
		styleValidateInput(item1,1);
		styleValidateInput(item2,1);
		ActiveItem(itemSubmit,true);
	}
}
function openMateria(evt, materia) {
    // Declare all variables
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = className("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = className("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the button that opened the tab
    id(materia).style.display = "block";
    evt.currentTarget.className += " active";
}
function replacePrameter(form,character,replace) {
	var formulario = id(form);
	formulario.action = formulario.action.replace(character,replace);
}