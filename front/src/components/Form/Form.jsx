import { Link } from "react-router-dom";
import Banner from "../Banner/Banner";
import Text from "../Text/Text";
import Cadastro from "./Cadastro/Cadastro";
import Login from "./Login/Login";
import styles from "./styles.module.scss";

const Form = () => {
  let Page;
  const { pathname } = window.location;
  switch (pathname) {
    case "/cadastro":
      Page = Cadastro;
      break;
    default:
      Page = Login;
  }

  return (
    <Banner isForm={true}>
      <section className={styles.wrapper}>
        <Link to="/">
          <img
            className={styles.home}
            src="../../../assets/icons/arrow.svg"
            alt="voltar para Home"
          />
        </Link>
        <section className={styles.content}>
          <img src="../../../assets/imgs/company.png" alt="Nexum" />
          <Text text="Nexum criado para você encontrar a conexão perfeita" />
        </section>
        <section className={styles.children}>
          <Page />
        </section>
      </section>
    </Banner>
  );
};

export default Form;
