<%@ page import="mx.amib.sistemas.puntos.CertificacionPuntos" %>



<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'estatus', 'error')} ">
	<label for="estatus">
		<g:message code="certificacionPuntos.estatus.label" default="Estatus" />
		
	</label>
	<g:textField name="estatus" value="${certificacionPuntosInstance?.estatus}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'fechInicioVigenciaAnterior', 'error')} ">
	<label for="fechInicioVigenciaAnterior">
		<g:message code="certificacionPuntos.fechInicioVigenciaAnterior.label" default="Fech Inicio Vigencia Anterior" />
		
	</label>
	<g:textField name="fechInicioVigenciaAnterior" value="${certificacionPuntosInstance?.fechInicioVigenciaAnterior}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'fechaEmisioCarta', 'error')} ">
	<label for="fechaEmisioCarta">
		<g:message code="certificacionPuntos.fechaEmisioCarta.label" default="Fecha Emisio Carta" />
		
	</label>
	<g:textField name="fechaEmisioCarta" value="${certificacionPuntosInstance?.fechaEmisioCarta}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'fechaFinVigenciaAnterior', 'error')} ">
	<label for="fechaFinVigenciaAnterior">
		<g:message code="certificacionPuntos.fechaFinVigenciaAnterior.label" default="Fecha Fin Vigencia Anterior" />
		
	</label>
	<g:textField name="fechaFinVigenciaAnterior" value="${certificacionPuntosInstance?.fechaFinVigenciaAnterior}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'fechaFinVigenciaNueva', 'error')} ">
	<label for="fechaFinVigenciaNueva">
		<g:message code="certificacionPuntos.fechaFinVigenciaNueva.label" default="Fecha Fin Vigencia Nueva" />
		
	</label>
	<g:textField name="fechaFinVigenciaNueva" value="${certificacionPuntosInstance?.fechaFinVigenciaNueva}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'fechaInicioVigenciaNueva', 'error')} ">
	<label for="fechaInicioVigenciaNueva">
		<g:message code="certificacionPuntos.fechaInicioVigenciaNueva.label" default="Fecha Inicio Vigencia Nueva" />
		
	</label>
	<g:textField name="fechaInicioVigenciaNueva" value="${certificacionPuntosInstance?.fechaInicioVigenciaNueva}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'fechaRecepcion', 'error')} ">
	<label for="fechaRecepcion">
		<g:message code="certificacionPuntos.fechaRecepcion.label" default="Fecha Recepcion" />
		
	</label>
	<g:textField name="fechaRecepcion" value="${certificacionPuntosInstance?.fechaRecepcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'figura', 'error')} ">
	<label for="figura">
		<g:message code="certificacionPuntos.figura.label" default="Figura" />
		
	</label>
	<g:textField name="figura" value="${certificacionPuntosInstance?.figura}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'idFiguraCertificacion', 'error')} ">
	<label for="idFiguraCertificacion">
		<g:message code="certificacionPuntos.idFiguraCertificacion.label" default="Id Figura Certificacion" />
		
	</label>
	<g:textField name="idFiguraCertificacion" value="${certificacionPuntosInstance?.idFiguraCertificacion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'institucion', 'error')} ">
	<label for="institucion">
		<g:message code="certificacionPuntos.institucion.label" default="Institucion" />
		
	</label>
	<g:textField name="institucion" value="${certificacionPuntosInstance?.institucion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'instituto1', 'error')} ">
	<label for="instituto1">
		<g:message code="certificacionPuntos.instituto1.label" default="Instituto1" />
		
	</label>
	<g:textField name="instituto1" value="${certificacionPuntosInstance?.instituto1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'instituto2', 'error')} ">
	<label for="instituto2">
		<g:message code="certificacionPuntos.instituto2.label" default="Instituto2" />
		
	</label>
	<g:textField name="instituto2" value="${certificacionPuntosInstance?.instituto2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'instituto3', 'error')} ">
	<label for="instituto3">
		<g:message code="certificacionPuntos.instituto3.label" default="Instituto3" />
		
	</label>
	<g:textField name="instituto3" value="${certificacionPuntosInstance?.instituto3}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'instituto4', 'error')} ">
	<label for="instituto4">
		<g:message code="certificacionPuntos.instituto4.label" default="Instituto4" />
		
	</label>
	<g:textField name="instituto4" value="${certificacionPuntosInstance?.instituto4}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'instituto5', 'error')} ">
	<label for="instituto5">
		<g:message code="certificacionPuntos.instituto5.label" default="Instituto5" />
		
	</label>
	<g:textField name="instituto5" value="${certificacionPuntosInstance?.instituto5}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'instituto6', 'error')} ">
	<label for="instituto6">
		<g:message code="certificacionPuntos.instituto6.label" default="Instituto6" />
		
	</label>
	<g:textField name="instituto6" value="${certificacionPuntosInstance?.instituto6}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'instituto7', 'error')} ">
	<label for="instituto7">
		<g:message code="certificacionPuntos.instituto7.label" default="Instituto7" />
		
	</label>
	<g:textField name="instituto7" value="${certificacionPuntosInstance?.instituto7}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'materno', 'error')} ">
	<label for="materno">
		<g:message code="certificacionPuntos.materno.label" default="Materno" />
		
	</label>
	<g:textField name="materno" value="${certificacionPuntosInstance?.materno}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'matricula', 'error')} ">
	<label for="matricula">
		<g:message code="certificacionPuntos.matricula.label" default="Matricula" />
		
	</label>
	<g:textField name="matricula" value="${certificacionPuntosInstance?.matricula}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="certificacionPuntos.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${certificacionPuntosInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'opcion1', 'error')} ">
	<label for="opcion1">
		<g:message code="certificacionPuntos.opcion1.label" default="Opcion1" />
		
	</label>
	<g:textField name="opcion1" value="${certificacionPuntosInstance?.opcion1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'opcion2', 'error')} ">
	<label for="opcion2">
		<g:message code="certificacionPuntos.opcion2.label" default="Opcion2" />
		
	</label>
	<g:textField name="opcion2" value="${certificacionPuntosInstance?.opcion2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'opcion3', 'error')} ">
	<label for="opcion3">
		<g:message code="certificacionPuntos.opcion3.label" default="Opcion3" />
		
	</label>
	<g:textField name="opcion3" value="${certificacionPuntosInstance?.opcion3}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'opcion4', 'error')} ">
	<label for="opcion4">
		<g:message code="certificacionPuntos.opcion4.label" default="Opcion4" />
		
	</label>
	<g:textField name="opcion4" value="${certificacionPuntosInstance?.opcion4}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'opcion5', 'error')} ">
	<label for="opcion5">
		<g:message code="certificacionPuntos.opcion5.label" default="Opcion5" />
		
	</label>
	<g:textField name="opcion5" value="${certificacionPuntosInstance?.opcion5}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'opcion6', 'error')} ">
	<label for="opcion6">
		<g:message code="certificacionPuntos.opcion6.label" default="Opcion6" />
		
	</label>
	<g:textField name="opcion6" value="${certificacionPuntosInstance?.opcion6}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'opcion7', 'error')} ">
	<label for="opcion7">
		<g:message code="certificacionPuntos.opcion7.label" default="Opcion7" />
		
	</label>
	<g:textField name="opcion7" value="${certificacionPuntosInstance?.opcion7}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'paterno', 'error')} ">
	<label for="paterno">
		<g:message code="certificacionPuntos.paterno.label" default="Paterno" />
		
	</label>
	<g:textField name="paterno" value="${certificacionPuntosInstance?.paterno}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: certificacionPuntosInstance, field: 'tipoInstitucion', 'error')} ">
	<label for="tipoInstitucion">
		<g:message code="certificacionPuntos.tipoInstitucion.label" default="Tipo Institucion" />
		
	</label>
	<g:textField name="tipoInstitucion" value="${certificacionPuntosInstance?.tipoInstitucion}"/>
</div>

