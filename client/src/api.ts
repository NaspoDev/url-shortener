// api controller

// Use prod api by default.
let apiUrl: string = "https://api.lnk.naspoapps.com";

// If in development mode, use dev api.
if (import.meta.env.MODE == "development") {
  apiUrl = "http://localhost:8080";
}

export default apiUrl;
