<%@ page import="mx.amib.sistemas.autorizados.sumario.catalogo.TipoAutorizacion" %>



<div class="fieldcontain ${hasErrors(bean: tipoAutorizacionInstance, field: 'dsTpautorizacion', 'error')} ">
	<label for="dsTpautorizacion">
		<g:message code="tipoAutorizacion.dsTpautorizacion.label" default="Ds Tpautorizacion" />
		
	</label>
	<g:textArea name="dsTpautorizacion" cols="40" rows="5" maxlength="1000" value="${tipoAutorizacionInstance?.dsTpautorizacion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tipoAutorizacionInstance, field: 'stVigente', 'error')} ">
	<label for="stVigente">
		<g:message code="tipoAutorizacion.stVigente.label" default="St Vigente" />
		
	</label>
	<g:checkBox name="stVigente" value="${tipoAutorizacionInstance?.stVigente}" />
</div>

