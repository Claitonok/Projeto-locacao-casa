<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="ICON" type="ICON" sizes="16x16"
	href="https://images.icon-icons.com/5/PNG/256/home_243.png">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
	crossorigin="anonymous">
<link rel="ICON" type="ICON" sizes="16x16"
	href="https://images.icon-icons.com/5/PNG/256/home_243.png">
<link rel="stylesheet" href="./css/styDadosUsuario.css">
<title>Dados do Usuário</title>
</head>

<!-- ESSE ARQUIVO É PARA ATUALIZAR OS DADOS DO USUÁRIO COM O FORMULÁRIO O "ARQUIVO.JSP" -->

<body>

	<header>

		<div id="cabecalho">
			<img width="50" height="50"
				src="https://images.icon-icons.com/5/PNG/256/home_243.png"
				alt="casa">
			<h4>Hospedagem ♾️ Home ♾️ Page</h4>

			<a
				href="http://localhost:8080/Home_acomodacao/Home_acomo_Servlet?acao=area_de_usuario"><button
					class="btn btn-dark">Área do Usuário</button></a>
		</div>

	</header>

	<div class="container">

		<form action="Home_acomo_Servlet" method="post"
			enctype="multipart/form-data" class="needs-validation" novalidate>
			<f:if test="${not empty dados}">
				<f:forEach var="Dados" items="${dados}">

					<f:if test="${not empty Dados.source}">
						<div class="profile-container">
							<img
								src="${pageContext.request.contextPath}/FOTO_US/${Dados.source}"
								alt="Foto de Perfil" class="profile-pic" name="caminho_da_foto"
								id="Foto">
						</div>
					</f:if>

					<f:if test="${empty Dados.source}">
						<div class="profile-container">
							<img src="./img_usuario/user_icon_143482.svg"
								alt="Foto de Perfil" class="profile-pic" name="caminho_da_foto"
								id="Foto">
						</div>
					</f:if>

					<label for="txtNome" class="col-sm-2 col-form-label">Nome</label>
					<div class="col-auto">
						<input type="hidden" name="txtId" value="${Dados.id}"> <input
							type="text" value="${Dados.nome}" id="txtNome" name="txtNome"
							class="form-control" required>
						<div class="invalid-feedback">Campo nome obrigatorio.</div>
					</div>

					<label for="foto" class="col-sm-2 col-form-label">Foto</label>
					<div class="col-auto">
						<input type="file" name="imagem" id="foto" class="form-control">
					</div>

					<label for="txtEmail" class="col-sm-2 col-form-label">Email</label>
					<div class="col-auto">
						<input placeholder="exemplo@exemplo.com" value="${Dados.email}"
							type="email" id="txtEmail" name="txtEmail" class="form-control"
							required="required">
						<div class="invalid-feedback">Campo email obrigatorio.</div>
					</div>

					<label for="txtPassword" class="col-sm-2 col-form-label">Password</label>
					<div class="col-auto">
						<input type="password" id="txtPassword" value="${Dados.password}"
							class="form-control" name="txtPassword" required="required" readonly="readonly">
						<div class="invalid-feedback">Campo senha obrigatorio.</div>
					</div>

					<div class="col-auto">
						<span id="passwordHelpInline" class="form-text"> Must be
							8-20 characters long. </span>
					</div>


					<label for="txtTelefone" class="col-sm-2 col-form-label">Telefone</label>
					<div class="col-auto">
						<input placeholder="(DD)xxxxx-xxxx" type="tel"
							value="${Dados.telefone}" id="txtTelefone" class="form-control"
							maxlength="15" name="txtTelefone" required="required">
						<div class="invalid-feedback">Campo telefone obrigatorio.</div>
					</div>

					<div class="ButtonAtualizarDados">
						<input type="hidden" name="acao" value="AtualizarDados"><br>
						<button type="submit" name="autentica" class="btn btn-dark">Atualizar
							dados</button>
					</div>

				</f:forEach>
			</f:if>
		</form>
		
	</div>

	<script type="text/javascript" src="./scriptJs/formScript.js"></script>
	<script type="text/javascript" src="./scriptJs/formataTelefone.js"></script>
	<script type="text/javascript" src="./scriptJs/formataFoto.js"></script>

</body>

</html>