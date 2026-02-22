<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
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
	
<!-- Mensagem Js -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Mensagem Js -->
	
<link rel="ICON" type="ICON" sizes="16x16"
	href="https://images.icon-icons.com/5/PNG/256/home_243.png">
	
<!-- <link rel="stylesheet" type="text/css" href="./css/styleAlterarSenhaUser.css"> -->
<link rel="stylesheet" type="text/css" href="./CSSTest/styleAlterarSenhaUser.css">
<title>Enviar-E-mail - HOME PAGE</title>
</head>


<body>

	<header>

		<div id="cabecalho">
			<img width="50" height="50"
				src="https://images.icon-icons.com/5/PNG/256/home_243.png"
				alt="casa">
			<h4>Hospedagem ♾️ Home ♾️ Page</h4>

			<a
				href="http://localhost:8080/Home_acomodacao/Home_acomo_Servlet?acao=home">
				<button class="btn btn-dark">Home</button>
			</a>
		</div>

	</header>

	<div class="logoCasa">
		<img height="100" width="100"
			src="https://images.icon-icons.com/5/PNG/256/home_243.png" alt="Casa">
	</div>

	<form action="Home_acomo_Servlet" method="post"
		class="needs-validation" novalidate>

		<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
		<div class="row mb-3">
			<div class="col-sm-10">
				<!-- claiton@gmail.com -->
				<input placeholder="exemplo@exemplo.com" type="email"
					name="txtemail" class="form-control" required="required" value=""
					onkeyup="checkEmail(this.value)" id="inputEmail3">
				<div class="invalid-feedback">Campo email obrigatorio.</div>
				<div class="validarEmail">
					<ul>
						<li id="outputArea">Email valído!</li>
					</ul>
				</div>
				<br> <input value="aceito" class="form-check-input"
					type="checkbox" id="gridCheck1" required="required"> <label
					class="form-check-label" for="gridCheck1">Termos e Politica
				</label>
				<div class="invalid-feedback">Termos e Politica obrigatorio.</div>
			</div>
		</div>

		<c:if test="${not empty EmailValido}">
			<!-- Container -->
			<div class="toast-container position-fixed top-0 end-0 p-3">

				<div id="liveToast" class="toast align-items-center text-bg-success border-0" role="alert"
					aria-live="assertive" aria-atomic="true">

					<div class="d-flex">
						<div class="toast-body">✅ ${EmailValido}</div>
						<button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"
							aria-label="Close"></button>
					</div>

				</div>
			</div>
		</c:if>

		<c:if test="${not empty EmailInvalido}">
			<!-- Container -->
			<div class="toast-container position-fixed top-0 end-0 p-3">

				<div id="liveToast" class="toast align-items-center text-bg-danger border-0" role="alert"
					aria-live="assertive" aria-atomic="true">

					<div class="d-flex">
						<div class="toast-body">❌ ${EmailInvalido}</div>
						<button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"
							aria-label="Close"></button>
					</div>

				</div>
			</div>
		</c:if>

		<br>

		<div class="Enviar-email">
			<input type="hidden" name="acao" value="Enviar-email"><br>
			<button type="submit" name="autentica" class="btn btn-primary">Enviar
				E-mail</button>
		</div>

	</form>

	<script type="text/javascript" src="./scriptJs/validaEmail.js"></script>
	<script type="text/javascript" src="./scriptJs/formScript.js"></script>
	<script type="text/javascript" src="./scriptJs/mensagemTemporariaScript.js"></script>

</body>
</html>