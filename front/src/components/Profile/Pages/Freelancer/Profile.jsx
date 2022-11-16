import About from "../../About/Profile";
import Degrees from "../../Degrees/Profile";
import Experience from "../../Experience/Experience";
import Infos from "../../Infos/Infos";
import styles from "./styles.module.scss";

const Freelancer = () => {
  return (
    <section className={styles.container}>
      <About />
      <Infos />
      <Degrees/>
      <Experience/>
    </section>
  );
};

export default Freelancer;
