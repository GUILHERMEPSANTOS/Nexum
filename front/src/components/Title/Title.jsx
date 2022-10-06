import { useEffect, useState } from "react";
import styles from "./styles.module.scss";

const Title = ({ text, isForm }) => {
  const [words, setWords] = useState([]);

  useEffect(() => {
    const setList = text.split(" ");
    setWords(setList);
  }, []);

  return (
    <h1 className={styles.title}>
      {words.map((item) => {
        const color = isForm ? "#fff" :
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
