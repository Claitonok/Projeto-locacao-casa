"UTF-8";

  /* ===== CODIGO ===== */
const codigo = document.getElementById('txtCodigoPagamento');

codigo.addEventListener('input', function (e) {
    let cc = e.target.value;
    cc = cc.replace(/^[a-z0-9]+$/,"");
    e.target.value = cc;
});

codigo.addEventListener('input', () => {
   
  const codigoTEXT = codigo.value.replace(/^[a-z0-9]+$/,"");

        if (!codigoTEXT.value) return;

        if (codigoTEXT === 10) {
            setValido(codigo, "codigo valido");
        } else {
            setInvalido(codigo, "Opa da uma conferida");
        }

});

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