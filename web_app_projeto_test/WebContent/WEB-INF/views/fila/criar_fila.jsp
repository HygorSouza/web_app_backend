<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib  tagdir="/WEB-INF/tags"  prefix="myTag"%>
<!DOCTYPE html >
<html>
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Criar fila</title>
	<myTag:style/>
</head>
<body>
	<myTag:menu url="../"/>
	
	<div class="container">
		<form action="criar_fila" method="post">
			<div class="form-group">
				<div class="input-group col-md-6">
					<div class="input-group-addon">
						<span>Nome da Fila</span>
					</div>
					<input type="text" class="form-control" name="nome" required /> <br />
				</div>
			</div>
			
			<div class="input-group col-md-6">
				<div class="input-group-addon">
						<span>Nivel da SLA</span>
				</div>
					<select class="form-control" name="sla.id" required >
						<c:forEach var="sla" items="${slas}">
							<option value="${sla.id}">${sla.descricao}</option>
						</c:forEach>
					</select> 
				</div>

			<a class="btn btn-default" href="index"> Cancelar</a> <input
				type="submit" class="btn btn-primary" value="Criar" />
		</form>
	</div>
	<!--  library jQuery  -->
	<myTag:script/>
</body>
</html>