import "../../css/ResultCard.css";

interface Props {
  shortenedUrl: string;
  setSubmitted: React.Dispatch<React.SetStateAction<boolean>>; // a useState setter
}

function ResultCard({ shortenedUrl, setSubmitted }: Props) {
  return (
    <div className="ResultDisplay">
      {shortenedUrl.length == 0 ? (
        
        // Display loading
        

      ) : <p>{shortenedUrl}</p>}
    </div>
  );
}

export default ResultCard;
