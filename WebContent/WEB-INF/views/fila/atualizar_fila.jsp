<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  tagdir="/WEB-INF/tags"  prefix="myTag"%>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Atualizar Fila</title>
	<myTag:style/>
</head>
<body>
	
	
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
	<myTag:script/>
</body>
</html>