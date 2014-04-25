<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout"/>
<title>Consulta de autorizados</title>
<style>

body {
	font-family: Arial, Helvetica, sans-serif; 
	font-size: small;
}

.content {
	position: relative;
	max-width: 940px;
	background-color: #FFFFFF;
	margin: auto;
}

.results {
	font-size: small;
}

.result {
	font-style: italic;
}

.content fieldset{
	border-color: #CCC;
	border-style: solid;
	border-width: 1px;
}

.content .label{
}
.content .labelResult{
	font-weight: bold; 
	text-align: left; 
}
.content .result{
}

.prevLink {
	font-weight: bold; 
	padding-left: 3px;
	padding-right: 6px;
}
.step {
	font-weight: bold; 
	padding-left: 4px;
	padding-right: 4px;
}
.nextLink {
	font-weight: bold; 
	padding-left: 6px;
	padding-right: 3px;
}

</style>
</head>
<body>
  <div class="content">
  	<fieldset>
  		<legend><strong>Resultados de la búsqueda</strong></legend>
  		
  		<g:paginate next="Siguente" prev="Atras" controller="consultaAutorizados"
            action="showResults" max="${resultsToDisplay}" total="${consultaAutorizadosInstanceListTotal}" params="${params}"/><br/>
  		
  		<table class="results">
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
	  			<tr>
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