import { WORDS } from "./constants";
import watchWords from "./hooks";
import styles from "./styles.module.scss";

const Title = ({ text }) => {
  const { words } = watchWords({ text });

  return (
    <h1 className={styles.container}>
      {words.map((item, i) => {
        const teste = {
          item: "#7509BD",
        };

        const color = teste[item] || "#FFF";

        console.log(teste);
        console.log(color);
        console.log(teste[item]);
        console.log(item);
        return (
          <h1
            key={`word-${i}`}
            className={styles.title}
            style={{ color: `${color}` }}
          >
            {item + ` `}
          </h1>
        );
      })}
    </h1>
  );
};

export default Title;
