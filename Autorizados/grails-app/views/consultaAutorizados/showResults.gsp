<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Consulta de autorizados</title>
</head>
<body>
  <div class="body">
  	<fieldset>
  		<legend><strong>Resultados de la búsqueda</strong></legend>
  		<table>
  			<tr>
  				<th>Nombre</th>
  				<th>A. Paterno</th>
  				<th>A. Materno</th>
  				<th>Estatus</th>
  				<th>Autorización</th>
  				<th>Vigencia</th>
  				<th>Institución</th>
  			</tr>
  			
  			<g:each status="i" in="${consultaAutorizadosInstanceList}" var="item" >
	  			<tr>
	  				<td>${item.nbNombre?.encodeAsHTML()}</td>
	  				<td>${item.nbApaterno?.encodeAsHTML()}</td>
	  				<td>${item.nbAmaterno?.encodeAsHTML()}</td>
	  				<td>${item.dsSituacionaut?.encodeAsHTML()}</td>
	  				<td>${item.dsTpautorizacion?.encodeAsHTML()}</td>
	  				<td>${item.fhIniciovigencia?.encodeAsHTML()} - ${item.fhFinvigencia?.encodeAsHTML()}</td>
	  				<td>${item.nbInstitucion?.encodeAsHTML()}</td>
	  			</tr>
  			</g:each>
  		</table>
  	</fieldset>
  </div>
</body>
</html>