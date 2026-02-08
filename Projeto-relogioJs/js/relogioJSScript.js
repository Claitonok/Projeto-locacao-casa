const body = document.body;

function atualizarRelogio() {
    const agora = new Date();

    const horas = agora.getHours(); // 0–23 (fica 18)
    const minutos = agora.getMinutes();
    const segundos = agora.getSeconds();

    const ampm = horas >= 12 ? "PM" : "AM";

    const h = String(horas).padStart(2, "0");
    const m = String(minutos).padStart(2, "0");
    const s = String(segundos).padStart(2, "0");

    date.innerText = agora.toLocaleDateString("pt-BR", {
      weekday: "long",
      day: "2-digit",
      month: "long",
      year: "numeric"
    });

    document.getElementById("time").textContent =
        `${h}:${m}:${s} ${ampm}`;
}

setInterval(atualizarRelogio, 1000);
atualizarRelogio();



function setThemeByTime() {
  const hour = new Date().getHours();
  const isLight = hour >= 6 && hour < 18;

  document.body.classList.toggle("light", isLight);
  document.body.classList.toggle("dark", !isLight);
}


function autoTheme() {
  const systemDark = window.matchMedia("(prefers-color-scheme: dark)").matches;
  const hour = new Date().getHours();
  const timeBasedLight = hour >= 6 && hour < 18;

  const useLight = systemDark ? false : timeBasedLight;

  document.body.classList.toggle("light", useLight);
  document.body.classList.toggle("dark", !useLight);
}

autoTheme();
setInterval(autoTheme, 60000);


setThemeByTime();
setInterval(setThemeByTime, 60000);

