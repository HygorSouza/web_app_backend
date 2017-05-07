<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag" %>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Filas</title>
	<myTag:style/>
</head>
<body>
	<myTag:menu url="../" />
		
	<%@ include file="modal_excluir_fila.jsp" %>
	
	<div class="container">
		<!-- campo de pesquisa -->
		<form id="pesquisar_filas" action="<%=request.getContextPath()%>/filas/pesquisar_filas" method="post">
				<div class="col-md-6">
					<div class="input-group h2">
						<input type="text" name="param" class="form-control" placeholder="Digite o nome ou nada para listar todas as filas" /> 
						<span class="input-group-btn">
							<button id="btn" class="btn btn-primary"  type="submit" >
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
			</form>
		<!-- Div usada para exibir o dados da fila Obs: Ajax -->
		<div class="row" id="table_fila" class="table">
			<%@ include file="tb_filas.jsp" %>
		</div>
	</div>
	<myTag:script/>
	<script src="<%=request.getContextPath()%>/res/ajax/listar_filas.js"></script>
</body>
</html>