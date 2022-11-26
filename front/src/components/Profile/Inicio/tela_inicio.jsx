import Banner from "../../Banner/Banner";
import { TEXTS_FREELANCER, TEXTS_CONTRATANTE } from "./constants";
import Title from "../../Title/Title";
import CardMain from "../CardTelaInicio/card";
import styles from "./styles.module.scss";
import { useEffect, useState } from "react";

const InicioMain = () => {
  const data = localStorage.getItem("name") ? localStorage.getItem("name") : "";
  const dataFormatted = data.replace(/"/g, "");
  const [isCompanyProfile, setIsCompanyProfile] = useState(TEXTS_FREELANCER);

  const perfil = localStorage.getItem("role");
  console.log(perfil, "inicio");
  useEffect(() => {
    perfil == "ROLE_FREELANCER"
      ? setIsCompanyProfile(TEXTS_FREELANCER)
      : setIsCompanyProfile(TEXTS_CONTRATANTE);
  }, [perfil]);
  return (
    <div>
      <Banner>
        <div className={styles.conteiner}>
          <div className={styles.mensagem}>
            <Title
              text={` Olá ${dataFormatted} , te desejamos uma ótima expêriencia`}
            />
          </div>
          <div className={styles.containerCards}>
            {isCompanyProfile.map(({ title, text, link }) => (
              <CardMain link={link} title={title} text={text} />
            ))}
          </div>
        </div>
      </Banner>
    </div>
  );
};

export default InicioMain;
