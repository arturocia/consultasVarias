
<%@ page import="mx.amib.sistemas.autorizados.sumario.catalogo.Institucion" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'institucion.label', default: 'Institucion')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-institucion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-institucion" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list institucion">
			
				<g:if test="${institucionInstance?.nbInstitucion}">
				<li class="fieldcontain">
					<span id="nbInstitucion-label" class="property-label"><g:message code="institucion.nbInstitucion.label" default="Nb Institucion" /></span>
					
						<span class="property-value" aria-labelledby="nbInstitucion-label"><g:fieldValue bean="${institucionInstance}" field="nbInstitucion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${institucionInstance?.stVigente}">
				<li class="fieldcontain">
					<span id="stVigente-label" class="property-label"><g:message code="institucion.stVigente.label" default="St Vigente" /></span>
					
						<span class="property-value" aria-labelledby="stVigente-label"><g:formatBoolean boolean="${institucionInstance?.stVigente}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${institucionInstance?.id}" />
					<g:link class="edit" action="edit" id="${institucionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
