import Banner from "../Banner/Banner";
import Text from "../Text/Text";
import Cadastro from "./Cadastro/Cadastro";
import Login from "./Login/Login";
import styles from "./styles.module.scss"

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
