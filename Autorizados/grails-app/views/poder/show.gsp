
<%@ page import="mx.amib.sistemas.autorizados.sumario.Poder" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'poder.label', default: 'Poder')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-poder" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-poder" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list poder">
			
				<g:if test="${poderInstance?.nuNotario}">
				<li class="fieldcontain">
					<span id="nuNotario-label" class="property-label"><g:message code="poder.nuNotario.label" default="Nu Notario" /></span>
					
						<span class="property-value" aria-labelledby="nuNotario-label"><g:fieldValue bean="${poderInstance}" field="nuNotario"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${poderInstance?.nuEscritura}">
				<li class="fieldcontain">
					<span id="nuEscritura-label" class="property-label"><g:message code="poder.nuEscritura.label" default="Nu Escritura" /></span>
					
						<span class="property-value" aria-labelledby="nuEscritura-label"><g:fieldValue bean="${poderInstance}" field="nuEscritura"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${poderInstance?.fhCreacion}">
				<li class="fieldcontain">
					<span id="fhCreacion-label" class="property-label"><g:message code="poder.fhCreacion.label" default="Fh Creacion" /></span>
					
						<span class="property-value" aria-labelledby="fhCreacion-label"><g:formatDate date="${poderInstance?.fhCreacion}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${poderInstance?.fhModificacion}">
				<li class="fieldcontain">
					<span id="fhModificacion-label" class="property-label"><g:message code="poder.fhModificacion.label" default="Fh Modificacion" /></span>
					
						<span class="property-value" aria-labelledby="fhModificacion-label"><g:formatDate date="${poderInstance?.fhModificacion}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${poderInstance?.autorizacion}">
				<li class="fieldcontain">
					<span id="autorizacion-label" class="property-label"><g:message code="poder.autorizacion.label" default="Autorizacion" /></span>
					
						<span class="property-value" aria-labelledby="autorizacion-label"><g:link controller="autorizacion" action="show" id="${poderInstance?.autorizacion?.id}">${poderInstance?.autorizacion?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${poderInstance?.tipoPoder}">
				<li class="fieldcontain">
					<span id="tipoPoder-label" class="property-label"><g:message code="poder.tipoPoder.label" default="Tipo Poder" /></span>
					
						<span class="property-value" aria-labelledby="tipoPoder-label"><g:link controller="tipoPoder" action="show" id="${poderInstance?.tipoPoder?.id}">${poderInstance?.tipoPoder?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${poderInstance?.id}" />
					<g:link class="edit" action="edit" id="${poderInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
