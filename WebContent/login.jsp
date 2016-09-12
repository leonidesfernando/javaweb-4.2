<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login - Tarefa 4.2</title>
</head>
<body>

	<form action="controller" method="post">
		<fieldset>
			<legend>Credenciais</legend>
			<div>
				<label>Usuário</label>
				<input type="text" name="usuario" id="usuario">
			</div>
			
			<div>
				<label>Senha</label>
				<input type="password" name="senha">
			</div>

			<div>
				<input type="submit" value="Entrar">
			</div>
			
		</fieldset>
	</form>
	<script type="text/javascript">
		document.getElementById('usuario').focus();
	</script>
</body>
</html>