<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Chamado</title>
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
			<form id="consultar_chamado" method="post">
				<input type="text" id="pesquisa" name="pesquisa"
					placeholder="Pesquisar por titulo ou descrição" onclick="Pesquisar()" />
				<button class="btn btn-primary" id="realizarPesquisa">
					<i class="glyphicon glyphicon-search"> </i>
				</button>
			</form>
			
			<form id="pesquisar_fila_status" method="post">
				<div class="row">
					<div class="col-sm-2">
					
						<c:if test="${usuario_logado.tipo eq 2 or usuario_logado.tipo eq 0}"><!-- Administrador -->
							<label>Fila de Atendimento:</label>
								<select class="form-control" name="fila.id" id="fila.id">
									<c:forEach items="${filas}" var="fila">
										<option value="${fila.id}">${fila.nome}</option>
									</c:forEach>
								</select>
						</c:if>
						<c:if test="${usuario_logado.tipo eq 1}">
							<!-- Administrador -->
							<label>Minha Fila:</label>
								<select class="form-control" name="fila.id" id="fila.id">
										<option value="${usuario_logado.fila.id }">${usuario_logado.fila.nome}</option>
								</select>
						</c:if>
					</div>
					<div class="col-sm-2">
						<label>Status do chamado: </label> 
						<select class="form-control" name="status" id="status">
							<c:forEach items="${status}" var="status">
								<option value="${status}">${status.status}</option>
							</c:forEach>
						</select>
					</div>
					<button class="btn btn-primary" id="fazerPesquisa">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</form>
			<div id="retorno_ajax"></div>
	</div>

	<!--  library jQuery  -->
	<script src="res/js/jquery.min.js"></script>
	<script src="res/js/bootstrap.min.js"></script>
	<script src="res/ajax/listar_chamado.js"></script>
	<script src="res/ajax/listar_chamado_pelo_status_fila.js"></script>
</body>
</html>