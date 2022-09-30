import styles from "./styles.module.scss";

const Banner = ({ main, children, form }) => {
  return (
    <section
      className={
        main
          ? styles.backgroundMain
          : form
          ? styles.backgroundForm
          : styles.background
      }
    >
      <div className={styles.container}>{children}</div>
    </section>
  );
};

export default Banner;
