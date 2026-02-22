"UTF-8";

/* ===== CPF ===== */
const cpfInput = document.getElementById("cpfInput");
const cartaoInput = document.getElementById("nCart");
const cDSeguInput = document.getElementById("cDSeguran");


// Adiciona um ouvinte de evento 'input' que chama a função de formatação sempre que o usuário digita
cpfInput.addEventListener('input', function (e) {
    let valor = e.target.value;

    // Remove qualquer caractere que não seja dígito
    valor = valor.replace(/\D/g, "");

    // Aplica a máscara de CPF: XXX.XXX.XXX-XX
    valor = valor.replace(/(\d{3})(\d)/, "$1.$2");
    valor = valor.replace(/(\d{3})(\d)/, "$1.$2");
        valor = valor.replace(/(\d{3})(\d{1,2})$/, "$1-$2");

    // Atualiza o valor do input com a formatação
    e.target.value = valor;
});

    cpfInput.addEventListener("input", () => {

        cpfInput.addEventListener("input", () => {
        const cpf = cpfInput.value.replace(/\D/g, "");

        if (cpf.length === 11 && validarCPF(cpf)) {
            setValido(cpfInput, "CPF válido");
        } else {
            setInvalido(cpfInput, "CPF inválido");
        }
    });
    });


// Adiciona um ouvinte de evento 'input' que chama a função de formatação sempre que o usuário digita
cartaoInput.addEventListener('input', function (e) {
    let cartao = e.target.value;

    // Remove qualquer caractere que não seja dígito
    cartao = cartao.replace(/\D/g, "");

    // Aplica a máscara de cartão: XXXX XXXX XXXX XXXX
    cartao = cartao.replace(/(\d{4})(\d)/, "$1 $2");
    cartao = cartao.replace(/(\d{4})(\d)/, "$1 $2");
        cartao = cartao.replace(/(\d{4})(\d{1,2})$/, "$1 $2");

    // Atualiza o valor do input com a formatação
    e.target.value = cartao;
});

    /* ===== CARTÃO ===== */
    cartaoInput.addEventListener("input", () => {
        const numero = cartaoInput.value.replace(/\s/g, "");

        if (numero.length >= 16 && numero.length <= 19) {
            setValido(cartaoInput, "Cartão válido");
        } else {
            setInvalido(cartaoInput, "Número do cartão inválido");
        }
    });
	
	
	/*Codigo de Segurança Cartão */
	// Adiciona um ouvinte de evento 'input' que chama a função de formatação sempre que o usuário digita
	cDSeguInput.addEventListener('input', function (e) {
	    let valor = e.target.value;
	    // Remove qualquer caractere que não seja dígito
	    valor = valor.replace(/\D/g, "");
	    // Atualiza o valor do input com a formatação
	    e.target.value = valor;
	});

	  
	    cDSeguInput.addEventListener("input", () => {
	       const cD = cDSeguInput.value.replace(/\D/g, "");

	       if (cD.length === 3 && /^\d+$/.test(cD)) {
	           setValido(cDSeguInput, "Código de segurança válido");
	       } else {
	           setInvalido(cDSeguInput, "Código de segurança inválido");
	       }
	    });
	
	/*Termina aqui o codigo de Segurança Cartão */



/* ===== VALIDAÇÃO CPF REAL ===== */
function validarCPF(cpf) {
    if (/^(\d)\1+$/.test(cpf)) return false;

    let soma = 0;
    for (let i = 0; i < 9; i++) soma += cpf[i] * (10 - i);
    let resto = (soma * 10) % 11;
    if (resto === 10) resto = 0;
    if (resto != cpf[9]) return false;

    soma = 0;
    for (let i = 0; i < 10; i++) soma += cpf[i] * (11 - i);
    resto = (soma * 10) % 11;
    if (resto === 10) resto = 0;

    return resto == cpf[10];
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