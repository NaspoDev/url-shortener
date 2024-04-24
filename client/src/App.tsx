import { Routes, Route } from "react-router-dom";
import Home from "./components/home/Home";
import Redirect from "./components/redirect/Redirect";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/:token" element={<Redirect />} />
      </Routes>
    </>
  );
}

export default App;
