import { FormEvent, useState } from "react";
import "./css/App.css";
import URLForm from "./components/url_form/URLForm";
import ResultCard from "./components/result_display/ResultCard";
import apiUrl from "./api";

function App() {
  const [submitted, setSubmitted] = useState(false);
  const [shortenedUrl, setShortenedUrl] = useState("");
  // Invalid url popup. Used in <URLForm />
  // Activated when the user tries to shorten something that isn't a url.
  const [isAlert, setAlert] = useState(false);

  return (
    <div className="App has-background-dark">
      <div className="title-area">
        <h1 className="title has-text-primary">URL Shortener</h1>
        <h2 className="subtitle">Shorten any url you want!</h2>
      </div>

      {/* If form is not submitted, display the form, otherwise display result */}
      {!submitted ? (
        <URLForm
          handleFormSubmit={handleFormSubmit}
          isAlert={isAlert}
          setAlert={setAlert}
        />
      ) : (
        <ResultCard shortenedUrl={shortenedUrl} setSubmitted={setSubmitted} />
      )}
    </div>
  );

  // prettier-ignore
  async function handleFormSubmit(event: FormEvent, inputField: HTMLInputElement): Promise<void> {
    // Prevent the form from refreshing the page on submit.
    event.preventDefault();

    const inputValue: string = inputField.value;

    // if the input field is empty return.
    if (inputValue.trim().length == 0) {
      return;
    }

    // If its a valid URL, send it to the server.
    if (isValidURL(inputValue)) {
      setSubmitted(true);

      fetch(apiUrl + "/urls", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({originalUrl: inputValue})
      })
      .then(response => response.json())
      .then((data) => setShortenedUrl(data.shortenedUrl));
    } else {
      // if the entry is an invalid url, alert the user.
      setAlert(true);
      // alert("Please enter a valid url!")
    }
  }

  // Checks if the provided value is a valid URL.
  function isValidURL(url: string): boolean {
    try {
      new URL(url);
      return true;
    } catch (error) {
      return false;
    }
  }
}

export default App;
