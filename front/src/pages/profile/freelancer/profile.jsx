import Experience from "../../../components/profile/experience/experience";
import About from "../../../components/profile/about/about";
import Degrees from "../../../components/profile/degrees/degree";
import Infos from "../../../components/profile/infos/infos";
import styles from "./styles.module.scss";
import Formation from "../../../components/profile/formation/formation";

const Freelancer = () => {
  return (
    <section className={styles.container}>
      <About />
      <Infos />
      <Degrees />
      <Experience />
      <Formation />
    </section>
  );
};

export default Freelancer;
