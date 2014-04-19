
<%@ page import="mx.amib.sistemas.autorizados.sumario.catalogo.TipoAutorizacion" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tipoAutorizacion.label', default: 'TipoAutorizacion')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-tipoAutorizacion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-tipoAutorizacion" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list tipoAutorizacion">
			
				<g:if test="${tipoAutorizacionInstance?.dsTpautorizacion}">
				<li class="fieldcontain">
					<span id="dsTpautorizacion-label" class="property-label"><g:message code="tipoAutorizacion.dsTpautorizacion.label" default="Ds Tpautorizacion" /></span>
					
						<span class="property-value" aria-labelledby="dsTpautorizacion-label"><g:fieldValue bean="${tipoAutorizacionInstance}" field="dsTpautorizacion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tipoAutorizacionInstance?.stVigente}">
				<li class="fieldcontain">
					<span id="stVigente-label" class="property-label"><g:message code="tipoAutorizacion.stVigente.label" default="St Vigente" /></span>
					
						<span class="property-value" aria-labelledby="stVigente-label"><g:formatBoolean boolean="${tipoAutorizacionInstance?.stVigente}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${tipoAutorizacionInstance?.id}" />
					<g:link class="edit" action="edit" id="${tipoAutorizacionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
