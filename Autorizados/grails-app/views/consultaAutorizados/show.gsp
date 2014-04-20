
<%@ page import="mx.amib.sistemas.autorizados.sumario.ConsultaAutorizados" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'consultaAutorizados.label', default: 'ConsultaAutorizados')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-consultaAutorizados" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-consultaAutorizados" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list consultaAutorizados">
			
				<g:if test="${consultaAutorizadosInstance?.nuMatricula}">
				<li class="fieldcontain">
					<span id="nuMatricula-label" class="property-label"><g:message code="consultaAutorizados.nuMatricula.label" default="Nu Matricula" /></span>
					
						<span class="property-value" aria-labelledby="nuMatricula-label"><g:fieldValue bean="${consultaAutorizadosInstance}" field="nuMatricula"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaAutorizadosInstance?.nuFolio}">
				<li class="fieldcontain">
					<span id="nuFolio-label" class="property-label"><g:message code="consultaAutorizados.nuFolio.label" default="Nu Folio" /></span>
					
						<span class="property-value" aria-labelledby="nuFolio-label"><g:fieldValue bean="${consultaAutorizadosInstance}" field="nuFolio"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaAutorizadosInstance?.nbNombre}">
				<li class="fieldcontain">
					<span id="nbNombre-label" class="property-label"><g:message code="consultaAutorizados.nbNombre.label" default="Nb Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nbNombre-label"><g:fieldValue bean="${consultaAutorizadosInstance}" field="nbNombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaAutorizadosInstance?.nbApaterno}">
				<li class="fieldcontain">
					<span id="nbApaterno-label" class="property-label"><g:message code="consultaAutorizados.nbApaterno.label" default="Nb Apaterno" /></span>
					
						<span class="property-value" aria-labelledby="nbApaterno-label"><g:fieldValue bean="${consultaAutorizadosInstance}" field="nbApaterno"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaAutorizadosInstance?.nbAmaterno}">
				<li class="fieldcontain">
					<span id="nbAmaterno-label" class="property-label"><g:message code="consultaAutorizados.nbAmaterno.label" default="Nb Amaterno" /></span>
					
						<span class="property-value" aria-labelledby="nbAmaterno-label"><g:fieldValue bean="${consultaAutorizadosInstance}" field="nbAmaterno"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaAutorizadosInstance?.idSituacionaut}">
				<li class="fieldcontain">
					<span id="idSituacionaut-label" class="property-label"><g:message code="consultaAutorizados.idSituacionaut.label" default="Id Situacionaut" /></span>
					
						<span class="property-value" aria-labelledby="idSituacionaut-label"><g:fieldValue bean="${consultaAutorizadosInstance}" field="idSituacionaut"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaAutorizadosInstance?.dsSituacionaut}">
				<li class="fieldcontain">
					<span id="dsSituacionaut-label" class="property-label"><g:message code="consultaAutorizados.dsSituacionaut.label" default="Ds Situacionaut" /></span>
					
						<span class="property-value" aria-labelledby="dsSituacionaut-label"><g:fieldValue bean="${consultaAutorizadosInstance}" field="dsSituacionaut"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaAutorizadosInstance?.idTpautorizacion}">
				<li class="fieldcontain">
					<span id="idTpautorizacion-label" class="property-label"><g:message code="consultaAutorizados.idTpautorizacion.label" default="Id Tpautorizacion" /></span>
					
						<span class="property-value" aria-labelledby="idTpautorizacion-label"><g:fieldValue bean="${consultaAutorizadosInstance}" field="idTpautorizacion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaAutorizadosInstance?.dsTpautorizacion}">
				<li class="fieldcontain">
					<span id="dsTpautorizacion-label" class="property-label"><g:message code="consultaAutorizados.dsTpautorizacion.label" default="Ds Tpautorizacion" /></span>
					
						<span class="property-value" aria-labelledby="dsTpautorizacion-label"><g:fieldValue bean="${consultaAutorizadosInstance}" field="dsTpautorizacion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaAutorizadosInstance?.idInstitucion}">
				<li class="fieldcontain">
					<span id="idInstitucion-label" class="property-label"><g:message code="consultaAutorizados.idInstitucion.label" default="Id Institucion" /></span>
					
						<span class="property-value" aria-labelledby="idInstitucion-label"><g:fieldValue bean="${consultaAutorizadosInstance}" field="idInstitucion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaAutorizadosInstance?.nbInstitucion}">
				<li class="fieldcontain">
					<span id="nbInstitucion-label" class="property-label"><g:message code="consultaAutorizados.nbInstitucion.label" default="Nb Institucion" /></span>
					
						<span class="property-value" aria-labelledby="nbInstitucion-label"><g:fieldValue bean="${consultaAutorizadosInstance}" field="nbInstitucion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaAutorizadosInstance?.fhIniciovigencia}">
				<li class="fieldcontain">
					<span id="fhIniciovigencia-label" class="property-label"><g:message code="consultaAutorizados.fhIniciovigencia.label" default="Fh Iniciovigencia" /></span>
					
						<span class="property-value" aria-labelledby="fhIniciovigencia-label"><g:formatDate date="${consultaAutorizadosInstance?.fhIniciovigencia}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaAutorizadosInstance?.fhFinvigencia}">
				<li class="fieldcontain">
					<span id="fhFinvigencia-label" class="property-label"><g:message code="consultaAutorizados.fhFinvigencia.label" default="Fh Finvigencia" /></span>
					
						<span class="property-value" aria-labelledby="fhFinvigencia-label"><g:formatDate date="${consultaAutorizadosInstance?.fhFinvigencia}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaAutorizadosInstance?.fhCreacion}">
				<li class="fieldcontain">
					<span id="fhCreacion-label" class="property-label"><g:message code="consultaAutorizados.fhCreacion.label" default="Fh Creacion" /></span>
					
						<span class="property-value" aria-labelledby="fhCreacion-label"><g:formatDate date="${consultaAutorizadosInstance?.fhCreacion}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${consultaAutorizadosInstance?.id}" />
					<g:link class="edit" action="edit" id="${consultaAutorizadosInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
