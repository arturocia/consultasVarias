
<%@ page import="mx.amib.sistemas.autorizados.sumario.catalogo.TipoPoder" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tipoPoder.label', default: 'TipoPoder')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-tipoPoder" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-tipoPoder" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="dsTppoder" title="${message(code: 'tipoPoder.dsTppoder.label', default: 'Ds Tppoder')}" />
					
						<g:sortableColumn property="stVigente" title="${message(code: 'tipoPoder.stVigente.label', default: 'St Vigente')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${tipoPoderInstanceList}" status="i" var="tipoPoderInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${tipoPoderInstance.id}">${fieldValue(bean: tipoPoderInstance, field: "dsTppoder")}</g:link></td>
					
						<td><g:formatBoolean boolean="${tipoPoderInstance.stVigente}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${tipoPoderInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
