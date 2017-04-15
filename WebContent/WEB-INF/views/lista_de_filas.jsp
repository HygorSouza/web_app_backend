<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Filas</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link href="res/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="res/css/style.css" rel="stylesheet"/>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<%@ include file="modal_excluir_fila.jsp" %>
	
	<div class="container">
		<!-- campo de pesquisa -->
		<form id="pesquisar_filas" method="post">
				<div class="col-md-6">
					<div class="input-group h2">
						<input type="text" name="param" class="form-control" placeholder="Digite o nome ou nada para listar todas as filas" /> 
						<span class="input-group-btn">
							<button id="btn" class="btn btn-primary"  type="submit" >
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
			</form>
		<!-- Div usada para exibir o dados da fila Obs: Ajax -->
		<div id="table_fila" class="table">
		</div>
	</div>
	<script src="res/js/jquery.min.js"></script>
	<script src="res/js/bootstrap.min.js"></script>
	<script src="res/ajax/listar_filas.js"></script>
</body>
</html>