// Efeito Matrix
const canvas = document.getElementById("matrix");
const ctx = canvas.getContext("2d");

canvas.width = window.innerWidth;
canvas.height = window.innerHeight;

const letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789アカサタナハマヤラワ";
const fontSize = 16;
let columns = Math.floor(canvas.width / fontSize);

let drops = [];
let matrixAtiva = true;
let matrixInterval = null;

function iniciarMatrix() {
    drops = [];
    for (let i = 0; i < columns; i++) {
        drops[i] = Math.random() * canvas.height;
    }

    matrixInterval = setInterval(drawMatrix, 35);
}

function pararMatrix() {
    clearInterval(matrixInterval);
    matrixInterval = null;
    ctx.clearRect(0, 0, canvas.width, canvas.height);
}

function drawMatrix() {
    ctx.fillStyle = "rgba(0, 0, 0, 0.05)";
    ctx.fillRect(0, 0, canvas.width, canvas.height);

    ctx.fillStyle = "#00ff00";
    ctx.font = fontSize + "px monospace";

    for (let i = 0; i < drops.length; i++) {
        const text = letters.charAt(Math.floor(Math.random() * letters.length));
        ctx.fillText(text, i * fontSize, drops[i]);

        drops[i] += fontSize;

        if (drops[i] > canvas.height && Math.random() > 0.975) {
            drops[i] = 0;
        }
    }
}

/* Inicia Matrix */
iniciarMatrix();

/* Tecla M liga/desliga */
document.addEventListener("keydown", (e) => {
    if (e.key.toLowerCase() === "m") {
        matrixAtiva = !matrixAtiva;

        if (matrixAtiva) {
            iniciarMatrix();
            document.getElementById("toggleMatrix").textContent = "[ M ] MATRIX ON";
        } else {
            pararMatrix();
            document.getElementById("toggleMatrix").textContent = "[ M ] MATRIX OFF";
        }
    }
});

const toggleButton = document.getElementById("toggleMatrix");
toggleButton.addEventListener("click", () => {
    matrixAtiva = !matrixAtiva;
    
    if (matrixAtiva) {
        iniciarMatrix();
        toggleButton.textContent = "[ M ] MATRIX ON";
    } else {
        pararMatrix();
        toggleButton.textContent = "[ M ] MATRIX OFF";
    }
});


/* Ajuste de tela */
window.addEventListener("resize", () => {
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;
    columns = Math.floor(canvas.width / fontSize);

    if (matrixAtiva) {
        pararMatrix();
        iniciarMatrix();
    }
});
