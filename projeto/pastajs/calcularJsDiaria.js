"UTF-8";

// Seleciona o elemento de input pelo ID
const inputCPF = document.getElementById('cpfInput');

	// Adiciona um ouvinte de evento 'input' que chama a função de formatação sempre que o usuário digita
	inputCPF.addEventListener('input', function (e) {
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

function calcular() {
    const valorDiaria = Number(document.getElementById('valor').value);
    const inputResultado = document.getElementById('resultado');

    // Calcular o total com base no valor da diária e quantidade de dias
    const dataInicio = new Date(document.getElementById('DataInicio').value);
    const dataFim = new Date(document.getElementById('DataFinal').value);



    if (dataFim <= dataInicio) {
        // alert('Por favor, insira datas válidas.');
        document.getElementById('formatacaoInput').innerText = 'A data final deve ser posterior à data de início.';
        return;
    } else {
        document.getElementById('formatacaoInput').innerText = '';
    }

    // Calcula a diferença em milissegundos
    const dayInicio = dataInicio.getTime();
    const dayFinal = dataFim.getTime();

    // Calcula a diferença em dias
    const timeDiff = Math.abs(dayFinal - dayInicio);
    const diffDays = Math.ceil(timeDiff / (1000 * 60 * 60 * 24));


    let total = parseFloat(valorDiaria * diffDays);

    inputResultado.value = total.toFixed(2);
}

document.getElementById('valor').addEventListener('input', calcular);
document.getElementById('DataInicio').addEventListener('input', calcular);
document.getElementById('DataFinal').addEventListener('input', calcular);

calcular();







/* Aqui funciona apenas no onclick no input ou button */

// function calcular() {
//     const valorDiaria = Number(document.getElementById('valor').value);

//     // Calcular o total com base no valor da diária e quantidade de dias
//     const dataInicio = new Date(document.getElementById('DataInicio').value);
//     const dataFim = new Date(document.getElementById('DataFinal').value);

//     if (isNaN(dataInicio.getTime()) || isNaN(dataFim.getTime()) || dataFim <= dataInicio) {
//         // alert('Por favor, insira datas válidas.');
//         document.getElementById('formatacaoInput').innerText = 'A data final deve ser posterior à data de início.';
//         return;
//     } else {
//         document.getElementById('formatacaoInput').innerText = '';
//     }

//     // Calcula a diferença em milissegundos
//     const dayInicio = dataInicio.getTime();
//     const dayFinal = dataFim.getTime();

//     // Calcula a diferença em dias
//     const timeDiff = Math.abs(dayFinal - dayInicio);
//     const diffDays = Math.ceil(timeDiff / (1000 * 60 * 60 * 24));


//     let total = parseFloat(valorDiaria * diffDays);

//     document.getElementById('resultado').innerText = `R$ ${total.toFixed(2)}`;
//     // document.getElementById('resultado').innerText = `${diffDays}`;
// }


// const calcularBtn = document.getElementById('calcular');


// calcularBtn.addEventListener("click", function (event) {
//     event.preventDefault();

//     const valorDiaria = Number(document.getElementById('valor').value);
//     const dias = Number(document.getElementById('dias').value);

//     // Calcular o total com base no valor da diária e quantidade de dias
//     const dataInicio = new Date(document.getElementById('DataInicio').value);
//     const dataFim = new Date(document.getElementById('DataFinal').value);

//     // Calcula a diferença em milissegundos
//     const dayInicio = dataInicio.getTime();
//     const dayFinal = dataFim.getTime();

//     // Calcula a diferença em dias
//     const timeDiff = Math.abs(dayFinal - dayInicio);
//     const diffDays = Math.ceil(timeDiff / (1000 * 60 * 60 * 24));

//     if (isNaN(dataInicio.getTime()) || isNaN(dataFim.getTime()) || dataFim <= dataInicio) {
//         alert('Por favor, insira datas válidas.');
//         return;
//     }

//     let total = parseFloat(valorDiaria * diffDays);

//     document.getElementById('resultado').innerText = `R$ ${total.toFixed(2)}`;
//     // document.getElementById('resultado').innerText = `${diffDays}`;
// });