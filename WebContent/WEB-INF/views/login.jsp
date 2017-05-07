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
	<%@ include file="header_login.jsp" %>
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Login</h3>
		<!-- Formulario de Login -->
		<form action="fazer_login" method="post">
			<div class="row col-md-12">
				<div class="form-group">
					<div class="input-group col-md-4">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
						</div>
						<input type="text" name="username" id="username" class="form-control" maxlength="60" placeholder="Username" required />
					</div>
				</div>
				<div class="form-group">
					<div class="input-group col-md-4">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span>
						</div>
						<input type="password" name="password" id="password" class="form-control" placeholder="Senha" required />
					</div>
				</div>
			</div>
			<div class="row col-md-12">
				<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> Logar
				</button>
			</div>
		</form>
	</div>
	<script src="res/js/jquery.min.js"></script>
    <script src="res/js/bootstrap.min.js"></script>
</body>
</html>