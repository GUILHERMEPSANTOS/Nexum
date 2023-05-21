import Button from "../../buttons/button";
import CardBanner from "../../cards/cardsBanner/cardBanner";
import Text from "../../text/text";
import Title from "../../title/title";
import Banner from "../banner";
import styles from "./styles.module.scss";

const BannerMain = () => {
  return (
    <Banner isMain={true}>
      <div className={styles.container}>
        <Title text="Nexum criado para você encontrar a conexão perfeita" />
        <Text text="A Nexum conecta pessoas que buscam crescer no mercado e freelancers que desejam ser vistos pelas suas habilidades" />
        <div>
          <Text upperCase={true} text="crie agora mesmo a sua conta" />
          <div className={styles.buttons}>
            <div>
              <Button link="/cadastro" text="Freelancer" />
            </div>
            <div>
              <Button link="/cadastro" isEmpty={true} text="Contratante" />
            </div>
          </div>
        </div>
      </div>
      <div className={styles.images}>
        <CardBanner />
      </div>
    </Banner>
  );
};

export default BannerMain;
