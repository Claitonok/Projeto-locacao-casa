let is24Hour = true;
let isDark = true;

function updateClock() {
  const now = new Date();

  let hours = now.getHours(); 
  let minutes = now.getMinutes();
  let seconds = now.getSeconds();
  let period = "";

  if (!is24Hour) {
    period = hours >= 12 ? "PM" : "AM"; 
    hours = hours % 12 || 12;
  }

  hours = hours.toString().padStart(2, "0");
  minutes = minutes.toString().padStart(2, "0");
  seconds = seconds.toString().padStart(2, "0");

  document.getElementById("hours").textContent = hours;
  document.getElementById("minutes").textContent = minutes;
  document.getElementById("seconds").textContent = seconds;
  document.getElementById("period").textContent = period;

  updateDate(now);
}

function updateDate(date) {
  document.getElementById("date").textContent =
    date.toLocaleDateString("pt-BR");
}

document.getElementById("toggleFormat").addEventListener("click", () => {
  is24Hour = !is24Hour;
  document.getElementById("toggleFormat").textContent =
    is24Hour ? "Formato 12h" : "Formato 24h";
});

document.getElementById("toggleTheme").addEventListener("click", () => {
  isDark = !isDark;
  document.body.className = isDark ? "dark" : "light";
  // document.body.className = isDark ? "light" : "dark";
  document.getElementById("toggleTheme").textContent =
    isDark ? "☀️ Light" : "🌙 Dark";
    // isDark ? "🌙 Dark" : "☀️ Light";
});

setInterval(updateClock, 1000);
updateClock();
