<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>

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

<!-- Import Js para criar o QrCode -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/qrcodejs/1.0.0/qrcode.min.js"></script>
<!-- Termina aqui o import Js -->

<link rel="ICON" type="ICON" sizes="16x16"
	href="https://images.icon-icons.com/5/PNG/256/home_243.png">

<!-- <link rel="stylesheet" href="./css/styconferirPaga.css"> -->
<link rel="stylesheet" href="./CSSTest/stylesConferirPaga.css">

<title>Pagamentos</title>
</head>

<body>

	<header>
		<div id="cabecalho">
			<img width="50" height="50"
				src="https://images.icon-icons.com/5/PNG/256/home_243.png"
				alt="casa">
			<h4>Hospedagem ♾️ Home ♾️ Page</h4>
			<a
				href="http://localhost:8080/Home_acomodacao/Home_acomo_Servlet?acao=home"><button
					class="btn btn-danger">Desistir</button></a>
		</div>
	</header>

	<main>
		<section>
			<div class="container text-center">
				<form action="Home_acomo_Servlet" method="post">
					<div class="row">
						<f:forEach var="ListDados" items="${listDados}">
							<div class="col">
								<span>Dados da Acomodação</span>
								<ul>
									<input type="hidden" name="txtId" value="${ListDados.id}">
									<input type="hidden" name="txtEmail" value="${ListDados.email}">

									<label for="txtState" class="col-sm-2 col-form-label">Estado</label>
									<div class="row mb-3">
										<div class="col-sm-10">
											<input type="text" name="txtState" placeholder="Estado"
												class="form-control" value="${ListDados.state}"
												id="txtState" readonly>
										</div>
									</div>

									<label for="txtCity" class="col-sm-2 col-form-label">Cidade</label>
									<div class="row mb-3">
										<div class="col-sm-10">
											<input type="text" name="txtCity" placeholder="Cidade"
												class="form-control" value="${ListDados.city}" id="txtCity"
												readonly>
										</div>
									</div>

									<label for="txtDataInicio" class="col-sm-2 col-form-label">Data
										Inicio</label>
									<div class="row mb-3">
										<div class="col-sm-10">
											<input type="date" name="txtDataInicio"
												placeholder="Data Inicio" class="form-control"
												value="${ListDados.dataInicio}" id="txtDataInicio" readonly>
										</div>
									</div>

									<label for="txtDataFinal" class="col-sm-2 col-form-label">Data
										Final</label>
									<div class="row mb-3">
										<div class="col-sm-10">
											<input type="date" name="txtDataFinal"
												placeholder="Data Final" class="form-control"
												value="${ListDados.dataFinal}" id="txtDataFinal" readonly>
										</div>
									</div>

									<label for="txtCheck-in" class="col-sm-2 col-form-label">Check-in</label>
									<div class="row mb-3">
										<div class="col-sm-10">
											<input type="text" name="txtCheck-in" placeholder="Check-in"
												class="form-control" value="${ListDados.checkin}"
												id="txtCheck-in" readonly>
										</div>
									</div>

									<label for="txtCheck-out" class="col-sm-2 col-form-label">Check-out</label>
									<div class="row mb-3">
										<div class="col-sm-10">
											<input type="text" name="txtCheck-out"
												placeholder="Check-out" class="form-control"
												value="${ListDados.checkout}" id="txtCheck-out" readonly>
										</div>
									</div>

									<label for="txtTotal" class="col-sm-2 col-form-label">Total</label>
									<div class="row mb-3">
										<div class="col-sm-10">
											<input type="text" name="txtTotal" placeholder="Total"
												class="form-control" value="${ListDados.total}"
												id="txtTotal" readonly>
										</div>
									</div>

									<hr>
									<label for="txtCancelamento" class="col-sm-2 col-form-label">Cancelamento</label>
									<div class="row mb-3">
										<div class="col-sm-10">
											<input type="text" name="txtCancelamento"
												placeholder="Cancelamento" class="form-control"
												value="${ListDados.cancelamento}" id="txtCancelamento"
												readonly>
										</div>
									</div>
								</ul>
							</div>
						</f:forEach>

						<f:forEach var="ListDados" items="${listDados}">
							<f:if test="${not empty ListDados.cart}">
								<div class="col">
									<span>Informações de Pagamentos</span>
									<ul>

										<label for="txtnome" class="col-sm-2 col-form-label">Nome</label>
										<div class="row mb-3">
											<div class="col-sm-10">
												<input type="text" name="txtnome" placeholder="Nome"
													class="form-control" value="${ListDados.nome}" id="txtnome"
													readonly>
											</div>
										</div>

										<label for="txtcpf" class="col-sm-2 col-form-label">CPF</label>
										<div class="row mb-3">
											<div class="col-sm-10">
												<input type="text" name="txtcpf"
													placeholder="000.000.000-00" class="form-control"
													value="${ListDados.cpf}" id="txtcpf" maxlength="14"
													readonly>
											</div>
										</div>

										<label for="txtnCart" class="col-sm-2 col-form-label">Numero
											do cartão</label>
										<div class="row mb-3">
											<div class="col-sm-10">
												<input type="text" name="txtnCart"
													placeholder="Numero do cartão" class="form-control"
													value="${ListDados.cart}" id="txtnCart" readonly>
											</div>
										</div>

										<label for="txtdataValid" class="col-sm-2 col-form-label">Data
											de validade</label>
										<div class="row mb-3">
											<div class="col-sm-10">
												<input type="date" name="txtdataValid"
													placeholder="Data de validade" class="form-control"
													value="${ListDados.dataValid}" id="txtdataValid" readonly>
											</div>
										</div>

										<label for="txtcDSeguran" class="col-sm-2 col-form-label">CVV</label>
										<div class="row mb-3">
											<div class="col-sm-10">
												<input type="number" name="txtcDSeguran" placeholder="CVV"
													class="form-control" value="${ListDados.cDSeguran}"
													id="txtcDSeguran" readonly>
											</div>
										</div>
										<label for="txtCodigoPagamento"
											class="col-sm-2 col-form-label">Codigo</label>
										<div class="row mb-3">
											<div class="col-sm-10">
												<input type="text" class="form-control"
													id="txtCodigoPagamento" name="txtCodigoPagamento"
													placeholder="Digite o codigo de pagamento" maxlength="10"
													required>
												<div class="invalid-feedback">Campo codigo
													obrigatorio.</div>
											</div>
										</div>

									</ul>
								</div>
							</f:if>

							<f:if test="${empty ListDados.cart}">

								<div class="col">
									<%
									String pix = request.getParameter("txtAceito");
									%>
									<span>Informações de Pagamentos</span>
									<ul>

										<label for="txtnome" class="col-sm-2 col-form-label">Nome</label>
										<div class="row mb-3">
											<div class="col-sm-10">
												<input type="text" name="txtnome" placeholder="Nome"
													class="form-control" value="${ListDados.nome}" id="txtnome"
													readonly>
											</div>
										</div>

										<label for="txtcpf" class="col-sm-2 col-form-label">CPF</label>
										<div class="row mb-3">
											<div class="col-sm-10">
												<input type="text" name="txtcpf"
													placeholder="000.000.000-00" class="form-control"
													value="${ListDados.cpf}" id="txtcpf" maxlength="14"
													readonly>
											</div>
										</div>

										<label for="txtAceito" class="col-sm-2 col-form-label">Pix</label>
										<div class="row mb-3">
											<div class="col-sm-10">
												<input type="text" name="txtAceito"
													placeholder="Pagamento Pix" class="form-control"
													value="<%=pix%>" id="txtAceito" readonly>
											</div>
										</div>

										<label for="txtCodigoPagamento"
											class="col-sm-2 col-form-label">Código</label>
										<div class="row mb-3">
											<div class="col-sm-10">
												<input type="text" class="form-control"
													id="txtCodigoPagamento"
													placeholder="Digite o codigo de pagamento"
													required="required">
											</div>
										</div>

										<label for="QrCodeCliente" class="col-sm-2 col-form-label">Código
											Pix</label>
										<div class="row mb-3">
											<div class="col-sm-10">
												<input type="text" class="form-control" id="QrCodeCliente"
													value="${payloadPix}">
											</div>
										</div>
										<label for="txtCodigoPagamento"
											class="col-sm-2 col-form-label">Codigo</label>
										<div class="row mb-3">
											<div class="col-sm-10">
												<input type="text" class="form-control"
													id="txtCodigoPagamento" name="txtCodigoPagamento"
													placeholder="Digite o codigo de pagamento" maxlength="10"
													required>
												<div class="invalid-feedback">Campo codigo
													obrigatorio.</div>
											</div>
										</div>
										<div id="qrcode"></div>
									</ul>
								</div>
							</f:if>

						</f:forEach>
					</div>

					<f:forEach var="ListDados" items="${listDados}">
						<f:if test="${not empty ListDados.cart}">
							<input type="hidden" name="acao" value="pagar">
							<button type="submit" id="button" class="btn btn-success">Pagar</button>
						</f:if>
					</f:forEach>

					<f:forEach var="ListDados" items="${listDados}">
						<f:if test="${empty ListDados.cart}">
							<input type="hidden" name="acao" value="pagar">
							<button type="submit" id="button" class="btn btn-success">Pagar
								com Pix</button>
						</f:if>
					</f:forEach>

				</form>
			</div>
		</section>
	</main>

	<script type="text/javascript" src="./scriptJs/QrCodeScript.js"></script>
	<script type="text/javascript"
		src="./scriptJs/validaCodigoPagamento.js"></script>
	<footer>
		<div class="footer_inf">
			<p>© 2025 Hospedagem ♾️ Home ♾️ Page, Inc. · Privacidade Termos
				Informações da empresa</p>
			<p>
				<b>Português (BR) R$ BRL</b>
			</p>
		</div>
	</footer>

</body>

</html>