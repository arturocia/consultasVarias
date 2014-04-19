
<%@ page import="mx.amib.sistemas.autorizados.sumario.catalogo.TipoAutorizacion" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tipoAutorizacion.label', default: 'TipoAutorizacion')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-tipoAutorizacion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-tipoAutorizacion" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="dsTpautorizacion" title="${message(code: 'tipoAutorizacion.dsTpautorizacion.label', default: 'Ds Tpautorizacion')}" />
					
						<g:sortableColumn property="stVigente" title="${message(code: 'tipoAutorizacion.stVigente.label', default: 'St Vigente')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${tipoAutorizacionInstanceList}" status="i" var="tipoAutorizacionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${tipoAutorizacionInstance.id}">${fieldValue(bean: tipoAutorizacionInstance, field: "dsTpautorizacion")}</g:link></td>
					
						<td><g:formatBoolean boolean="${tipoAutorizacionInstance.stVigente}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${tipoAutorizacionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
