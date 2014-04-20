
<%@ page import="mx.amib.sistemas.autorizados.sumario.ConsultaAutorizados" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'consultaAutorizados.label', default: 'ConsultaAutorizados')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-consultaAutorizados" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-consultaAutorizados" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nuMatricula" title="${message(code: 'consultaAutorizados.nuMatricula.label', default: 'Nu Matricula')}" />
					
						<g:sortableColumn property="nuFolio" title="${message(code: 'consultaAutorizados.nuFolio.label', default: 'Nu Folio')}" />
					
						<g:sortableColumn property="nbNombre" title="${message(code: 'consultaAutorizados.nbNombre.label', default: 'Nb Nombre')}" />
					
						<g:sortableColumn property="nbApaterno" title="${message(code: 'consultaAutorizados.nbApaterno.label', default: 'Nb Apaterno')}" />
					
						<g:sortableColumn property="nbAmaterno" title="${message(code: 'consultaAutorizados.nbAmaterno.label', default: 'Nb Amaterno')}" />
					
						<g:sortableColumn property="idSituacionaut" title="${message(code: 'consultaAutorizados.idSituacionaut.label', default: 'Id Situacionaut')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${consultaAutorizadosInstanceList}" status="i" var="consultaAutorizadosInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${consultaAutorizadosInstance.id}">${fieldValue(bean: consultaAutorizadosInstance, field: "nuMatricula")}</g:link></td>
					
						<td>${fieldValue(bean: consultaAutorizadosInstance, field: "nuFolio")}</td>
					
						<td>${fieldValue(bean: consultaAutorizadosInstance, field: "nbNombre")}</td>
					
						<td>${fieldValue(bean: consultaAutorizadosInstance, field: "nbApaterno")}</td>
					
						<td>${fieldValue(bean: consultaAutorizadosInstance, field: "nbAmaterno")}</td>
					
						<td>${fieldValue(bean: consultaAutorizadosInstance, field: "idSituacionaut")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${consultaAutorizadosInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
