"UTF-8";

	
function calcular() {
	
    const valorDiaria = Number(document.getElementById("Price").value);
    const inputResultado = document.getElementById("resultado");
	
	
//	alert("Valor: " + valorDiaria);

    // Calcular o total com base no valor da diária e quantidade de dias
    const dataInicio = new Date(document.getElementById("DataInicio").value);
    const dataFim = new Date(document.getElementById("DataFinal").value);

    // Calcula a diferença em milissegundos
    const dayInicio = dataInicio.getTime();
    const dayFinal = dataFim.getTime();

    // Calcula a diferença em dias
    const timeDiff = Math.abs(dayFinal - dayInicio);
    const diffDays = Math.ceil(timeDiff / (1000 * 60 * 60 * 24));


    let total = parseFloat(valorDiaria * diffDays);

    inputResultado.value = total.toFixed(2);

    inputResultado.classList.remove("animado");
    void inputResultado.offsetWidth; // reset animação
    inputResultado.classList.add("animado");

}

document.getElementById('valor').addEventListener('input', calcular);
document.getElementById('DataInicio').addEventListener('input', calcular);
document.getElementById('DataFinal').addEventListener('input', calcular);

calcular();

