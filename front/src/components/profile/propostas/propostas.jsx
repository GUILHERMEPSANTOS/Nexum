import Banner from "../../banner/banner";
import { TEXTS_FREELANCER, OPTIONS } from "./constants";
import Title from "../../title/title";
import CardMain from "../cardTelaInicio/card";
import styles from "./styles.module.scss";
import Header from "../../header/header";

const Propostas = () => {
  const data = localStorage.getItem("name") ? localStorage.getItem("name") : "";
  const dataFormatted = data.replace(/"/g, "");

  const nameCompany = localStorage.getItem("nameCompany");
  const nameCompanyFormatted = nameCompany?.replace(/"/g, "");
  return (
    <div className={styles.container}>
      <Header options={OPTIONS} buttonText="Sair" link="/" />
      <Banner>
        <div className={styles.mensagem}>
          <Title text={` Parabéns ${dataFormatted} , você fez um Match`} />
        </div>
        <div className={styles.containerCards}>
          {TEXTS_FREELANCER.map(({ title, text, link }) => (
            <div> 
            <a href={link} target="_blank"> 
            <CardMain title={title} text={text} />
            </a>
            </div>
          ))}
      </div>
        
      </Banner>
    </div>
  );
};

export default Propostas;
