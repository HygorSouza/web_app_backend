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
		<form action="atualizar_chamado">

			<input type="hidden" name="id" id="id" value="${chamado.id}">
			<div class="row col-md-12">


				<div class="form-group">
					<div class="input-group col-md-8">
						<div class="input-group-addon">
							<span>Titulo:</span>
						</div>
						<input type=text disabled="disabled"
							value="${chamado.breveDescricao}" />
					</div>
				</div>
				<div class="form-group">
					<div class="input-group col-md-4">
						<div class="input-group-addon">
							<span>Descrição:</span>
						</div>
						<input type=text disabled="disabled" value="${chamado.descricao}" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group col-md-4">
					<div class="input-group-addon">
						<span>Status:</span>
					</div>

					<input type=text disabled="disabled" value="${chamado.status}" />
				</div>
			</div>
			<c:choose>
				<c:when test="${not empty chamado.dataDeAbertura}">
					<div class="form-group">
						<div class="input-group col-md-4">
							<div class="input-group-addon">
								<span>Data De Abertura:</span>
							</div>

							<input type=text disabled="disabled"
								value="<fmt:formatDate value="${chamado.dataDeAbertura.time}"
												pattern="dd-MM-yyyy HH:mm:ss" />" />
						</div>
					</div>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${not empty chamado.dataDeFechamento}">
					<div class="form-group">
						<div class="input-group col-md-4">
							<div class="input-group-addon">
								<span>Data De Fechamento:</span>
							</div>
							<input type=text disabled="disabled"
								value="<fmt:formatDate value="${chamado.dataDeFechamento.time}"
												pattern="dd-MM-yyyy HH:mm:ss" />" />
						</div>
					</div>
				</c:when>
			</c:choose>
			<div class="form-group">
				<div class="input-group col-md-4">
					<div class="input-group-addon">
						<span>Fila:</span>
					</div>
					<input type=text disabled="disabled" value="${chamado.fila.nome}" />
				</div>
			</div>
			<c:choose>
				<c:when test="${usuario_logado.tipo == 1}">
					<div class="form-group">
						<div class="input-group col-md-4">
							<div class="input-group-addon">
								<span>Mudar Status:</span>
							</div>
							<select name="statusChamado" class="form-control" id="sel1">
								<c:forEach var="status" items="${listaStatus}">
									<option value="${status}">${status}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group">
						<input type="submit" class="btn btn-primary" />
					</div>
				</c:when>
			</c:choose>
		</form>
	</div>
</body>
</html>
