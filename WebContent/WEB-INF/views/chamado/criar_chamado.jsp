<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Abrir Chamado</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="res/css/bootstrap.min.css" rel="stylesheet" />
<link href="res/css/style.css" rel="stylesheet" />
</head>
<body>
		<c:if test="${usuario_logado.tipo eq 2}">
			<%@ include file="../header_administrador.jsp"%>
		</c:if>
		<c:if test="${usuario_logado.tipo eq 1}">
			<%@ include file="../header_solucionador.jsp"%>
		</c:if>
		<c:if test="${usuario_logado.tipo eq 0}">
			<%@ include file="../header_solicitante.jsp"%>
		</c:if>

	<div class="container">
		<form action="criar_chamado" method="post">

			<div class="row col-md-12">
				<div class="form-group col-md-4">
					<label>Fila de Atendimento</label> <select class="form-control"
						name="fila.id">
						<c:forEach items="${filas}" var="fila">
							<option value="${fila.id}">${fila.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="row col-md-12">
				<div class="form-group col-md-4">
					<label>Titulo:</label> 
					<input class="form-control" type="text" name="breveDescricao" required /> 
					
					<br /> 
					
					<label>Descrição:</label>
					<textarea class="form-control" name="descricao" required></textarea>
				</div>
			</div>

			<div class="form-group">
				<input class="btn btn-primary" type="submit" value="Abrir Chamado" />
				<input class="btn btn-default" type="reset" value="Cancelar" />
			</div>
		</form>
	</div>

	<!--  library jQuery  -->
	<script src="res/js/jquery.min.js"></script>
	<script src="res/js/bootstrap.min.js"></script>
</body>
</html>