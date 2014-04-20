<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout"/>
<title>Consulta de autorizados</title>
</head>
<body>
  <div class="body">
  
  <form>
	
	<fieldset>
	<legend><strong>Parámetros de búsqueda</strong></legend>
		Matrícula:&nbsp;<input type="text" />&nbsp;&nbsp;Folio:&nbsp;<input type="text" /><br/>
		Nombre:&nbsp;<input type="text" />&nbsp;&nbsp;A. Paterno:&nbsp;<input type="text" />&nbsp;&nbsp;A. Materno:&nbsp;<input type="text" /><br/>
		Institución:&nbsp;
		<g:select id="selInstitucion" name="search.institucion.id" from="${mx.amib.sistemas.autorizados.sumario.catalogo.Institucion.list()}" 
						optionKey="id" optionValue="nbInstitucion" noSelection="['':'-Seleccione-']" />
		<br/>
		Situación:&nbsp;
		<g:select id="selSituacion" name="search.situacionAutorizacion.id" from="${mx.amib.sistemas.autorizados.sumario.catalogo.SituacionAutorizacion.list()}" 
						optionKey="id" optionValue="dsSituacionaut" noSelection="['':'-Seleccione-']" />
		<br/>
		
		Próximos vencimientos de autorización:&nbsp;
		<select>
			<option value="0">-Seleccione-</option>
			<option value="1">1 mes</option>
			<option value="2">3 meses</option>
			<option value="3">6 meses</option>
			<option value="4">9 meses</option>
			<option value="5">12 meses</option>
		</select><br/>
		
		Autorización:
		<div id="divOpcionesAutorizacion">
			<g:each var="tpaut" in="${mx.amib.sistemas.autorizados.sumario.catalogo.TipoAutorizacion.list()}">
				<g:if test="${tpaut.stVigente == true}">
			    	<input type="checkbox" name="search.tipoAutorizacion.0" value="${tpaut.id}"/>${tpaut.dsTpautorizacion}<br/>
			    </g:if>
			</g:each>
			
		</div>
		
		<input type="button" value="Buscar autorizados" />
	</fieldset>
	
  </form>
  
  </div>
</body>
</html>