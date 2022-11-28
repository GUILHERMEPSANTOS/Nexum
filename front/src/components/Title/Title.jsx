import { useEffect, useMemo, useState } from "react";
import styles from "./styles.module.scss";

const Title = ({ text, isForm }) => {
  const [words, setWords] = useState([]);

  useEffect(() => {
    const setList = text.split(" ");
    setWords(setList);
  }, []);
  const data = localStorage.getItem("name") ? localStorage.getItem("name") : "";
  const dataFormatted = data.replace(/"/g, "");

  return (
    <h1 className={styles.title}>
      {words.map((item) => {
        const color = isForm
          ? "#fff"
          : item == "Nexum" ||
            item == "conexão" ||
            item == "Freelancers" ||
            item == "avaliados" ||
            item == dataFormatted ||
            item == "experiência" ||
            item == "Propostas" ||
            item == "Perfil" ||
            item == "Contato" ||
            item == "Match"
          ? "#7509BD"
          : "#fff";
        return <span style={{ color: `${color}` }}>{item + ` `}</span>;
      })}
    </h1>
  );
};

export default Title;
