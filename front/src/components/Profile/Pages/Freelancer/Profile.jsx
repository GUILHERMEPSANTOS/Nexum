import About from "../../About/Profile";
import Degrees from "../../Degrees/Profile";
import Infos from "../../Infos/Infos";
import styles from "./styles.module.scss";

const Freelancer = () => {
  return (
    <section className={styles.container}>
      <About />
      <Infos />
      <Degrees/>
    </section>
  );
};

export default Freelancer;
