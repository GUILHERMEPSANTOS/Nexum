import Banner from "../Banner/Banner";
import Title from "../Title/Title";
import styles from "./styles.module.scss"

const Form = ({ children }) => {
  return (
    <Banner isForm={true}>
      <section className={styles.content}>
      <img src="../../../assets/imgs/company.png" alt="Nexum" />
        <Title isForm={true} text="Nexum criado para você encontrar a conexão perfeita" />
      </section>
      <section className={styles.children}>
        <form>
        {children}
        </form>
        </section>
    </Banner>
  );
};

export default Form;
