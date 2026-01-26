"UTF-8";

// Formatação de foto de perfil
const profilePic = document.getElementById('foto');

profilePic.addEventListener('change', function(event) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            const imgElement = document.getElementById('Foto');
            imgElement.src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
});