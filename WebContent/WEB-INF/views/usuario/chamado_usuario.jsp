<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  tagdir="/WEB-INF/tags"  prefix="myTag"%>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Consultar usuario</title>
	<myTag:style/>
</head>
<body>
	<myTag:menu url="../" />
	<div class="container">
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
	</div>
	<!--  library jQuery  -->
	<myTag:script/>
	</body>
</html>
