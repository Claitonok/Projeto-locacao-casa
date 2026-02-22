"UTF-8";

//Formatação de telefone
const inputTelefone = document.getElementById('txtTelefone');

	inputTelefone.addEventListener('input', function (c){
		let telefone = c.target.value;
		
		// Remove qualquer caractere que não seja dígito
		telefone = telefone.replace(/\D/g, "");
		
		telefone = telefone.replace(/(\d{2})(\d{5})(\d{4})$/, "($1) $2-$3");
		
		c.target.value = telefone;
		
	});