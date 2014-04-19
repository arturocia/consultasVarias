<%@ page import="mx.amib.sistemas.autorizados.sumario.catalogo.Figura" %>



<div class="fieldcontain ${hasErrors(bean: figuraInstance, field: 'dsFigura', 'error')} ">
	<label for="dsFigura">
		<g:message code="figura.dsFigura.label" default="Ds Figura" />
		
	</label>
	<g:textArea name="dsFigura" cols="40" rows="5" maxlength="1000" value="${figuraInstance?.dsFigura}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: figuraInstance, field: 'stVigente', 'error')} ">
	<label for="stVigente">
		<g:message code="figura.stVigente.label" default="St Vigente" />
		
	</label>
	<g:checkBox name="stVigente" value="${figuraInstance?.stVigente}" />
</div>

