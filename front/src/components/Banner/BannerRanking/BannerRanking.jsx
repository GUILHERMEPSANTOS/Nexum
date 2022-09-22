import Button from "../../Buttons/Button";
import Cards from "../../Cards/Cards";
import Text from "../../Text/Text";
import Title from "../../Title/Title";
import Banner from "../Banner";
import styles from "./styles.module.scss";

const BannerRanking = () => {
  return (
    <Banner main={false}>
      <section className={styles.container}>
        <div>
          <Title text="Alguns dos Freelancers mais bem avaliados" />
        </div>

        <Cards />

        <div>
          <Text text="Entre agora mesmo e encontre o Profissional perfeito para o seu projeto" />
        </div>
        <Button text="Entrar" />
      </section>
    </Banner>
  );
};

export default BannerRanking;
