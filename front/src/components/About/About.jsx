import Title from "../title/title";
import Text from "../text/text";
import Button from "../buttons/button";
import styles from "./styles.module.scss";

const AboutMain = () => {
  return (
    <section className={styles.wrapper}>
      <section className={styles.container}>
          <img src="../../../assets/imgs/logo.png" alt="Logo" />
        <hr className={styles.hr} />
        <div className={styles.describe} >
          <Title text="Sobre a Nexum" />
          <Text text="A Nexum nasce com o propósito de facilitar a vida do freelancer assim como do empregador de forma onde o empregador é quem buscar o freelancer e não o contrário, isso possibilita que o empregador só entre em contato com o colaborador se de fato houver o interesse por seus trabalhos" />

          <div className={styles.buttons}>
            <Button text="Descubra mais sobre nós" />
          </div>
        </div>
      </section>
      </section>
    
  );
};

export default AboutMain;
