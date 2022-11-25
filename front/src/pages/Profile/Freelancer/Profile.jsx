import About from "../../../components/Profile/About/Profile";
import Degrees from "../../../components/Profile/Degrees/Profile";
import Infos from "../../../components/Profile/Infos/Infos";
import styles from "./styles.module.scss";

const Freelancer = () => {
  return (
    <section className={styles.container}>
      <About />
      <Infos />
      <Degrees />
    </section>
  );
};

export default Freelancer;
