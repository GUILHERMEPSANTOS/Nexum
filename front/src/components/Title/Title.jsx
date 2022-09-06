import { useEffect, useState } from "react";
import styles from "./styles.module.scss";

const Title = ({ text }) => {
  const [words, setWords] = useState([]);

  useEffect(() => {
    const teste = text.split(" ");
    setWords(teste);
  }, []);

  return (
    <h1 className={styles.title}>
      {words.map((item) => {
        const color =
          item == "Nexum" ||
          item == "conexão" ||
          item == "Freelancers" ||
          item == "avaliados"
            ? "#7509BD"
            : "#fff";
        return <span style={{ color: `${color}` }}>{item + ` `}</span>;
      })}
    </h1>
  );
};

export default Title;
