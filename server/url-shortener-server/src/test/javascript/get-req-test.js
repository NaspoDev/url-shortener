fetch("http://localhost:8080/urls/X")
  .then((response) => response.json())
  .then((data) => console.log(data.originalUrl));
