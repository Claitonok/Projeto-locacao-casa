"UTF-8";

  /* ===== DATAS ===== */
  
  function validarDatas() {
        const dataInicio = document.getElementById("DataInicio");
        const dataFinal = document.getElementById("DataFinal");

        if (!dataInicio.value || !dataFinal.value) return;

        const inicio = new Date(dataInicio.value);
        const fim = new Date(dataFinal.value);

        if (fim > inicio) {
            setValido(dataFinal, "Datas válidas");
        } else {
            setInvalido(dataFinal, "Data final deve ser maior");
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

    }

    document.getElementById('DataInicio').addEventListener('input', validarDatas);
    document.getElementById('DataFinal').addEventListener('input', validarDatas);

    validarDatas();