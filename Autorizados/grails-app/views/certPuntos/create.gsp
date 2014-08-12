<!DOCTYPE html>
<html>
	<head>
		<meta name="layout">
		<link rel="stylesheet" type="text/css" href="<g:resource dir="css" file="autorizados.css" />" />
		<title>Subir datos de puntos de certificacion</title>
	</head>
	<body>
		<div class="content scaffold-create" role="main">
			<fieldset>
				<legend><strong>Subir archivo de puntos</strong></legend>
				<g:if test="${flash.message}"><div class="message" role="status">${flash.message}</div></g:if>
				<g:uploadForm action="upload">
					<fieldset class="form">
	                    <input type="file" name="file" />
					</fieldset>
					<fieldset class="buttons">
						<g:submitButton name="upload" class="save" value="Subir" />
					</fieldset>
				</g:uploadForm>
			</fieldset>
		</div>
	</body>
</html>
