import "./css/App.css";

function App() {
  return (
    <div className="App has-background-dark">
      <div className="title-area">
        <h1 className="title has-text-primary">URL Shortener</h1>
        <h2 className="subtitle">Shorten any url you want!</h2>
      </div>

      <form action="" className="shortener-form">
        <label htmlFor="url-input" className="label">
          Long URL
        </label>
        <input type="text" id="url-input" className="input" />
        <button className="button is-primary">Shorten</button>
      </form>
    </div>
  );
}

export default App;
