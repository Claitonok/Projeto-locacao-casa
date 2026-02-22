<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css"
	integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- FORMATAR MENSAGEM DO FORM COM JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- TERMINA AQUI O FORMATAR MENSAGEM DO FORM COM JS -->

<link rel="ICON" type="ICON" sizes="16x16"
	href="https://images.icon-icons.com/5/PNG/256/home_243.png">
	
<!-- <link rel="stylesheet" href="./css/paginaValidarEmailUser.css"> -->
<link rel="stylesheet" href="./CSSTest/paginaValidarEmailUser.css">

<title>Recuperar Senha</title>
</head>
<body>
	<div class="logoCasa">
		<img height="100" width="100"
			src="https://images.icon-icons.com/5/PNG/256/home_243.png" alt="Casa">
	</div>

	<form action="Home_acomo_Servlet" method="post" class="needs-validation" novalidate>

		<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
		<div class="row mb-3">
			<div class="col-sm-10">
				<!-- claiton@gmail.com -->
				<input placeholder="exemplo@exemplo.com" type="email"
					name="txtemail" class="form-control" required="required"
					id="inputEmail3">
					<div class="invalid-feedback">Campo E-mail obrigatorio.</div>
			</div>
		</div>

		<label for="pswrd" class="col-sm-2 col-form-label">Password</label>
		<div class="row mb-3">
			<div class=" password-wrapper col-sm-10">
				<input placeholder="Senha" type="password" name="txtsenha"
					class="form-control" value="" onkeyup="checkPassword(this.value)"
					id="pswrd" required="required">
					<i class="fa-solid fa-eye toggle-password" data-target="pswrd"></i>
					<div class="invalid-feedback">Campo senha e obrigatorio.</div>
			</div>

		</div>

		<label for="confirmarSenha" class="col-sm-2 col-form-label">Password</label>
		<div class="row mb-3">
			<div class="password-wrapper col-sm-10">
				<input placeholder="Confirmar senha" type="password"
					name="txtsenha2" class="form-control" value=""
					onkeyup="checkPassword(this.value)" id="confirmarSenha" required="required">
					<i class="fa-solid fa-eye toggle-password" data-target="confirmarSenha"></i>
					<div class="invalid-feedback">Campo senha e obrigatorio.</div>
			</div>

			<!-- LOCAL ONDE E PRINTADO AS MENSAGENS DA VALIDACAO -->
			<div class="validaEmail">
				<ul>
					<li id="lower">Pelo menos um caractere Minusculo</li>
					<li id="upper">Pelo menos um caractere Maiusculo</li>
					<li id="number">Pelo menos um Numero</li>
					<li id="special">Pelo menos um caractere Especial</li>
					<li id="length">Pelo menos 8 Caracteres</li>
				</ul>
			</div>

		</div>

		<div class="Sign-in">
			<input type="hidden" name="acao" value="RecuperarConta"><br>
			<button type="submit" name="autentica" onclick="return validarSenha()" class="btn btn-primary">Cadastra
				senha</button>
		</div>
	</form>
	

		<c:if test="${not empty respostaCconta}">
		
		<!-- Container -->
			<div class="toast-container position-fixed top-0 end-0 p-3">

				<div id="liveToast"
					class="toast align-items-center text-bg-danger border-0"
					role="alert" aria-live="assertive" aria-atomic="true">

					<div class="d-flex">
						<div class="toast-body">❌ Operação não realizada! ${respostaCconta}</div>
						<button type="button"
							class="btn-close btn-close-white me-2 m-auto"
							data-bs-dismiss="toast" aria-label="Close"></button>
					</div>
					
				</div>
			</div>

		</c:if>
		
<div class="toast-container position-fixed top-0 end-0 p-3">
    <div id="toastErro" class="toast align-items-center text-bg-danger border-0" role="alert">
        <div class="d-flex">
            <div class="toast-body">
                ❌ As senhas nao coincidem!
            </div>
            <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"></button>
        </div>
    </div>
</div>

	<script type="text/javascript" src="./scriptJs/formScript.js"></script>
	<script type="text/javascript" src="./scriptJs/validarSenhaJs.js"></script>
	<script type="text/javascript" src="./scriptJs/validetion.js"></script>
	<script type="text/javascript" src="./scriptJs/mensagemTemporariaScript.js"></script>
	<script type="text/javascript" src="./scriptJs/togglePassword.js"></script>
	
</body>
</html>