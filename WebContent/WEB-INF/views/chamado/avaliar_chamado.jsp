<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag"%>
<!DOCTYPE html >
<html>
<head>
<title>Avaliar chamado</title>
<myTag:style />
</head>
<body>
	<myTag:menu url="../" />
	<div class="container">
		<div class="row">
			<form class="form-horizontal" action="atualizar_chamado">
				<input type="hidden" name="id" id="id" value="${chamado.id}">
				<div class="form-group">
					<label class="col-md-4 control-label" for="cpf">Código:</label>
					<div class="col-md-6">

						<label class="form-control"> ${chamado.codigo} </label>
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="fullname">Titulo:</label>
					<div class="col-md-6">

						<label class="form-control">${chamado.breveDescricao} </label>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="cpf">Descrição:</label>
					<div class="col-md-6">

						<label class="form-control"> ${chamado.descricao} </label>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="cpf">Status:</label>
					<div class="col-md-6">
						<label class="form-control"> ${chamado.status.status} </label>
					</div>
				</div>

				<c:choose>
					<c:when test="${not empty chamado.dataDeAbertura}">
						<div class="form-group">
							<label class="col-md-4 control-label" for="cpf">Data de
								Abertura:</label>
							<div class="col-md-6">
								<label class="form-control"><fmt:formatDate
										value="${chamado.dataDeAbertura.time}"
										pattern="dd/MM/yyyy HH:mm:ss" /> </label>

							</div>
						</div>
					</c:when>
				</c:choose>

				<c:choose>
					<c:when test="${not empty chamado.dataDeFechamento}">
						<div class="form-group">
							<label class="col-md-4 control-label" for="cpf">Data de
								Fechamento:</label>
							<div class="col-md-6">
								<label class="form-control"><fmt:formatDate
										value="${chamado.dataDeFechamento.time}"
										pattern="dd/MM/yyyy HH:mm:ss" /> </label>

							</div>
						</div>
					</c:when>
				</c:choose>

				<div class="form-group">
					<label class="col-md-4 control-label" for="cpf">Fila:</label>
					<div class="col-md-6">
						<label class="form-control"> ${chamado.fila.nome} </label>
					</div>
				</div>
				<c:choose>
					<c:when test="${usuario_logado.tipo == 1}">
						<c:choose>
							<c:when test="${empty chamado.dataDeFechamento}">


								<div class="form-group">
									<label class="col-md-4 control-label" for="motivoAvaliacao">Motivo
										da Avaliação:</label>
									<div class="col-md-6">
										<textarea class="form-control" name="motivoAvaliacao"
											id="motivoAvaliacao" rows="5" name="descricao" required></textarea>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label" for="statusChamado">Novo
										Status:</label>
									<div class="col-md-6">
										<select name="statusChamado" class="form-control" id="sel1">
											<c:forEach var="status" items="${listaStatus}">
												<option value="${status}">${status.status}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</c:when>
						</c:choose>
					</c:when>
				</c:choose>

				<c:choose>
					<c:when test="${not empty chamado.dataDeFechamento}">


						<div class="form-group">
							<label class="col-md-4 control-label" for="cpf">Nome do
								avaliador:</label>
							<div class="col-md-6">
								<label class="form-control">
									${chamado.solucionador.nome} </label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label" >Motivo da
								Avaliação:</label>
							<div class="col-md-6">
								<textarea class="form-control" rows="5" name="descricao"
									disabled>  ${chamado.motivoAvaliacao}
							</textarea>
							</div>
						</div>

					</c:when>
				</c:choose>

				<c:choose>
					<c:when test="${empty chamado.dataDeFechamento}">
						<!-- Button (Double) -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="btnsalvar"></label>
							<div class="col-md-8">
								<button id="btnsalvar" name="btnsalvar" class="btn btn-primary">Salvar</button>
							</div>
						</div>
					</c:when>
				</c:choose>
			</form>
		</div>
	</div>
	<myTag:script/>
</body>
</html>
