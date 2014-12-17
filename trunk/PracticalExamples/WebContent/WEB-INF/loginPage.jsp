<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page Connection</title>
<link href="custom/css/login.css" rel="stylesheet"/>
</head>
<body>
	<form action="login" method="post">
		<label for="username">Identifiant</label>
		<input name="username" type="text" placeholder="Votre identifiant" required="required"/><br/><br/>
		<label for="passwd">Mot de passe</label>
		<input name="passwd" type="password" placeholder="Votre mot de passe" required="required"/><br/><br/>
		<button type="submit">Se connecter</button>
	</form>
</body>
</html>