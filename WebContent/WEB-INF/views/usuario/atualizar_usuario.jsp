<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Atualizar Usuario</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link href="res/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="res/css/style.css" rel="stylesheet"/>
</head>
<body>
	
	<jsp:include page="../header.jsp"/>
	
	<div class="container">
		<form action="alterar_usuario" method="post">
			<input type="hidden" value="${usuario.id}" name="id"/>
			
			<label>Nome:</label>
			<input type="text" value="${usuario.nome}" name="nome"/> <br/>
			
			<label>Cargo:</label>
			<select name="cargo">
				<option>Recepcionista</option>
				<option>Atendente</option>
			</select> 
			<br/>
			
			<label>Tipo de Usuario</label>
			<select >
				<option>Solucionador</option>
				<option>Solicitante</option>
			</select> 
			<br/>
			
			<label>Status</label>
			<label>Status</label>
			<c:choose>
				<c:when test="${usuario.ativo == 1}">
					<input type="checkbox" name="ativo" value="1" placeholder="O usuario pode utilizar o sistema ?" checked="checked" />
				</c:when>
				<c:otherwise>
					<input type="checkbox" name="ativo" value="0" placeholder="O usuario pode utilizar o sistema ?"/>
				</c:otherwise>
			</c:choose>
			
			<input type="submit" value="Atualizar"/>
			<input type="reset" value="Cancelar"/>
		</form>
	</div>
	<!--  library jQuery  -->
	<script src="res/js/jquery.min.js"></script>
    <script src="res/js/bootstrap.min.js"></script>
</body>
</html>