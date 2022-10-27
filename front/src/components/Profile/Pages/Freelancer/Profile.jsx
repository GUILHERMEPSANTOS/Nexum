import About from "../../About/Profile";
import Infos from "../../Infos/Infos";
import styles from "./styles.module.scss";

const Freelancer = () => {
  return (
    <section className={styles.container}>
      <About />
      <Infos />
    </section>
  );
};

export default Freelancer;
