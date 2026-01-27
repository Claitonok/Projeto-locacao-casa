"UTF-8";

// Formatação de foto de perfil
const profilePic = document.getElementById('foto');

profilePic.addEventListener('change', function(event) {
    const file = event.target.files[0];

    var extensoesPermitidas = /(.jpg|.jpeg|.png|.gif)$/i;

    if (extensoesPermitidas.exec(file.name)) {
        const reader = new FileReader();
        reader.onload = function(e) {
            const imgElement = document.getElementById('Foto');
            imgElement.src = e.target.result;
        };
        reader.readAsDataURL(file);
    } else {
        alert('Por favor, selecione um arquivo de imagem válido (JPG, JPEG, PNG, GIF).');
        profilePic.value = '';
    }
});