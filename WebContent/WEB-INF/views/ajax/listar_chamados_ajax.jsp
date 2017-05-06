<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:choose>
	<c:when test="${not empty listaChamado}">
		<div class="container">
			<table class="table table-responsive">
				<thead>
					<tr>
						<td>breve Descricao</td>
						<td>descricao</td>
						<td>status</td>
						<td>dataDeAbertura</td>
						<td>dataDeFechamento</td>
						<td>#</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaChamado}" var="chamado">
						<tr class="filters ${chamado.alert}">

							<td><a href="avaliar_chamado?id=${chamado.id}">
									${chamado.breveDescricao}</a></td>
							<td><a href="avaliar_chamado?id=${chamado.id}">${chamado.descricao}</a></td>
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
