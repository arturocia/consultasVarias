
<%@ page import="mx.amib.sistemas.autorizados.sumario.ConsultaAutorizados" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" >
		<link rel="stylesheet" type="text/css" href="<g:resource dir="css" file="autorizados.css" />" />
	</head>
	<body>
		<div class="content">		
			<fieldset>
				<legend><strong>Datos generales</strong></legend>
					<table>
						<tr>
							<td><strong>Nombre:</strong>&nbsp;
							${sustentanteInstance?.nbNombre}</td>
							<td><strong>Matrícula:</strong>&nbsp;
							${sustentanteInstance?.nuMatricula}</td>
						<tr/>
						<tr>
							<td><strong>Apellido Paterno:</strong>&nbsp;
							${sustentanteInstance?.nbApaterno}</td>
							<td><strong>Folio:</strong>&nbsp;
							${sustentanteInstance?.nuFolio}</td>
						<tr/>
						<tr>
							<td><strong>Apellido Materno:</strong>&nbsp;
							${sustentanteInstance?.nbAmaterno}</td>
						<tr/>
						<tr>
							<td><strong>Intermediario de valores en que labora:</strong>&nbsp;
							${sustentanteInstance?.institucion?.nbInstitucion}</td>
						<tr/>
					</table>
			</fieldset>
			<br/>
			<fieldset>
				<legend><strong>Datos de la autorización</strong></legend>
				<table class="detailResultTable" style="width: 100%">
					<tr>
						<th>
						Vig.
						</th>
						<th>
						Autorización
						</th>
						<th>
						Oficio
						</th>
						<th>
						F. Oficio
						</th>
						<th>
						Fin vigencia
						</th>
						<th>
						Rev.
						</th>
						<th>
						Causa rev.
						</th>
					</tr>
					
					<g:each status="i" in="${sustentanteInstance?.certificaciones}" var="item" >
			  			<tr class="detailResultRow" >
			  			
			  				<g:if test="${todayDate > item.autorizaciones.toList()[0]?.fhFinvigencia}">
			  					<td>No</td>
			  				</g:if>
			  				
			  				<g:else>
			  					<td>Si</td>
			  				</g:else>
							<td>${item.figura.dsFigura.encodeAsHTML()}</td>
							<td>${item.autorizaciones.toList()[0]?.txOficio?.encodeAsHTML()}</td>
							<td><g:formatDate format="dd-MM-yyyy" date="${item.autorizaciones.toList()[0]?.fhOficio}"/></td>
							<td><g:formatDate format="dd-MM-yyyy" date="${item.autorizaciones.toList()[0]?.fhFinvigencia}"/></td>
							
							<g:if test="${item.autorizaciones.toList()[0]?.stRevocado == null || item.autorizaciones.toList()[0]?.stRevocado == false}">
			  					<td>No</td>
			  				</g:if>
			  				<g:else>
			  					<td>Si</td>
			  				</g:else>
			  				
							<g:if test="${item.autorizaciones.toList()[0]?.txCausarev == null}">
								<td>Sin revocar</td>
							</g:if>
							<g:else>
								<td>${item.autorizaciones.toList()[0]?.txCausarev?.encodeAsHTML()}</td>
							</g:else>
							
			  			</tr>
		  			</g:each>
  			
				</table>
			</fieldset>
			<br/>
			<fieldset>
				<legend><strong>Datos del poder</strong></legend>
			</fieldset>
			<br/>
			<fieldset>
				<legend><strong>Certificaciones</strong></legend>
				<table class="detailResultTable" style="width: 100%">
					<tr>
						<th>
						Vig.
						</th>
						<th>
						Figura
						</th>
						<th>
						Inicio
						</th>
						<th>
						Fin
						</th>
						<th>
						Certificado por
						</th>

					</tr>
					
					<g:each status="i" in="${sustentanteInstance?.certificaciones}" var="item" >
			  			<tr class="detailResultRow" >
			  			
			  				<g:if test="${todayDate > item.fhFin}">
			  					<td>No</td>
			  				</g:if>
			  				<g:else>
			  					<td>Si</td>
			  				</g:else>
			  				
			  				<td>${item.figura.dsFigura.encodeAsHTML()}</td>
			  				
			  				<td><g:formatDate format="dd-MM-yyyy" date="${item.fhInicio}"/></td>
							<td><g:formatDate format="dd-MM-yyyy" date="${item.fhFin}"/></td>
			  				
			  				<td>${item.tipoCertificacion?.dsTpcertificacion?.encodeAsHTML()}</td>
			  								
			  			</tr>
		  			</g:each>
		  		</table>
			</fieldset>
		</div>		
	</body>
</html>
