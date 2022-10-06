import styles from "./styles.module.scss";

const Banner = ({ isMain, children, isForm }) => {
  return (
    <section
      className={
        isMain
          ? styles.backgroundMain
          : isForm
          ? styles.backgroundForm
          : styles.background
      }
    >
      <div className={styles.container}>{children}</div>
    </section>
  );
};

export default Banner;
