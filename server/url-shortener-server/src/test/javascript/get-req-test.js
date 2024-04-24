fetch("http://localhost:8080/urls/T")
  .then((response) => response.json())
  .then((data) => console.log(data.originalUrl));
