<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
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

.result {
	font-style: italic;
}

.content fieldset{
	border-color: #CCC;
	border-style: solid;
	border-width: 1px;
}

.content .label{
	font-size: small;
}
.content .labelResult{
	font-size: small;
	font-weight: bold; 
	text-align: left; 
}
.content .result{
	font-size: small;
}

</style>
</head>
<body>
  <div class="content">
  
  <g:form name="search" action="showResults" >
	
	<fieldset>
	<legend><strong>Parámetros de búsqueda</strong></legend>
		Matrícula:&nbsp;<input type="text" name="search.matricula" />&nbsp;&nbsp;Folio:&nbsp;<input type="text" name="search.folio"/><br/>
		Nombre:&nbsp;<input type="text" name="search.nombre"/>&nbsp;&nbsp;A. Paterno:&nbsp;<input type="text" name="search.apaterno"/>&nbsp;&nbsp;A. Materno:&nbsp;<input type="text" name="search.amaterno" /><br/>
		Institución:&nbsp;
		<g:select id="selInstitucion" name="search.institucion.id" from="${mx.amib.sistemas.autorizados.sumario.catalogo.Institucion.list()}" 
						optionKey="id" optionValue="nbInstitucion" noSelection="['':'-Seleccione-']" />
		<br/>
		Situación:&nbsp;
		<g:select id="selSituacion" name="search.situacionAutorizacion.id" from="${mx.amib.sistemas.autorizados.sumario.catalogo.SituacionAutorizacion.list()}" 
						optionKey="id" optionValue="dsSituacionaut" noSelection="['':'-Seleccione-']" />
		<br/>
		
		Próximos vencimientos de autorización:&nbsp;
		<select id="selPVencimiento" name="search.pvencimiento">
			<option value="0">-Seleccione-</option>
			<option value="1">1 mes</option>
			<option value="2">3 meses</option>
			<option value="3">6 meses</option>
			<option value="4">9 meses</option>
			<option value="5">12 meses</option>
		</select><br/>
		
		<fieldset>
			<legend>Autorización</legend>
			<div id="divOpcionesAutorizacion">
				<g:each var="tpaut" in="${mx.amib.sistemas.autorizados.sumario.catalogo.TipoAutorizacion.list()}">
					<g:if test="${tpaut.stVigente == true}">
				    	<input type="checkbox" name="search.tipoAutorizacionId" value="${tpaut.id}"/>${tpaut.dsTpautorizacion}<br/>
				    </g:if>
				</g:each>
				
			</div>
		</fieldset>
		
		<!-- <input id="btnBusca" type="button" value="Buscar autorizados" />  -->
		
		<g:submitButton name="search" value="Buscar autorizados" />
		
	</fieldset>
	
  </g:form>
  
  </div>
</body>
</html>