//NESSA FUNC VERIFICA SE AS DUAS SENHAS SÃO IGUAIS,
//ANTES DE AUTORIZAR O ENVIO DO FORMULARIO!!!


function validarSenha() {
    const senha = document.getElementById("pswrd").value;
    const confirmar = document.getElementById("confirmarSenha").value;

    if (senha !== confirmar) {
        const toastEl = document.getElementById('toastErro');
        const toast = new bootstrap.Toast(toastEl, {
            delay: 3000
        });
        toast.show();
        return false;
    }

    return true;
}