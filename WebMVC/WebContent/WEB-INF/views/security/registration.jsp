<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration new user...</title>
<style>
	form fieldset {
		width : 40%;
	} 
	form fieldset label {
		display : block;
		/*width : 50%;
		float :left;*/
	}
	form fieldset input, form fieldset textarea {
		width : 100%;
	}
</style>
</head>
<body>
	<h1>Registration</h1>
	<form method="POST">
		<fieldset>
			<div>
				<label>Логин: </label>
				<input  type="text" name="username" value="${r.username}">
			</div>
			<div>
				<label>Пароль: </label>
				<input  type="password" name="password">
			</div>
			<div>
				<label>Подтверждение: </label>
				<input  type="password" name="confirm">
			</div>
			<div>
				<input type="submit" value="Регистрация">
			</div>
		</fieldset>
	
	</form>
</body>
</html>