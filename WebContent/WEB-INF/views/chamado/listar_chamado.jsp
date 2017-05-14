<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Chamado</title>
<myTag:style />
</head>
<body>
	<myTag:menu url="../" />

	<div class="container">
		<form action="consultar_chamado" method="post">
			<input type="text" id="pesquisa" name="pesquisa"
				placeholder="Pesquisar por titulo ou descrição" /> <input
				type="submit" class="btn btn-primary glyphicon glyphicon-search" />
		</form>

		<form action="pesquisar_fila_status" method="post">
			<div class="row">
				<div class="col-sm-3">

					<c:if test="${usuario_logado.tipo eq 2}">
						<!-- Administrador -->
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
				<c:choose>
					<c:when test="${usuario_logado.tipo != 0}">
						<div class="col-sm-3">
							<label>Status do chamado: </label> <select class="form-control"
								name="status" id="status">
								<c:forEach items="${status}" var="status">
									<option value="${status}">${status.status}</option>
								</c:forEach>
							</select>
						</div>
						<div class="container">
							<button class="btn btn-primary" id="fazerPesquisa">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</c:when>
				</c:choose>
			</div>
		</form>

		<c:choose>
			<c:when test="${usuario_logado.tipo !=0}">
				<form action="pesquisar_data" method="post">
					<div class="container">

						<div class="col-sm-3">
							<label>Data de abertura: </label> <input type="date"
								id="dataAbertura" name="dataAbertura">
						</div>
						<div class="col-sm-3">
							<label>Data de fechamento: </label> <input type="date"
								id="dataFechamento" name="dataFechamento">
						</div>
						<div class="container">
							<button class="btn btn-primary" id="fazerPesquisa">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${not empty listaChamado}">
				<div class="container">
					<table class="table table-responsive">
						<thead>
							<tr>
								<td>Breve Descricao</td>
								<td>Descricao</td>
								<td>Fila</td>
								<td>Status</td>
								<td>Data Abertura</td>
								<td>Data Fechamento</td>
								<td>Horas</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaChamado}" var="chamado">
								<tr class="filters ${chamado.alert()}">

									<td><a href="avaliar_chamado?id=${chamado.id}">
											${chamado.breveDescricao}</a></td>
									<td><a href="avaliar_chamado?id=${chamado.id}">${chamado.descricao}</a></td>
									<td><a href="avaliar_chamado?id=${chamado.id}">${chamado.fila.nome}</a></td>
									<td><a href="avaliar_chamado?id=${chamado.id}">${chamado.status.status}</a></td>
									<td><a href="avaliar_chamado?id=${chamado.id}"> <c:choose>
												<c:when test="${not empty chamado.dataDeAbertura}">
													<fmt:formatDate value="${chamado.dataDeAbertura.time}"
														pattern="dd-MM-yyyy HH:mm:ss" />
												</c:when>
											</c:choose>
									</a></td>
									<td><a href="avaliar_chamado?id=${chamado.id}"> <c:choose>
												<c:when test="${not empty chamado.dataDeFechamento}">
													<fmt:formatDate value="${chamado.dataDeFechamento.time}"
														pattern="dd-MM-yyyy HH:mm:ss" />
												</c:when>
												<c:otherwise>
										Chamado sem data de fechamento
										</c:otherwise>
											</c:choose>
									</a></td>
									<td>${chamado.horas}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</c:when>
			<c:otherwise>
				<div class="row col-md-12">
					<label>Nenhum chamado encontrado</label>
				</div>
			</c:otherwise>
		</c:choose>

	</div>

	<!--  library jQuery  -->
	<myTag:script />
	<script>
		
	</script>
</body>
</html>