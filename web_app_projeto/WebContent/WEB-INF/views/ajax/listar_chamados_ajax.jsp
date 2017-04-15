<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:choose>
	<c:when test="${not empty listaChamado}">
		<div class="container">
			<table class="table table-responsive">
				<thead>
					<tr >
						<td>breve Descricao</td>
						<td>descricao</td>
						<td>status</td>
						<td>dataDeAbertura</td>
						<td>dataDeFechamento</td>
						<td> # </td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaChamado}" var="chamado">
						<tr class="filters">
							
							<td>${chamado.breveDescricao}</td>
							<td>${chamado.descricao}</td>
							<td>${chamado.status}</td>
							<td>
								<c:choose> 
									<c:when test="${not empty chamado.dataDeAbertura}">
										<fmt:formatDate value="${chamado.dataDeAbertura.time}" pattern="dd-MM-yyyy HH:mm:ss" />
									</c:when>
								</c:choose>
							</td>
							<td>
								<c:choose> 
									<c:when test="${not empty chamado.dataDeFechamento}">
										<fmt:formatDate value="${chamado.dataDeFechamento.time}" pattern="dd-MM-yyyy HH:mm:ss" />
									</c:when>
									<c:otherwise>
										Chamado sem data de fechamento
									</c:otherwise>
								</c:choose>
							</td>
							
							<td>
							<!-- Button trigger modal -->
<a class="btn btn-alert" href="#" data-toggle="modal" data-target="#myModal">

</a>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
   Id:     ${chamado.id}
   Titulo: ${chamado.breveDescricao}
   Status: ${chamado.status}
   Data de abertura: ${dataDeAbertura}
   Data de Fechamento: ${dataDeFechamento}
   
   
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
							
							</td>
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
