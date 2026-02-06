const time = document.getElementById("time");
const date = document.getElementById("date");
const body = document.body;

function updateClock() {
  const now = new Date();

  time.style.transform = "scale(1.05)";
  time.style.opacity = "0.7";

  setTimeout(() => {
    time.innerText = now.toLocaleTimeString("en-US", {
      hour12: true
    });

    date.innerText = now.toLocaleDateString("pt-BR", {
      weekday: "long",
      day: "2-digit",
      month: "long",
      year: "numeric"
    });

    time.style.transform = "scale(1)";
    time.style.opacity = "1";
  }, 100);
}

setInterval(updateClock, 1000);
updateClock();



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







// const time = document.getElementById("time");

// function updateClock() {
//     const now = new Date();
//     time.innerText = now.toLocaleTimeString("en-US", {
//         hour12: true
//     });
// }

// setInterval(updateClock, 1000);
// updateClock();
