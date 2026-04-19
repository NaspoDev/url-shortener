import { FormEvent } from "react";
import "../../css/URLForm.css";

interface Props {
  handleFormSubmit: (event: FormEvent, inputField: HTMLInputElement) => void;
  isAlert: boolean;
  setAlert: React.Dispatch<React.SetStateAction<boolean>>;
}

function URLForm({ handleFormSubmit, isAlert, setAlert }: Props) {
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

      {/* Display alert instead of form if last input was invalid. */}
      {isAlert ? (
        <div className="invalid-url-alert notification is-warning has-text-weight-bold">
          <button className="delete" onClick={() => setAlert(false)}></button>
          Please enter a valid url!
        </div>
      ) : (
        <input
          type="text"
          id="url-input"
          className="input is-size-5"
          placeholder="Enter the url you want to shorten."
        />
      )}

      <button className="button is-primary" type="submit">
        Shorten
      </button>
    </form>
  );
}

export default URLForm;
