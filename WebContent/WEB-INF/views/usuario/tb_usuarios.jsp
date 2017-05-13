<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>

	<c:when test="${not empty usuarios}">
		<div class="row col-md-12">
			<table class="table table-hover">
				<thead>
					<tr>
						<td>Cpf</td>
						<td>Nome</td>
						<td>Cargo</td>
						<td>Ações</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="usuario" items="${usuarios}">
						<tr>
							<td>${usuario.cpf}</td>
							<td>${usuario.nome}</td>
							<td>${usuario.cargo}</td>
							<td>
								<button id="btn${usuario.id}" type="button"
									class="btn btn-danger btn-xs" data-toggle="modal"
									data-target="#delete-modal" data-usuario="${usuario.id}">Excluir</button>

								<a class="btn btn-alert"
								href="<%=request.getContextPath()%>/usuario/atualizar_usuario?id=${usuario.id}">Atualizar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:when>
</c:choose>
