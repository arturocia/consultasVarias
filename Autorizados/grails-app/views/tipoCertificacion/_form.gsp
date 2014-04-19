<%@ page import="mx.amib.sistemas.autorizados.sumario.catalogo.TipoCertificacion" %>



<div class="fieldcontain ${hasErrors(bean: tipoCertificacionInstance, field: 'dsTpcertificacion', 'error')} ">
	<label for="dsTpcertificacion">
		<g:message code="tipoCertificacion.dsTpcertificacion.label" default="Ds Tpcertificacion" />
		
	</label>
	<g:textArea name="dsTpcertificacion" cols="40" rows="5" maxlength="1000" value="${tipoCertificacionInstance?.dsTpcertificacion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tipoCertificacionInstance, field: 'stVigente', 'error')} ">
	<label for="stVigente">
		<g:message code="tipoCertificacion.stVigente.label" default="St Vigente" />
		
	</label>
	<g:checkBox name="stVigente" value="${tipoCertificacionInstance?.stVigente}" />
</div>

