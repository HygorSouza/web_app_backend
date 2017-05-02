<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
		<c:if test="${usuario_logado.tipo eq 2}">
			<%@ include file="header_administrador.jsp"%>
		</c:if>
		<c:if test="${usuario_logado.tipo eq 1}">
			<%@ include file="header_solucionador.jsp"%>
		</c:if>
		<c:if test="${usuario_logado.tipo eq 0}">
			<%@ include file="header_solicitante.jsp"%>
		</c:if>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link href="res/css/bootstrap.min.css" rel="stylesheet" />
<link href="res/css/style.css" rel="stylesheet" />
</head>
<body>
	<div class="jumbotron text-center">
		<h1>Bem Vindo!!!</h1>
		<p>Aproveite o melhor sistema helpdesk que você respeita.</p>
	</div>
 
	

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<h3>Solução</h3>
				<p>Logou</p>
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
					laboris...</p>
			</div>
			<div class="col-sm-4">
				<h3>Sincronia</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
					laboris...</p>
			</div>
			<div class="col-sm-4">
				<h3>Qualidade</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
					laboris...</p>
			</div>
		</div>
	</div>

	<!--  library jQuery  -->
	<script src="res/js/jquery.min.js"></script>
	<script src="res/js/bootstrap.min.js"></script>
</body>
</html>