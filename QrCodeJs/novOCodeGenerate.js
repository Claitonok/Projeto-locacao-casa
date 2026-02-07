let qr;

function gerarQRCode() {
    const link = document.getElementById("link").value;
    const qrDiv = document.getElementById("qrcode");

    if (!link) {
        alert("Informe um link!");
        return;
    }

    qrDiv.innerHTML = "";
    qrDiv.classList.remove("show");

    qr = new QRCode(qrDiv, {
        text: link,
        width: 250,
        height: 250
    });

    setTimeout(() => {
        qrDiv.classList.add("show");
    }, 100);
}

/* BAIXAR QR */
function baixarQRCode() {
    const img = document.querySelector("#qrcode img");
    const canvas = document.querySelector("#qrcode canvas");

    let url;

    if (img) url = img.src;
    if (canvas) url = canvas.toDataURL("image/png");

    if (!url) {
        alert("Gere o QR Code primeiro!");
        return;
    }

    const a = document.createElement("a");
    a.href = url;
    a.download = "qrcode.png";
    a.click();
}

/* IMPRIMIR */
function imprimirQRCode() {
    const qrDiv = document.getElementById("qrcode");

    if (!qrDiv.innerHTML.trim()) {
        alert("Gere o QR Code primeiro!");
        return;
    }

    window.print();
}

/* DARK MODE */
function toggleDarkMode() {
    document.body.classList.toggle("dark");
}
