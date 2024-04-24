import { useEffect } from "react";
import { useParams } from "react-router-dom";
import apiUrl from "../../api";

// Responsible for redirecting short url to original url.
function Redirect() {
  const { token } = useParams();

  useEffect(() => {
    redirect();
  }, []);

  // Get the original url from the token, and redirect to it.
  async function redirect(): Promise<void> {
    let originalUrl: string = "";

    await fetch(`${apiUrl}/urls/${token}`)
      .then((response) => response.json())
      .then((data) => (originalUrl = data.originalUrl));

    window.location.href = originalUrl;
  }

  return null;
}

export default Redirect;
