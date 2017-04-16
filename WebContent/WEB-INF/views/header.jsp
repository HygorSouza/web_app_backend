<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link type="text/css" rel="stylesheet" href="./resource/css/style.css">
<link type="text/css" rel="stylesheet"
	href="./resource/css/bootstrap.min.css">


<header>
	<nav class="navbar shadow-header">
		<div class="container-fluid">
			<div class="navbar-header">

				<a class="navbar-brand" href="index">HelpDesk</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">

					<li><a href="novo_usuario">Novo Usuario</a></li>

					<li><a href="pesquisar_usuario">Pesquisar Usuario</a></li>

					<li><a href="nova_fila">Nova Fila</a></li>

					<li><a href="lista_de_filas">Filas</a></li>

					<li><a href="novo_chamado">Chamado</a></li>
					
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> Configurações <span
							class="glyphicon glyphicon-chevron-down"></span></a>
						<ul class="dropdown-menu">
							<li><a href="minhaConta">Ver meus dados</a></li>
							<li><a href="atualizar_senha">Editar Senha</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="logout">Sair </a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
</header>
<!-- fim nav Barra superior com os menus de navegação -->