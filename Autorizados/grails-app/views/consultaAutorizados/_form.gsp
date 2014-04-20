<%@ page import="mx.amib.sistemas.autorizados.sumario.ConsultaAutorizados" %>



<div class="fieldcontain ${hasErrors(bean: consultaAutorizadosInstance, field: 'nuMatricula', 'error')} ">
	<label for="nuMatricula">
		<g:message code="consultaAutorizados.nuMatricula.label" default="Nu Matricula" />
		
	</label>
	<g:field name="nuMatricula" type="number" value="${consultaAutorizadosInstance.nuMatricula}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: consultaAutorizadosInstance, field: 'nuFolio', 'error')} ">
	<label for="nuFolio">
		<g:message code="consultaAutorizados.nuFolio.label" default="Nu Folio" />
		
	</label>
	<g:field name="nuFolio" type="number" value="${consultaAutorizadosInstance.nuFolio}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: consultaAutorizadosInstance, field: 'nbNombre', 'error')} ">
	<label for="nbNombre">
		<g:message code="consultaAutorizados.nbNombre.label" default="Nb Nombre" />
		
	</label>
	<g:textField name="nbNombre" maxlength="100" value="${consultaAutorizadosInstance?.nbNombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: consultaAutorizadosInstance, field: 'nbApaterno', 'error')} ">
	<label for="nbApaterno">
		<g:message code="consultaAutorizados.nbApaterno.label" default="Nb Apaterno" />
		
	</label>
	<g:textField name="nbApaterno" maxlength="100" value="${consultaAutorizadosInstance?.nbApaterno}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: consultaAutorizadosInstance, field: 'nbAmaterno', 'error')} ">
	<label for="nbAmaterno">
		<g:message code="consultaAutorizados.nbAmaterno.label" default="Nb Amaterno" />
		
	</label>
	<g:textField name="nbAmaterno" maxlength="100" value="${consultaAutorizadosInstance?.nbAmaterno}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: consultaAutorizadosInstance, field: 'idSituacionaut', 'error')} ">
	<label for="idSituacionaut">
		<g:message code="consultaAutorizados.idSituacionaut.label" default="Id Situacionaut" />
		
	</label>
	<g:field name="idSituacionaut" type="number" value="${consultaAutorizadosInstance.idSituacionaut}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: consultaAutorizadosInstance, field: 'dsSituacionaut', 'error')} ">
	<label for="dsSituacionaut">
		<g:message code="consultaAutorizados.dsSituacionaut.label" default="Ds Situacionaut" />
		
	</label>
	<g:textField name="dsSituacionaut" value="${consultaAutorizadosInstance?.dsSituacionaut}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: consultaAutorizadosInstance, field: 'idTpautorizacion', 'error')} ">
	<label for="idTpautorizacion">
		<g:message code="consultaAutorizados.idTpautorizacion.label" default="Id Tpautorizacion" />
		
	</label>
	<g:field name="idTpautorizacion" type="number" value="${consultaAutorizadosInstance.idTpautorizacion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: consultaAutorizadosInstance, field: 'dsTpautorizacion', 'error')} ">
	<label for="dsTpautorizacion">
		<g:message code="consultaAutorizados.dsTpautorizacion.label" default="Ds Tpautorizacion" />
		
	</label>
	<g:textArea name="dsTpautorizacion" cols="40" rows="5" maxlength="1000" value="${consultaAutorizadosInstance?.dsTpautorizacion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: consultaAutorizadosInstance, field: 'idInstitucion', 'error')} ">
	<label for="idInstitucion">
		<g:message code="consultaAutorizados.idInstitucion.label" default="Id Institucion" />
		
	</label>
	<g:field name="idInstitucion" type="number" value="${consultaAutorizadosInstance.idInstitucion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: consultaAutorizadosInstance, field: 'nbInstitucion', 'error')} ">
	<label for="nbInstitucion">
		<g:message code="consultaAutorizados.nbInstitucion.label" default="Nb Institucion" />
		
	</label>
	<g:textArea name="nbInstitucion" cols="40" rows="5" maxlength="1000" value="${consultaAutorizadosInstance?.nbInstitucion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: consultaAutorizadosInstance, field: 'fhIniciovigencia', 'error')} ">
	<label for="fhIniciovigencia">
		<g:message code="consultaAutorizados.fhIniciovigencia.label" default="Fh Iniciovigencia" />
		
	</label>
	<g:datePicker name="fhIniciovigencia" precision="day"  value="${consultaAutorizadosInstance?.fhIniciovigencia}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: consultaAutorizadosInstance, field: 'fhFinvigencia', 'error')} ">
	<label for="fhFinvigencia">
		<g:message code="consultaAutorizados.fhFinvigencia.label" default="Fh Finvigencia" />
		
	</label>
	<g:datePicker name="fhFinvigencia" precision="day"  value="${consultaAutorizadosInstance?.fhFinvigencia}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: consultaAutorizadosInstance, field: 'fhCreacion', 'error')} ">
	<label for="fhCreacion">
		<g:message code="consultaAutorizados.fhCreacion.label" default="Fh Creacion" />
		
	</label>
	<g:datePicker name="fhCreacion" precision="day"  value="${consultaAutorizadosInstance?.fhCreacion}" default="none" noSelection="['': '']" />
</div>

