<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>

	<c:when test="${not empty usuarios}">
		<div class="row col-md-12">
			<table class="table table-hover">
				<thead>
					<tr>
						<td class="col-xs-2 col-sm-2 col-md-2 col-lg-1">Cpf</td>
						<td class="col-xs-2 col-sm-2 col-md-2 col-lg-1">Nome</td>
						<td class="col-xs-2 col-sm-2 col-md-2 col-lg-1">Cargo</td>
						<td class="col-xs-2 col-sm-2 col-md-2 col-lg-1">Tipo</td>
						<td class="col-xs-2 col-sm-2 col-md-2 col-lg-1">UserName</td>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="usuario" items="${usuarios}">
						<tr>
							<td>${usuario.cpf}</td>
							<td>${usuario.nome}</td>
							<td>${usuario.cargo}</td>
							<td> <c:if test="${usuario.tipo == 1}">
								Solucionador
								</c:if><c:if test="${usuario.tipo == 0}">
								Solicitante
								</c:if>
							<td> ${usuario.username} </td>
							<td class="col-xs-1 "> 
							<button id="btn${usuario.id}" type="button"
									class="btn btn-danger btn-xs" data-toggle="modal"
									data-target="#delete-modal" data-usuario="${usuario.id}">
									<c:if test="${usuario.ativo == 1}">
									Desativar
								</c:if><c:if test="${usuario.ativo == 0}">
									Ativar
								</c:if>
								</button>
								<a class="btn btn-alert"
								href="listar_chamadoUsuario?id=${usuario.id}">Chamados</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:when>
	
	<c:otherwise>
		<div class="row col-md-12">
			<label>Usuario não encontrado !</label>
		</div>
	</c:otherwise>
</c:choose>