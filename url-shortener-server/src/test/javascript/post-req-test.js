fetch("http://localhost:8080/urls", {
  method: "POST",
  headers: {
    "Content-Type": "application/json",
  },
  body: JSON.stringify({
    originalUrl: "https://whowhowhowhowhow-url.com",
  }),
})
  .then((response) => response.json())
  .then((data) => console.log(data));
