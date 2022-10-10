import Button from "../../Buttons/Button";
import Title from "../../Title/Title";
import Text from "../../Text/Text";

import styles from "./styles.module.scss";
import { useState } from "react";

const Cadastro = () => {
  const [passwordType, setPasswordType] = useState();

  return (
    <section className={styles.container}>
      <Title text="Crie uma conta" />
      <Text text="Realize o cadastro para se conectar" />
      <div className={styles.content}>
        <label className={styles.labels}>Usuário</label>
        <input />
        <label className={styles.labels}>Celular</label>
        <input />
        <label className={styles.labels}>E-mail</label>
        <input />
        <label className={styles.labels}>Senha</label>
        <input type={passwordType} />
        <label className={styles.labels}>Confirmar senha</label>
        <input type={passwordType} />
      </div>
      <div className={styles.buttons}>
        <Button text="Entrar" />
        <Button link="/login" isEmpty={true} text="Já possui uma conta?" />
      </div>
    </section>
  );
};

export default Cadastro;
