import "../../css/ResultCard.css";

interface Props {
  shortenedUrl: string;
}

function ResultCard({ shortenedUrl }: Props) {
  return (
    <div className="ResultDisplay">
      {shortenedUrl.length == 0 ? <p>Loading...</p> : <p>{shortenedUrl}</p>}
    </div>
  );
}

export default ResultCard;
