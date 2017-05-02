<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Avaliar chamado</title>
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
			<div>
				<form action="atualizar_chamado">
					<input type="text" name="id" id="id" value="${chamado.id}">
					
					Titulo:	<input type=text disabled="disabled" value="${chamado.breveDescricao}"/>				
					Descrição: <input type=text disabled="disabled" value="${chamado.descricao}"/>	
					Status: <input type=text disabled="disabled" value="${chamado.status}"/>	
						<c:choose> 
							<c:when test="${not empty chamado.dataDeAbertura}">
								Data De Abertura: <input type=text disabled="disabled" value="<fmt:formatDate value="${chamado.dataDeAbertura.time}" pattern="dd-MM-yyyy HH:mm:ss" />"/>
							</c:when>
						</c:choose>
						<c:choose> 
							<c:when test="${not empty chamado.dataDeFechamento}">
								Data De Fechamento: <input type=text disabled="disabled" value="<fmt:formatDate value="${chamado.dataDeFechamento.time}" pattern="dd-MM-yyyy HH:mm:ss" />"/>
							</c:when>
						</c:choose>
					Fila: <input type=text disabled="disabled" value="${chamado.fila.nome}"/>	
					
					
						<select name="status" class="form-control" id="sel1">
							<c:forEach var="status" items="${listStatus}">
								<option value="${status}"> ${status.status} </option>
							</c:forEach>
						</select>
					<input type="submit">
					</form>
			</div>						
	</body>
</html>