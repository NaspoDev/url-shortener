import { FormEvent } from "react";
import "../../css/URLForm.css";

interface Props {
  handleFormSubmit: (event: FormEvent, inputField: HTMLInputElement) => void;
}

function URLForm({ handleFormSubmit }: Props) {
  return (
    <form
      action=""
      className="URLForm"
      onSubmit={(event: FormEvent) => {
        handleFormSubmit(
          event,
          document.getElementById("url-input") as HTMLInputElement
        );
      }}
    >
      <label htmlFor="url-input" className="label is-size-5">
        Long URL
      </label>
      <input
        type="text"
        id="url-input"
        className="input is-size-5"
        placeholder="Enter the url you want to shorten."
      />
      <button className="button is-primary" type="submit">
        Shorten
      </button>
    </form>
  );
}

export default URLForm;
