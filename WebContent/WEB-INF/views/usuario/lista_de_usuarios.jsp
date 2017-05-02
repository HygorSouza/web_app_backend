<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consultar usuario</title>
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

	<%@ include file="modal_excluir_usuario.jsp"%>

	<div class="container">
		<!-- campo de pesquisa -->
		<form id="consultar_usuario" method="post">

			<div class="col-md-6">
				<div class="form-group">
					<div class="input-group h2">
						<input type="text" name="parametro" class="form-control"
							placeholder="Digite o nome ou cpf" /> <span
							class="input-group-btn">
							<button id="btn" class="btn btn-primary" type="submit">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
			</div>
			
			<div class="col-sm-1">
				<label>Status:</label>
			</div>
			
			<c:if test="${LoginInterceptor.usuario.getTipo() == 1}">
									<a href="pesquisar_usuario">Pesquisar Usuario</a>
			</c:if>
			<c:if test="${LoginInterceptor.usuario.getTipo() == 0}">
				<a href="novo_usuario">Novo Usuario</a>
			</c:if>
			<div class="col-sm-2">
				<select class="form-control" name="Tipo" id="Tipo">
					<option value="0">Solicitante</option>
					<option value="1">Solucionador</option>
					<option value="2">Todos</option>
				</select>
			</div>
			<div class="col-sm-1">
				<label>Status:</label>
			</div>
			<div class="col-sm-2">
				<select class="form-control" name="Ativo" id="Ativo">
					<option value="0">Inativo</option>
					<option value="1">Ativo</option>
					<option value="2">Todos</option>
				</select>
			</div>

		</form>
		<div id="table_usuario"></div>

	</div>
	<!--  library jQuery  -->
	<script src="res/js/jquery.min.js"></script>
	<script src="res/js/bootstrap.min.js"></script>
	<script src="res/ajax/listar_usuarios.js"></script>
</body>
</html>