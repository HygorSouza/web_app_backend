<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<nav class="navbar shadow-header">
		<div class="container-fluid">
			<div class="navbar-header">
	
 
		<ul class="nav navbar-nav navbar-right">
 				<li><a href="#">Bem vindo ${usuario_logado.nome}</a></li>
 		</ul>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
				
					<li><a href="<%=request.getContextPath()%>/novo_chamado">Novo Chamado</a></li>
					<li><a href="<%=request.getContextPath()%>/listar_chamado">Listar Chamado</a></li>
					
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> Configurações <span
							class="glyphicon glyphicon-chevron-down"></span></a>
							<ul class="dropdown-menu">
							<li><a href="<%=request.getContextPath()%>/atualizar_dados">  Meus Dados </a></li>
							<li><a href="<%=request.getContextPath()%>/usuario/editar_senha">  Alterar Senha </a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<%=request.getContextPath()%>/logout">Sair </a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
</header>

<!-- fim nav Barra superior com os menus de navegação -->