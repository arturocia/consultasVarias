
<%@ page import="mx.amib.sistemas.puntos.CertificacionPuntos" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'certificacionPuntos.label', default: 'CertificacionPuntos')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-certificacionPuntos" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-certificacionPuntos" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list certificacionPuntos">
			
				<g:if test="${certificacionPuntosInstance?.estatus}">
				<li class="fieldcontain">
					<span id="estatus-label" class="property-label"><g:message code="certificacionPuntos.estatus.label" default="Estatus" /></span>
					
						<span class="property-value" aria-labelledby="estatus-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="estatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.fechInicioVigenciaAnterior}">
				<li class="fieldcontain">
					<span id="fechInicioVigenciaAnterior-label" class="property-label"><g:message code="certificacionPuntos.fechInicioVigenciaAnterior.label" default="Fech Inicio Vigencia Anterior" /></span>
					
						<span class="property-value" aria-labelledby="fechInicioVigenciaAnterior-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="fechInicioVigenciaAnterior"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.fechaEmisioCarta}">
				<li class="fieldcontain">
					<span id="fechaEmisioCarta-label" class="property-label"><g:message code="certificacionPuntos.fechaEmisioCarta.label" default="Fecha Emisio Carta" /></span>
					
						<span class="property-value" aria-labelledby="fechaEmisioCarta-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="fechaEmisioCarta"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.fechaFinVigenciaAnterior}">
				<li class="fieldcontain">
					<span id="fechaFinVigenciaAnterior-label" class="property-label"><g:message code="certificacionPuntos.fechaFinVigenciaAnterior.label" default="Fecha Fin Vigencia Anterior" /></span>
					
						<span class="property-value" aria-labelledby="fechaFinVigenciaAnterior-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="fechaFinVigenciaAnterior"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.fechaFinVigenciaNueva}">
				<li class="fieldcontain">
					<span id="fechaFinVigenciaNueva-label" class="property-label"><g:message code="certificacionPuntos.fechaFinVigenciaNueva.label" default="Fecha Fin Vigencia Nueva" /></span>
					
						<span class="property-value" aria-labelledby="fechaFinVigenciaNueva-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="fechaFinVigenciaNueva"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.fechaInicioVigenciaNueva}">
				<li class="fieldcontain">
					<span id="fechaInicioVigenciaNueva-label" class="property-label"><g:message code="certificacionPuntos.fechaInicioVigenciaNueva.label" default="Fecha Inicio Vigencia Nueva" /></span>
					
						<span class="property-value" aria-labelledby="fechaInicioVigenciaNueva-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="fechaInicioVigenciaNueva"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.fechaRecepcion}">
				<li class="fieldcontain">
					<span id="fechaRecepcion-label" class="property-label"><g:message code="certificacionPuntos.fechaRecepcion.label" default="Fecha Recepcion" /></span>
					
						<span class="property-value" aria-labelledby="fechaRecepcion-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="fechaRecepcion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.figura}">
				<li class="fieldcontain">
					<span id="figura-label" class="property-label"><g:message code="certificacionPuntos.figura.label" default="Figura" /></span>
					
						<span class="property-value" aria-labelledby="figura-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="figura"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.idFiguraCertificacion}">
				<li class="fieldcontain">
					<span id="idFiguraCertificacion-label" class="property-label"><g:message code="certificacionPuntos.idFiguraCertificacion.label" default="Id Figura Certificacion" /></span>
					
						<span class="property-value" aria-labelledby="idFiguraCertificacion-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="idFiguraCertificacion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.institucion}">
				<li class="fieldcontain">
					<span id="institucion-label" class="property-label"><g:message code="certificacionPuntos.institucion.label" default="Institucion" /></span>
					
						<span class="property-value" aria-labelledby="institucion-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="institucion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.instituto1}">
				<li class="fieldcontain">
					<span id="instituto1-label" class="property-label"><g:message code="certificacionPuntos.instituto1.label" default="Instituto1" /></span>
					
						<span class="property-value" aria-labelledby="instituto1-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="instituto1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.instituto2}">
				<li class="fieldcontain">
					<span id="instituto2-label" class="property-label"><g:message code="certificacionPuntos.instituto2.label" default="Instituto2" /></span>
					
						<span class="property-value" aria-labelledby="instituto2-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="instituto2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.instituto3}">
				<li class="fieldcontain">
					<span id="instituto3-label" class="property-label"><g:message code="certificacionPuntos.instituto3.label" default="Instituto3" /></span>
					
						<span class="property-value" aria-labelledby="instituto3-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="instituto3"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.instituto4}">
				<li class="fieldcontain">
					<span id="instituto4-label" class="property-label"><g:message code="certificacionPuntos.instituto4.label" default="Instituto4" /></span>
					
						<span class="property-value" aria-labelledby="instituto4-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="instituto4"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.instituto5}">
				<li class="fieldcontain">
					<span id="instituto5-label" class="property-label"><g:message code="certificacionPuntos.instituto5.label" default="Instituto5" /></span>
					
						<span class="property-value" aria-labelledby="instituto5-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="instituto5"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.instituto6}">
				<li class="fieldcontain">
					<span id="instituto6-label" class="property-label"><g:message code="certificacionPuntos.instituto6.label" default="Instituto6" /></span>
					
						<span class="property-value" aria-labelledby="instituto6-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="instituto6"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.instituto7}">
				<li class="fieldcontain">
					<span id="instituto7-label" class="property-label"><g:message code="certificacionPuntos.instituto7.label" default="Instituto7" /></span>
					
						<span class="property-value" aria-labelledby="instituto7-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="instituto7"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.materno}">
				<li class="fieldcontain">
					<span id="materno-label" class="property-label"><g:message code="certificacionPuntos.materno.label" default="Materno" /></span>
					
						<span class="property-value" aria-labelledby="materno-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="materno"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.matricula}">
				<li class="fieldcontain">
					<span id="matricula-label" class="property-label"><g:message code="certificacionPuntos.matricula.label" default="Matricula" /></span>
					
						<span class="property-value" aria-labelledby="matricula-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="matricula"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="certificacionPuntos.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.opcion1}">
				<li class="fieldcontain">
					<span id="opcion1-label" class="property-label"><g:message code="certificacionPuntos.opcion1.label" default="Opcion1" /></span>
					
						<span class="property-value" aria-labelledby="opcion1-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="opcion1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.opcion2}">
				<li class="fieldcontain">
					<span id="opcion2-label" class="property-label"><g:message code="certificacionPuntos.opcion2.label" default="Opcion2" /></span>
					
						<span class="property-value" aria-labelledby="opcion2-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="opcion2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.opcion3}">
				<li class="fieldcontain">
					<span id="opcion3-label" class="property-label"><g:message code="certificacionPuntos.opcion3.label" default="Opcion3" /></span>
					
						<span class="property-value" aria-labelledby="opcion3-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="opcion3"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.opcion4}">
				<li class="fieldcontain">
					<span id="opcion4-label" class="property-label"><g:message code="certificacionPuntos.opcion4.label" default="Opcion4" /></span>
					
						<span class="property-value" aria-labelledby="opcion4-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="opcion4"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.opcion5}">
				<li class="fieldcontain">
					<span id="opcion5-label" class="property-label"><g:message code="certificacionPuntos.opcion5.label" default="Opcion5" /></span>
					
						<span class="property-value" aria-labelledby="opcion5-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="opcion5"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.opcion6}">
				<li class="fieldcontain">
					<span id="opcion6-label" class="property-label"><g:message code="certificacionPuntos.opcion6.label" default="Opcion6" /></span>
					
						<span class="property-value" aria-labelledby="opcion6-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="opcion6"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.opcion7}">
				<li class="fieldcontain">
					<span id="opcion7-label" class="property-label"><g:message code="certificacionPuntos.opcion7.label" default="Opcion7" /></span>
					
						<span class="property-value" aria-labelledby="opcion7-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="opcion7"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.paterno}">
				<li class="fieldcontain">
					<span id="paterno-label" class="property-label"><g:message code="certificacionPuntos.paterno.label" default="Paterno" /></span>
					
						<span class="property-value" aria-labelledby="paterno-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="paterno"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${certificacionPuntosInstance?.tipoInstitucion}">
				<li class="fieldcontain">
					<span id="tipoInstitucion-label" class="property-label"><g:message code="certificacionPuntos.tipoInstitucion.label" default="Tipo Institucion" /></span>
					
						<span class="property-value" aria-labelledby="tipoInstitucion-label"><g:fieldValue bean="${certificacionPuntosInstance}" field="tipoInstitucion"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${certificacionPuntosInstance?.id}" />
					<g:link class="edit" action="edit" id="${certificacionPuntosInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
