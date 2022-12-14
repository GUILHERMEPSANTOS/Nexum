import Experience from "../../../components/Profile/Experience/Experience";
import About from "../../../components/Profile/About/About";
import Degrees from "../../../components/Profile/Degrees/Degree";
import Infos from "../../../components/Profile/Infos/Infos";
import styles from "./styles.module.scss";
import Formation from "../../../components/Profile/Formation/formation";

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
