"UTF-8";

document.addEventListener("DOMContentLoaded", () => {
    const checkboxPix = document.getElementById("checkbox");
    const pagamento = document.querySelector(".conteiner-pagamento");

    checkboxPix.addEventListener("change", () => {
        if (checkboxPix.checked) {
            pagamento.classList.add("pix-ativo");
        } else {
            pagamento.classList.remove("pix-ativo");
        }
    });
});