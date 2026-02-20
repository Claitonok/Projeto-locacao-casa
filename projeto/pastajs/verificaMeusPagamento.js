"UTF-8";

function validarMeusPagamento(){
	
	const checkboxPix = document.getElementById("checkbox");
	const nCart = document.getElementById("nCart");
	
	if(nCart.value && checkboxPix.checked){
		setInvalido(nCart, "Você deve selecionar apenas uma das formas de pagamento");
		setInvalido(checkboxPix, "Você deve selecionar apenas uma das formas de pagamento");
	}
}

/* ===== FUNÇÕES AUXILIARES ===== */
    function setValido(input, mensagem) {
        limparMensagem(input);
        input.classList.remove("invalido");
        input.classList.add("valido");
        criarMensagem(input, mensagem, "mensagem-ok");
    }

    function setInvalido(input, mensagem) {
        limparMensagem(input);
        input.classList.remove("valido");
        input.classList.add("invalido");
        criarMensagem(input, mensagem, "mensagem-erro");
    }

    function criarMensagem(input, texto, classe) {
        const span = document.createElement("span");
        span.className = classe;
        span.innerText = texto;
        input.parentNode.appendChild(span);
    }

    function limparMensagem(input) {
        const mensagens = input.parentNode.querySelectorAll(".mensagem-erro, .mensagem-ok");
        mensagens.forEach(msg => msg.remove());
    }


document.getElementById('checkbox').addEventListener('input', validarMeusPagamento);
document.getElementById('nCart').addEventListener('input', validarMeusPagamento);

validarMeusPagamento();