<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib  tagdir="/WEB-INF/tags"  prefix="myTag"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Index</title>
	<myTag:style/>
</head>
<body>
	 <myTag:menu url="" />
	

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
	<myTag:script/>
</body>
</html>