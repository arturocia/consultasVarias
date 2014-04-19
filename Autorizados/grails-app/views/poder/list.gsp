
<%@ page import="mx.amib.sistemas.autorizados.sumario.Poder" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'poder.label', default: 'Poder')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-poder" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-poder" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nuNotario" title="${message(code: 'poder.nuNotario.label', default: 'Nu Notario')}" />
					
						<g:sortableColumn property="nuEscritura" title="${message(code: 'poder.nuEscritura.label', default: 'Nu Escritura')}" />
					
						<g:sortableColumn property="fhCreacion" title="${message(code: 'poder.fhCreacion.label', default: 'Fh Creacion')}" />
					
						<g:sortableColumn property="fhModificacion" title="${message(code: 'poder.fhModificacion.label', default: 'Fh Modificacion')}" />
					
						<th><g:message code="poder.autorizacion.label" default="Autorizacion" /></th>
					
						<th><g:message code="poder.tipoPoder.label" default="Tipo Poder" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${poderInstanceList}" status="i" var="poderInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${poderInstance.id}">${fieldValue(bean: poderInstance, field: "nuNotario")}</g:link></td>
					
						<td>${fieldValue(bean: poderInstance, field: "nuEscritura")}</td>
					
						<td><g:formatDate date="${poderInstance.fhCreacion}" /></td>
					
						<td><g:formatDate date="${poderInstance.fhModificacion}" /></td>
					
						<td>${fieldValue(bean: poderInstance, field: "autorizacion")}</td>
					
						<td>${fieldValue(bean: poderInstance, field: "tipoPoder")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${poderInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
