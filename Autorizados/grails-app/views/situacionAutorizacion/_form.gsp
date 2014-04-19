<%@ page import="mx.amib.sistemas.autorizados.sumario.catalogo.SituacionAutorizacion" %>



<div class="fieldcontain ${hasErrors(bean: situacionAutorizacionInstance, field: 'dsSituacionaut', 'error')} ">
	<label for="dsSituacionaut">
		<g:message code="situacionAutorizacion.dsSituacionaut.label" default="Ds Situacionaut" />
		
	</label>
	<g:textArea name="dsSituacionaut" cols="40" rows="5" maxlength="1000" value="${situacionAutorizacionInstance?.dsSituacionaut}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: situacionAutorizacionInstance, field: 'stVigente', 'error')} ">
	<label for="stVigente">
		<g:message code="situacionAutorizacion.stVigente.label" default="St Vigente" />
		
	</label>
	<g:checkBox name="stVigente" value="${situacionAutorizacionInstance?.stVigente}" />
</div>

