
<%@ page import="mx.amib.sistemas.autorizados.sumario.catalogo.TipoCertificacion" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tipoCertificacion.label', default: 'TipoCertificacion')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-tipoCertificacion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-tipoCertificacion" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="dsTpcertificacion" title="${message(code: 'tipoCertificacion.dsTpcertificacion.label', default: 'Ds Tpcertificacion')}" />
					
						<g:sortableColumn property="stVigente" title="${message(code: 'tipoCertificacion.stVigente.label', default: 'St Vigente')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${tipoCertificacionInstanceList}" status="i" var="tipoCertificacionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${tipoCertificacionInstance.id}">${fieldValue(bean: tipoCertificacionInstance, field: "dsTpcertificacion")}</g:link></td>
					
						<td><g:formatBoolean boolean="${tipoCertificacionInstance.stVigente}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${tipoCertificacionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
