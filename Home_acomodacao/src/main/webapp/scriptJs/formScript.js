
(() => {
  'use strict'

  // Obtenha todos os formulários aos quais deseja aplicar estilos de validação Bootstrap personalizados.
  const forms = document.querySelectorAll('.needs-validation')

  // Passe por cima deles e impeça o envio.
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})();