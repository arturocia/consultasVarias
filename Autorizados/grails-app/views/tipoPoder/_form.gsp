<%@ page import="mx.amib.sistemas.autorizados.sumario.catalogo.TipoPoder" %>



<div class="fieldcontain ${hasErrors(bean: tipoPoderInstance, field: 'dsTppoder', 'error')} ">
	<label for="dsTppoder">
		<g:message code="tipoPoder.dsTppoder.label" default="Ds Tppoder" />
		
	</label>
	<g:textArea name="dsTppoder" cols="40" rows="5" maxlength="254" value="${tipoPoderInstance?.dsTppoder}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tipoPoderInstance, field: 'stVigente', 'error')} ">
	<label for="stVigente">
		<g:message code="tipoPoder.stVigente.label" default="St Vigente" />
		
	</label>
	<g:checkBox name="stVigente" value="${tipoPoderInstance?.stVigente}" />
</div>

