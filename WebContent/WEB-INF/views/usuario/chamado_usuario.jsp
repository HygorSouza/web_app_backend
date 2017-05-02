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

	
		<div class="row col-md-12">
			<table class="table table-hover">
				<thead>
						<tr>
						
							<td class="col-xs-2 col-sm-2 col-md-2 col-lg-1">Titulo</td>
							<td class="col-xs-2 col-sm-2 col-md-2 col-lg-1">Descricao</td>
							<td class="col-xs-2 col-sm-2 col-md-2 col-lg-1">Status</td>
							
						</tr>
				</thead>
				<tbody>
					 <c:forEach items="${listaSolicitante}" var="listaSolicitante">
						<tr>
							<td>${listaSolicitante.breveDescricao}</td>
							<td>${listaSolicitante.descricao}</td>
							<td>${listaSolicitante.status.status}</td>
							
						</tr>
						</c:forEach>
				</tbody>
			</table>
	</div>
	<!--  library jQuery  -->
	<script src="res/js/jquery.min.js"></script>
	<script src="res/js/bootstrap.min.js"></script>
	</body>
</html>
