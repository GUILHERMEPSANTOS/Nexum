import Button from "../../buttons/button";
import Cards from "../../cards/cards";
import Text from "../../text/text";
import Title from "../../title/title";
import Banner from "../banner";
import styles from "./styles.module.scss";

const BannerRanking = () => {
  return (
    <Banner>
      <section className={styles.container}>
        <Title text="Alguns dos Freelancers mais bem avaliados" />
        <Cards />
        <Text text="Entre agora mesmo e encontre o Profissional perfeito para o seu projeto" />
        <div className={styles.buttons}>
          <Button link="/cadastro" text="Faça seu cadastro" />
        </div>
      </section>
    </Banner>
  );
};

export default BannerRanking;
