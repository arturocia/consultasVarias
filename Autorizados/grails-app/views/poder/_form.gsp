<%@ page import="mx.amib.sistemas.autorizados.sumario.Poder" %>



<div class="fieldcontain ${hasErrors(bean: poderInstance, field: 'nuNotario', 'error')} ">
	<label for="nuNotario">
		<g:message code="poder.nuNotario.label" default="Nu Notario" />
		
	</label>
	<g:field name="nuNotario" type="number" value="${poderInstance.nuNotario}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: poderInstance, field: 'nuEscritura', 'error')} ">
	<label for="nuEscritura">
		<g:message code="poder.nuEscritura.label" default="Nu Escritura" />
		
	</label>
	<g:field name="nuEscritura" type="number" value="${poderInstance.nuEscritura}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: poderInstance, field: 'fhCreacion', 'error')} ">
	<label for="fhCreacion">
		<g:message code="poder.fhCreacion.label" default="Fh Creacion" />
		
	</label>
	<g:datePicker name="fhCreacion" precision="day"  value="${poderInstance?.fhCreacion}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: poderInstance, field: 'fhModificacion', 'error')} ">
	<label for="fhModificacion">
		<g:message code="poder.fhModificacion.label" default="Fh Modificacion" />
		
	</label>
	<g:datePicker name="fhModificacion" precision="day"  value="${poderInstance?.fhModificacion}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: poderInstance, field: 'autorizacion', 'error')} required">
	<label for="autorizacion">
		<g:message code="poder.autorizacion.label" default="Autorizacion" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="autorizacion" name="autorizacion.id" from="${mx.amib.sistemas.autorizados.sumario.Autorizacion.list()}" optionKey="id" required="" value="${poderInstance?.autorizacion?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: poderInstance, field: 'tipoPoder', 'error')} required">
	<label for="tipoPoder">
		<g:message code="poder.tipoPoder.label" default="Tipo Poder" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="tipoPoder" name="tipoPoder.id" from="${mx.amib.sistemas.autorizados.sumario.catalogo.TipoPoder.list()}" optionKey="id" required="" value="${poderInstance?.tipoPoder?.id}" class="many-to-one"/>
</div>

