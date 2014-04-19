
<%@ page import="mx.amib.sistemas.autorizados.sumario.catalogo.TipoCertificacion" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tipoCertificacion.label', default: 'TipoCertificacion')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-tipoCertificacion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-tipoCertificacion" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list tipoCertificacion">
			
				<g:if test="${tipoCertificacionInstance?.dsTpcertificacion}">
				<li class="fieldcontain">
					<span id="dsTpcertificacion-label" class="property-label"><g:message code="tipoCertificacion.dsTpcertificacion.label" default="Ds Tpcertificacion" /></span>
					
						<span class="property-value" aria-labelledby="dsTpcertificacion-label"><g:fieldValue bean="${tipoCertificacionInstance}" field="dsTpcertificacion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tipoCertificacionInstance?.stVigente}">
				<li class="fieldcontain">
					<span id="stVigente-label" class="property-label"><g:message code="tipoCertificacion.stVigente.label" default="St Vigente" /></span>
					
						<span class="property-value" aria-labelledby="stVigente-label"><g:formatBoolean boolean="${tipoCertificacionInstance?.stVigente}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${tipoCertificacionInstance?.id}" />
					<g:link class="edit" action="edit" id="${tipoCertificacionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
