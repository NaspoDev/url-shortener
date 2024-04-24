import "../../css/ResultCard.css";

interface Props {
  shortenedUrl: string;
  setSubmitted: React.Dispatch<React.SetStateAction<boolean>>; // a useState setter
}

function ResultCard({ shortenedUrl, setSubmitted }: Props) {
  return (
    <div className="ResultCard">
      <h2 className="heading has-text-white-bis has-text-weight-semibold is-size-5">
        Shortened URL
      </h2>

      <div className="card">
        <div className="card-content">
          {shortenedUrl.length == 0 ? (
            // Display loading
            <div className="loading-container has-text-white-bis is-size-4">
              <p className="loading-text">Loading...</p>
              <span>
                <i className="fa-solid fa-spinner fa-spin"></i>
              </span>
            </div>
          ) : (
            <div className="url-container has-text-white-bis is-size-4">
              <a
                href={"https://" + shortenedUrl}
                target="_blank"
                className="shortened-url has-text-primary"
              >
                {shortenedUrl}
              </a>
              <button className="copy-button button is-primary">Copy</button>
            </div>
          )}
        </div>
      </div>
      <button className="button is-text" onClick={() => setSubmitted(false)}>
        Shorten another url
      </button>
    </div>
  );
}

export default ResultCard;
