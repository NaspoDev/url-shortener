import { FormEvent } from "react";
import "./css/App.css";

function App() {
  return (
    <div className="App has-background-dark">
      <div className="title-area">
        <h1 className="title has-text-primary">URL Shortener</h1>
        <h2 className="subtitle">Shorten any url you want!</h2>
      </div>

      <form action="" className="shortener-form" onSubmit={handleFormSubmit}>
        <label htmlFor="url-input" className="label">
          Long URL
        </label>
        <input
          type="text"
          id="url-input"
          className="input"
          placeholder="Enter the url you want to shorten."
        />
        <button className="button is-primary" type="submit">
          Shorten
        </button>
      </form>
    </div>
  );

  function handleFormSubmit(event: FormEvent): void {
    // Prevent the form from refreshing the page on submit.
    event.preventDefault();

    const inputField = document.getElementById("url-input") as HTMLInputElement;

    // if the input field is empty return.
    if (inputField.value.trim().length == 0) {
      return;
    }

    // TODO: submit url to backend (would i validate url here or in the backend?)
  }
}

export default App;
