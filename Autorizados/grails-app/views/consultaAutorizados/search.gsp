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
		<g:select id="selInstitucion" name="search.institucion.id" from="${mx.amib.sistemas.autorizados.sumario.catalogo.Institucion.findAllByStVigente(true)}" 
						optionKey="id" optionValue="nbInstitucion" noSelection="['':'Sin especificar']" />
		<br/>
		Situación:&nbsp;
		<!-- <g:select id="selSituacion" name="search.situacionAutorizacion.id" from="${mx.amib.sistemas.autorizados.sumario.catalogo.SituacionAutorizacion.list()}" 
						optionKey="id" optionValue="dsSituacionaut" noSelection="['':'-Seleccione-']" /> -->
		<g:select id="selSituacion" name="search.situacionAutorizacion" from="${mx.amib.sistemas.autorizados.sumario.catalogo.SituacionAutorizacionAltEnum.list()}" 
						optionKey="id" optionValue="name" />
		<br/>
		
		Próximos vencimientos de autorización:&nbsp;
		<g:select id="selPVencimiento" name="search.pvencimiento" from="${mx.amib.sistemas.autorizados.sumario.PeriodoVencimientoEnum.list()}" 
						optionKey="id" optionValue="name"/>
		
		<fieldset>
			<legend>Autorización</legend>
			<div id="divOpcionesAutorizacion">
				<g:each var="tpaut" in="${mx.amib.sistemas.autorizados.sumario.catalogo.TipoAutorizacion.list()}">
					<g:if test="${tpaut.stVigente == true}">
				    	<input type="checkbox" name="search.tipoAutorizacion" value="${tpaut.id}"/>${tpaut.dsTpautorizacion}<br/>
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