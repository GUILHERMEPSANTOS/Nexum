import styles from "./styles.module.scss";

const Banner = ({ main, children }) => {
  return (
    <section className={main ? styles.backgroundMain : styles.background}>
      <div className={styles.container}>{children}</div>
    </section>
  );
};

export default Banner;
