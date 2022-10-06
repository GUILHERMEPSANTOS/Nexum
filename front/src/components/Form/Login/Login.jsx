import Title from "../../Title/Title";
import Text from "../../Text/Text";
import styles from "./styles.module.scss"
import Button from "../../Buttons/Button";

const Login = () => {
  return (
    <section className={styles.container}>
      <Title text="Seja bem-vindo"/>
      <Text text="Preecha os campos para continuar"/>
      <div className={styles.content}>
      <label className={styles.labels}>Usuário</label>
      <input/>
      <label  className={styles.labels}>Senha</label>
      <input/>
      </div>
      <div className={styles.settings}>
        <div className={styles.remember}>
        <input type="checkbox" /> 
        <label  className={styles.labelSetting}>Lembrar conta</label>
        </div>
        <label className={styles.labels}>Esqueci a senha</label>
      </div>
      <div className={styles.buttons}>
      <Button text="Entrar"/>
      <Button  isEmpty={true} text="Criar conta"/>
      </div>
      </section>
  );
};

export default Login;