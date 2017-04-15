<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="res/css/bootstrap.min.css" rel="stylesheet">
    <link href="res/css/style.css" rel="stylesheet">
</head>
<body>
	<div>
		<jsp:include page="header.jsp"/>
		<form action="fazer_login" method="post">
			<label>Usuario:</label>
			<input type="text" name="username" id="username"/> <br/>
			
			<label>Senha:</label>
			<input type="password" name="password" id="password"/> <br/>
			
			<input type="submit" value="Logar"/>
		</form>
	</div>
	<script src="res/js/jquery.min.js"></script>
    <script src="res/js/bootstrap.min.js"></script>
</body>
</html>