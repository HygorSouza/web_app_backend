<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<%@page import="br.usjt.app.servicedesck.model.Usuario"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Atualizar Fila</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link href="res/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="res/css/style.css" rel="stylesheet"/>
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
	
	<div class="container">
		<form action="alterar_fila" method="post">
			<input type="hidden" name="id" value="${fila.id}"/>
			
			<label>Nome:</label>
			<input type="text" name="nome" value="${fila.nome}" disabled /> <br/>
			
			<label>Fila de atendimento pode ser utilizada?</label>
			<c:choose>
				<c:when test="${fila.ativa}">
					<input type="checkbox" name="ativa" checked="checked" />
				</c:when>
				<c:otherwise>
					<input type="checkbox" name="ativa" />
				</c:otherwise>
			</c:choose>
			<br/>
			<input type="submit" value="Atualizar"/>
			<input type="reset" value="Cancelar"/>
		</form>
	</div>
	
	<!--  library jQuery  -->
	<script src="res/js/jquery.min.js"></script>
	<script src="res/js/bootstrap.min.js"></script>
</body>
</html>