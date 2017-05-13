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

	<%@ include file="modal_excluir_usuario.jsp"%>

	<div class="container">
		<!-- campo de pesquisa -->
		<form id="consultar_usuario" action="<%=request.getContextPath()%>/usuario/consultar_usuario" method="post">

			<div class="col-md-6">
				<div class="form-group">
					<div class="input-group h2">
						<input type="text" name="parametro" class="form-control"
							placeholder="Digite o nome ou cpf" /> <span
							class="input-group-btn">
							<button id="btn" class="btn btn-primary" type="submit">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
			</div>
			
		<!--	<div class="col-sm-1">
				<label>Status:</label>
			</div>
			
			<c:if test="${LoginInterceptor.usuario.getTipo() == 1}">
									<a href="pesquisar_usuario">Pesquisar Usuario</a>
			</c:if>
		  	<div class="col-sm-2">
				<select class="form-control" name="Tipo" id="Tipo">
					<option value="0">Solicitante</option>
					<option value="1">Solucionador</option>
					<option value="2">Todos</option>
				</select>
			</div>
			<div class="col-sm-1">
				<label>Status:</label>
			</div>
			<div class="col-sm-2">
				<select class="form-control" name="Ativo" id="Ativo">
					<option value="0">Inativo</option>
					<option value="1">Ativo</option>
					<option value="2">Todos</option>
				</select>
			</div>
-->
		</form>
		<div id="table_usuario">
			<%@ include file="tb_usuarios.jsp" %>
		</div>

	</div>
	<!--  library jQuery  -->
	<myTag:script/>
	<script>
	$("#delete-modal").on('show.bs.modal', function(event) {
	    var button = $(event.relatedTarget); //botao que disparou a modal
	      var recipient = button.data('usuario');
	   $("#id_excluir").val(recipient);
	});
	</script>
</body>
</html>