import Banner from "../../Banner/Banner";
import { TEXTS_FREELANCER, OPTIONS } from "./constants";
import Title from "../../Title/Title";
import CardMain from "../CardTelaInicio/card";
import styles from "./styles.module.scss";
import Header from "../../Header/Header";

const Propostas = () => {
  const data = localStorage.getItem("name") ? localStorage.getItem("name") : "";
  const dataFormatted = data.replace(/"/g, "");

  return (
    <div>
      <Header options={OPTIONS} buttonText="Sair" link="/" />
      <Banner>
        <div className={styles.conteiner}>
          <div className={styles.mensagem}>
            <Title text={` Olá ${dataFormatted} , você tem um Match`} />
          </div>
          <div className={styles.containerCards}>
            {TEXTS_FREELANCER.map(({ title, text, link }) => (
              <CardMain link={link} title={title} text={text} />
            ))}
          </div>
        </div>
      </Banner>
    </div>
  );
};

export default Propostas;
