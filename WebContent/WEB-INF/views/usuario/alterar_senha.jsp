<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Abrir Chamado</title>
<myTag:style />
</head>
<body>
	<myTag:menu url="../" />
	
	<div class="container">
		<form action="<%=request.getContextPath()%>/usuario/alterar_usuario"  method="post">
			<input type="hidden" value="${usuario.id}" name="id" id="id" />
			
			<label>Nome:</label>
			<input type="text" value="${usuario.nome}" name="nome" id="nome"/> <br/>
			
			<label>Cargo:</label>
			<select name="cargo" id="cargo">
				<option>Recepcionista</option>
				<option>Atendente</option>
			</select> 
			<br/>
			
			
			<label>Status</label>
			<c:choose>
				<c:when test="${usuario.ativo == 1}">
					<input type="checkbox" name="ativo" id="ativo" placeholder="O usuario pode utilizar o sistema ?" checked="checked" />
				</c:when>
				<c:otherwise>
					<input type="checkbox" name="ativo" id="ativo" placeholder="O usuario pode utilizar o sistema ?"/>
				</c:otherwise>
			</c:choose>
			
			<input type="submit" value="Atualizar" class="btn btn-primary"/>
			<input type="reset" value="Cancelar"  class="btn btn-default" />
		</form>
	</div>
	<!--  library jQuery  -->
	<myTag:script/>
</body>
</html>