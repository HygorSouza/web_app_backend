<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Chamado</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="res/css/bootstrap.min.css" rel="stylesheet" />
<link href="res/css/style.css" rel="stylesheet" />
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">

</head>
<body>
	<jsp:include page="header.jsp" />
	<form id="consultar_chamado" method="post">
<nav class="navbar navbar-default">
  
	<div class="row">
				<div class="col-sm-1">
					<label >Fila de Atendimento:</label> </div>
					<div class="col-sm-2">
					 <select  class="form-control" name="fila.id" id="fila.id">
					  <c:forEach items="${filas}" var="fila">
							<option value="${fila.id}">${fila.nome}</option>
						</c:forEach>
					</select>
					</div>
				
				<div class="col-sm-1">
					<label>Status do chamado: </label>  </div> <div class="col-sm-2"><select class="form-control"
						name="status" id="status">
						<c:forEach items="${status}" var="status">
							<option value="${status}">${status}</option>
						</c:forEach>
					</select>
			</div>

		<button class="btn btn-primary" id="realizarPesquisa"> <i class="glyphicon glyphicon-search" > </i> </button>
		</div>

		</nav>
					<input type="text" id="pesquisa" name="pesquisa" onclick="Pesquisar()"/>

					<p>Data de abertura: <input type="text" id="dataDeAbertura"></p>
					<p>Data de fechamento: <input type="text" id="dataDeFechamento"></p>
					
	<div id="retorno_ajax">
		
					
	</div>
	
</form>
			<!--  library jQuery  -->
	<script src="res/js/jquery.min.js"></script>
	<script src="res/js/bootstrap.min.js"></script>
	<script src="res/ajax/listar_chamado.js"></script>
	  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	 <script>$( function() {
    $( "#dataDeAbertura" ).datepicker();
  	  } );
	 $( function() {
	    $( "#dataDeFechamento" ).datepicker();
	  } );
	 function Pesquisar() {
		    $("#pesquisa").val('');
		}
	 </script>
</body>
</html>