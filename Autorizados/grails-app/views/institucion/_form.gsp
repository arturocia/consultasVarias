<%@ page import="mx.amib.sistemas.autorizados.sumario.catalogo.Institucion" %>



<div class="fieldcontain ${hasErrors(bean: institucionInstance, field: 'nbInstitucion', 'error')} ">
	<label for="nbInstitucion">
		<g:message code="institucion.nbInstitucion.label" default="Nb Institucion" />
		
	</label>
	<g:textArea name="nbInstitucion" cols="40" rows="5" maxlength="1000" value="${institucionInstance?.nbInstitucion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: institucionInstance, field: 'stVigente', 'error')} ">
	<label for="stVigente">
		<g:message code="institucion.stVigente.label" default="St Vigente" />
		
	</label>
	<g:checkBox name="stVigente" value="${institucionInstance?.stVigente}" />
</div>

