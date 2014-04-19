
<%@ page import="mx.amib.sistemas.autorizados.sumario.catalogo.Institucion" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'institucion.label', default: 'Institucion')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-institucion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-institucion" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nbInstitucion" title="${message(code: 'institucion.nbInstitucion.label', default: 'Nb Institucion')}" />
					
						<g:sortableColumn property="stVigente" title="${message(code: 'institucion.stVigente.label', default: 'St Vigente')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${institucionInstanceList}" status="i" var="institucionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${institucionInstance.id}">${fieldValue(bean: institucionInstance, field: "nbInstitucion")}</g:link></td>
					
						<td><g:formatBoolean boolean="${institucionInstance.stVigente}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${institucionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
