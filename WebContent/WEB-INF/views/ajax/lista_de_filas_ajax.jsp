<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${not empty filas}">
		<div class="table">
			<table class="table table-hover">
				<thead>
					<tr>
						<td>Codigo</td>
						<td>Fila</td>
						<td>Ativa</td>
						<td>Ações</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${filas}" var="fila">
						<tr>
							<td>${fila.id}</td>
							<td>${fila.nome}</td>
							<td><c:choose>
									<c:when test="${fila.ativa}">
										<span>Sim</span>
									</c:when>
									<c:otherwise>
										<span>Não</span>
									</c:otherwise>
								</c:choose></td>
							<td>
								<c:if test="${fila.ativa }">
								<button id="btn${fila.id}" type="button"
									class="btn btn-danger btn-xs" data-toggle="modal"
									data-target="#delete-modal" data-fila="${fila.id}">Desativar</button>
								</c:if>	
								<c:if test="${fila.ativa == false }">
								<button id="btn${fila.id}" type="button"
									class="btn btn-danger btn-xs" data-toggle="modal"
									data-target="#delete-modal" data-fila="${fila.id}">Ativar</button>
								</c:if>	
								
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:when>
	<c:otherwise>
		<div class="row col-md-12">
			<label>Fila de atendimento não encontrada</label>
		</div>
	</c:otherwise>
</c:choose>