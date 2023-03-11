import Banner from "../../banner/banner";
import { TEXTS_FREELANCER, TEXTS_CONTRATANTE } from "./constants";
import Title from "../../title/title";
import CardMain from "../cardTelaInicio/card";
import styles from "./styles.module.scss";
import { useEffect, useState } from "react";

const InicioMain = () => {
  const data = localStorage.getItem("name") ? localStorage.getItem("name") : "";
  const dataFormatted = data.replace(/"/g, "");
  const [dataItems, setDataItems] = useState(TEXTS_FREELANCER);

  const perfil = localStorage.getItem("role");

  useEffect(() => {
    perfil == `"ROLE_FREELANCER"`
      ? setDataItems(TEXTS_FREELANCER)
      : setDataItems(TEXTS_CONTRATANTE);
  }, []);
  return (
    <Banner>
      <div className={styles.mensagem}>
        <Title
          text={` Olá ${dataFormatted} , te desejamos uma ótima expêriencia`}
        />
      </div>
      <div className={styles.containerCards}>
        {dataItems.map(({ title, text, link }) => (
          <CardMain link={link} title={title} text={text} />
        ))}
      </div>
    </Banner>
  );
};

export default InicioMain;
