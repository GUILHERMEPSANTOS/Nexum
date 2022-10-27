import Title from "src/components/Title/Title";
import styles from "./styles.module.scss";

const Infos = () => (
  <section className={styles.container}>
    <Title text="Análise" />
    <Text text="Informações" />
    <div className={styles.socialMediaContainer}>
      {INFOS.map(({ name, number, rate, date }) => (
        <div className={styles.socialMedia}>
          <Text text={name} />
          <Text text={number} />
          <Text text={rate} />
          <Text text={date} />
        </div>
      ))}
    </div>
  </section>
);

export default Infos;
