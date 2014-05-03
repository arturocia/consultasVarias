<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout"/>
<title>Consulta de autorizados</title>
<link rel="stylesheet" type="text/css" href="<g:resource dir="css" file="autorizados.css" />" />
<script>

function trResult_click(idSust){
	document.location.href = '<g:createLink controller="consultaAutorizados" action="show" />/' + idSust;
}

</script>
</head>
<body>
  <div class="content">
  	<fieldset>
  		<legend><strong>Resultados de la búsqueda</strong></legend>
  		
  		<g:paginate next="Siguente" prev="Atras" controller="consultaAutorizados"
            action="showResults" max="${resultsToDisplay}" total="${consultaAutorizadosInstanceListTotal}" params="${params}"/><br/>
  		
  		<table class="results" cellspacing="0" >
  			<tr>
  				<th>Nombre</th>
  				<th>A. Paterno</th>
  				<th>A. Materno</th>
  				<th width="10%">Estatus</th>
  				<th width="30%">Autorización</th>
  				<th>Vigencia</th>
  				<th width="10%">Institución</th>
  			</tr>
  			
  			<g:each status="i" in="${consultaAutorizadosInstanceList}" var="item" >
	  			<tr class="resultRow" onclick="trResult_click(${item.nuMatricula})">
	  				<td>${item.nbNombre?.encodeAsHTML()}</td>
	  				<td>${item.nbApaterno?.encodeAsHTML()}</td>
	  				<td>${item.nbAmaterno?.encodeAsHTML()}</td>
	  				<td>${item.dsSituacionaut?.encodeAsHTML()}</td>
	  				<td>${item.dsTpautorizacion?.encodeAsHTML()}</td>
	  				<td><g:formatDate format="dd-MM-yyyy" date="${item.fhIniciovigencia}"/><br/><g:formatDate format="dd-MM-yyyy" date="${item.fhFinvigencia}"/></td>
	  				<td>${item.nbInstitucion?.encodeAsHTML()}</td>
	  			</tr>
  			</g:each>
  			
  		</table><br/>
  		
  		<g:paginate next="Siguente" prev="Atras" controller="consultaAutorizados"
            action="showResults" max="${resultsToDisplay}" total="${consultaAutorizadosInstanceListTotal}" params="${params}"/>
  	</fieldset>
  </div>
</body>
</html>