<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Subir datos de experiencia de certificacion</title>
	</head>
	<body>
		<div class="content scaffold-create" role="main">
			<h1>Subir archivo</h1>
			<g:if test="${flash.message}"><div class="message" role="status">${flash.message}</div></g:if>
			<g:uploadForm action="upload">
				<fieldset class="form">
                    <input type="file" name="file" />
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="upload" class="save" value="Subir" />
				</fieldset>
			</g:uploadForm>
		</div>
	</body>
</html>

