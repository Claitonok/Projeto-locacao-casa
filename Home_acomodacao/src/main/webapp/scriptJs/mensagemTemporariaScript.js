/**
 * mensagem temporaria do Js Bootstrap!!
 */
document.addEventListener("DOMContentLoaded", () => {
	
  const toastEl = document.getElementById("liveToast");
  
  const toast = new bootstrap.Toast(toastEl, {
    delay: 4000 //4 segundos
  });
  
  toast.show();
});