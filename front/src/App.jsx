import HomePage from "./pages/homepage";
import Submit from "./pages/submit";
import "./styles/globais.scss";

function App() {
  const { pathname } = window.location;
  let Page;
  switch (pathname) {
    case "/cadastro":
      Page = Submit;
      break;
    default:
      Page = HomePage;
  }
  return (
    <>
      <Page />
    </>
  );
}

export default App;
