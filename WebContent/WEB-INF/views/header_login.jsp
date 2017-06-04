<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link type="text/css" rel="stylesheet"
	href="./resource/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="./resource/css/header.css">
<link type="text/css" rel="stylesheet" href="./resource/css/style.css">
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet">
</head>

<header>
		<nav class="navbar shadow-header">
			<div class="wrapper col-md-12">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							
							<div class="navbar-header navbar-right">
							
								<ul class="nav navbar-nav ">

									<form action="fazer_login" method="post" class="form-inline">
										<div class="form-group">
											<input type="text" name="username" id="username"
												class="form-control" maxlength="60" autofocus
												placeholder="Username" required />
										</div>
										<div class="form-group">

											<input type="password" name="password" id="password"
												class="form-control" placeholder="Senha" required />
										</div>

										<button class="btn btn-primary">Login</button>
									</form>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</nav>
	</header>
<!-- fim nav Barra superior com os menus de navegação -->