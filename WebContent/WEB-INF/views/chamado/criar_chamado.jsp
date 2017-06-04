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
	
	<input type="hidden" name="id" id="id" value="${chamado.id}">

	<form action="criar_chamado" class="form-horizontal" method="post">

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="txtcodigo_produto_id">Titulo: </label>
			<div class="col-md-4
			">
				<input class="form-control" type="text" name="breveDescricao" required /> 
			</div>
		</div>

		<!-- Select Basic -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="txtgrupo">Fila de
				Atendimento: </label>
			<div class="col-md-4">
				<select class="form-control" name="fila.id">
					<c:forEach items="${filas}" var="fila">
						<option value="${fila.id}">${fila.nome}</option>
					</c:forEach>
				</select>
			</div>
		</div>
	

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" >Descrição:</label>
			<div class="col-md-4">
				<textarea class="form-control" rows="5" name="descricao" required></textarea>

			</div>
		</div>

		
		<!-- Button (Double) -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="btnsalvar"></label>
			<div class="col-md-8">
				<button id="btnsalvar" name="btnsalvar" class="btn btn-primary">Salvar</button>
			</div>
		</div>

	</form>


	<!--  library jQuery  -->
	<myTag:script />
</body>
</html>