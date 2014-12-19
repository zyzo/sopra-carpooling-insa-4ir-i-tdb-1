<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Suggestion</title>
<link href="custom/css/main.css" rel="stylesheet"/>
</head>
<body>
	<form action="suggest" method="post">
		<label for="email">Email</label>
		<input name="email" type="email" placeholder="Votre email" required="required"/><br/><br/>
		<label for="message">Suggestion</label>
		<textarea name="message" rows="10" placeholder="Votre suggestion" required="required"></textarea><br/><br/>
		<button id="suggestButton" type="submit">Envoyer</button>
	</form>
</body>
</html>