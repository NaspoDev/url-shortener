// api controller

// Use prod api by default.
let api: string = "https://api.lnk.naspoapps.com";

// If in development mode, use dev api.
if (import.meta.env.MODE == "development") {
  api = "http://localhost:8080";
}

export default api;
