<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="h"%>

<!-- Aqui vemos a forma de IMPORTAR uma Class -->
<%@ page import="model.ImagemhopDao"%>
<%@ page import="model.Photos"%>
<%@ page import="controller.Home_acomo_Servlet"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

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
<link rel="ICON" type="ICON" sizes="16x16"
	href="https://images.icon-icons.com/5/PNG/256/home_243.png">
<!-- <link rel="stylesheet" type="text/css" href="./css/pageIndex.css"> -->
<link rel="stylesheet" type="text/css" href="./CSSTest/pagInicio.css">

<!-- ./ImgHospedagem/accommodation1.jpg -->

<title>HOME_PAGE</title>
</head>
<!-- Nome da Empresa Home-Page -->
<body>

	<header>
		<div id="cabecalho">
			<img width="50" height="50"
				src="https://images.icon-icons.com/5/PNG/256/home_243.png"
				alt="casa">
			<h4>Hospedagem ♾️ Home ♾️ Page</h4>

			<h:if test="${not empty resposta.nome}">
				<h4>
					Seja bem-vindo(a): | <span>${resposta.nome}</span>
				</h4>
				<a
					href="http://localhost:8080/Home_acomodacao/Home_acomo_Servlet?acao=logout"><button
						class="btn btn-danger">logout</button></a>
				<a
					href="http://localhost:8080/Home_acomodacao/Home_acomo_Servlet?acao=area_de_usuario"><button
						class="btn btn-info">Área do Usuário</button></a>
						
				<h:if test="${not empty resposta.source}">
					<div class="profile-container">
						<img
							src="${pageContext.request.contextPath}/FOTO_US/${resposta.source}"
							alt="Foto de Perfil" class="profile-pic" name="caminho_da_foto"
							id="Foto">
					</div>
				</h:if>
				<h:if test="${empty resposta.source}">
					<div class="profile-container">
						<img src="./img_usuario/user_icon_143482.svg" alt="Foto temporaria"
							class="profile-pic" name="caminho_da_foto" id="Foto">
					</div>
				</h:if>
			</h:if>
			<h:if test="${empty resposta.nome}">
				<a
					href="http://localhost:8080/Home_acomodacao/Home_acomo_Servlet?acao=logar"
					target="_blank" rel="noopener noreferrer"><button
						class="btn btn-dark">Login-in</button></a>
			</h:if>
		</div>
	</header>

	<main>
		<div class="grid-container">
			<%
			ImagemhopDao imagemhop = new ImagemhopDao();
			List<Photos> listUsers = imagemhop.mostrarTodos();
			for (Photos photo : listUsers) {
				String caminho = "./ImgHospedagem/" + photo.getSource();
			%>
			<div class="item1">
				<a
					href="http://localhost:8080/Home_acomodacao/Home_acomo_Servlet?acao=mostrarAcomo&id=<%=photo.getId()%>"
					target="_blank" rel="noopener noreferrer"> <img
					src="<%=caminho%>" alt="<%=photo.getDescription()%>"></a>
				<div class="valor">
					<p><%=photo.getCity()%></p>
					<label for="valor">Diária</label> <span id="valor">R$: <%=photo.getPrice()%></span>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</main>

	<!-- Nosso rodape -->
	<footer>
		<div class="conteiner_rodape">

			<div>
				<p>
					<b>Atendimento</b>
				</p>
				<p>
					<a href="https://">Central de ajuda</a>
				</p>
				<p>
					<a href="https://">Opções de cancelamento</a>
				</p>
				<p>
					<a href="https://">Apoio à pessoa com deficiência</a>
				</p>
				<p>
					<a href="https://">Reporte um problema no bairro</a>
				</p>
			</div>

			<div>
				<p>
					<b>Hospedagem</b>
				</p>
				<p>
					<a href="https://">Anuncie seu serviço no Hospedagem ♾️ Home ♾️
						Page</a>
				</p>
				<p>
					<a href="https://">Fórum da comunidade</a>
				</p>
				<p>
					<a href="https://">Hospedagem responsável</a>
				</p>
				<p>
					<a href="https://">Participe de uma aula gratuita de hospedagem</a>
				</p>
				<p>
					<a
						href="http://localhost:8080/Home_acomodacao/Home_acomo_Servlet?acao=QrCode"
						target="_blank" rel="noopener noreferrer">Generate QR Code ♾️
						Home ♾️ Page</a>
				</p>

			</div>

			<div>
				<p>
					<b>Hospedagem ♾️ Home ♾️ Page</b>
				</p>
				<p>
					<a href="mailto:claiton_santos1@hotmail.com">E-mail | <svg
							xmlns="http://www.w3.org/2000/svg" width="24" height="24"
							viewBox="0 0 24 24" fill="currentColor"
							class="icon icon-tabler icons-tabler-filled icon-tabler-mail">
                            <path stroke="none" d="M0 0h24v24H0z"
								fill="none" />
                            <path
								d="M22 7.535v9.465a3 3 0 0 1 -2.824 2.995l-.176 .005h-14a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-9.465l9.445 6.297l.116 .066a1 1 0 0 0 .878 0l.116 -.066l9.445 -6.297z" />
                            <path
								d="M19 4c1.08 0 2.027 .57 2.555 1.427l-9.555 6.37l-9.555 -6.37a2.999 2.999 0 0 1 2.354 -1.42l.201 -.007h14z" />
                        </svg>
					</a>
				</p>
				<p>
					<a href="tel:+5513997290816"><svg
							xmlns="http://www.w3.org/2000/svg" width="24" height="24"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="icon icon-tabler icons-tabler-outline icon-tabler-brand-whatsapp">
                            <path stroke="none" d="M0 0h24v24H0z"
								fill="none" />
                            <path
								d="M3 21l1.65 -3.8a9 9 0 1 1 3.4 2.9l-5.05 .9" />
                            <path
								d="M9 10a.5 .5 0 0 0 1 0v-1a.5 .5 0 0 0 -1 0v1a5 5 0 0 0 5 5h1a.5 .5 0 0 0 0 -1h-1a.5 .5 0 0 0 0 1" />
                        </svg> <a href="http://"><svg
								xmlns="http://www.w3.org/2000/svg" width="24" height="24"
								viewBox="0 0 24 24" fill="none" stroke="currentColor"
								stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
								class="icon icon-tabler icons-tabler-outline icon-tabler-brand-facebook">
                                <path stroke="none" d="M0 0h24v24H0z"
									fill="none" />
                                <path
									d="M7 10v4h3v7h4v-7h3l1 -4h-4v-2a1 1 0 0 1 1 -1h3v-4h-3a5 5 0 0 0 -5 5v2h-3" />
                            </svg> <svg xmlns="http://www.w3.org/2000/svg"
								width="24" height="24" viewBox="0 0 24 24" fill="none"
								stroke="currentColor" stroke-width="2" stroke-linecap="round"
								stroke-linejoin="round"
								class="icon icon-tabler icons-tabler-outline icon-tabler-brand-x">
                                <path stroke="none" d="M0 0h24v24H0z"
									fill="none" />
                                <path
									d="M4 4l11.733 16h4.267l-11.733 -16z" />
                                <path
									d="M4 20l6.768 -6.768m2.46 -2.46l6.772 -6.772" />
                            </svg> </a>
				</p>
			</div>

		</div>

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