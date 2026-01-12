
let outputArea = document.getElementById("outputArea");

function validaEmail(data){
	
	//Format Email Validation
	
	//Aqui temos uma Expressão regular mais complexa
	// const emailRegex = new RegExp('^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$');
	const emailRegex = new RegExp('^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,}$');

	if(emailRegex.test(data)){
		outputArea.classList.add('valid');
	}else{
		outputArea.classList.remove('valid');
	}
}


