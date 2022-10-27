import styles from "./styles.module.scss";
import { ITEMS } from "./Constants";
import Title from "../Title/Title";
import Text from "../Text/Text";

const Info = () => {
  return (
    <div className={styles.wrapper}>
      <section className={styles.background}>
        <img src={`../../assets/icons/logo.png`} alt="Nexum" />
        <hr className={styles.line} />
        {ITEMS.map(({ title, text, icon, number }) => (
          <div className={styles.card}>
            <Text text={title} />
            <Text text={text} isSmall={true} />
            <div className={styles.container}>
              <img src={`../../assets/icons/${icon}.png`} alt={title} />
              <Title text={number} />
            </div>
          </div>
        ))}
      </section>
    </div>
  );
};

export default Info;
