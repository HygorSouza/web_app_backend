<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Criar Usuario</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="res/css/bootstrap.min.css" rel="stylesheet" />
<link href="res/css/style.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container">
		<form id="form" class="form-horizontal" action="criar_usuario"
			method="post" onsubmit="return valida();">

			<div class="row col-md-12">

				<!-- Nome do usuario -->
				<div class="form-group">
					<div class="input-group col-md-8">
						<div class="input-group-addon">
							<span>Nome</span>
						</div>
						<input type="text" name="nome" class="form-control"
							placeholder="Nome" required />
					</div>


				</div>

				<!-- cpf do usuario -->
				<div class="form-group">
					<div class="input-group col-md-4">
						<div class="input-group-addon">
							<span>Cpf</span>
						</div>
						<input type="text" name="cpf" class="form-control"
							placeholder="Cpf" required />
					</div>
				</div>

			</div>

			<div class="row col-md-12">
				<!-- cargo do usuario -->
				<div class="form-group">
					<div class="input-group col-md-6">
						<div class="input-group-addon">
							<span>Cargo</span>
						</div>

						<select name="cargo" class="form-control" id="sel1">
							<option>Atendente</option>
							<option>Recepcionista</option>
						</select>
					</div>
				</div>

				<!-- username  -->
				<div class="form-group">
					<div class="input-group col-md-8">
						<div class="input-group-addon">
							<span>Username</span>
						</div>
						<input type="text" name="username" class="form-control"
							placeholder="UserName" required />
					</div>
				</div>

				<!-- senha -->
				<div class="form-group">
					<div class="input-group col-md-6">
						<div class="input-group-addon">
							<span>Senha</span>
						</div>
						<input type="password" name="password" id="password"
							class="form-control" placeholder="Senha" required />
					</div>
				</div>



				<!-- Confirmar senha: -->
				<div class="form-group">
					<div class="input-group col-md-6">
						<div class="input-group-addon">
							<span>Confirmar senha</span>
						</div>
						<input type="password" id="password2" class="form-control"
							placeholder="Confirmar senha" required />
					</div>
				</div>

				<div class="form-group">
					<div class="input-group col-md-6">
						<div class="input-group-addon">
							<span>Tipo do Usuario</span>
						</div>
						
  <input type="radio" name="tipo" id="tipo" value="0">
  <label for="tipo">Solicitante </label>

  <input type="radio" name="tipo" id="tipo" value="1">
  <label for="tipo">Solucionador</label>


					</div>
				</div>

				<!-- btn submit -->
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="Cadastrar" />
					<input type="reset" class="btn btn-default" value="Cancelar" />
				</div>

			</div>
		</form>
	</div>
	<!--  library jQuery  -->
	<script src="res/js/jquery.min.js"></script>
	<script src="res/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {

		});
		function valida() {

			var pws = $("#password").val();
			var pws2 = $("#password2").val();
			if (pws != pws2) {
				alert("Senha informada não está compativel")
				return false;
			}
			return true;
		}
	</script>
</body>
</html>