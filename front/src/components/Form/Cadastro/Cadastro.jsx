import Button from "../../Buttons/Button";
import Title from "../../Title/Title";
import Text from "../../Text/Text";

import styles from "./styles.module.scss";
import { useState } from "react";

const Cadastro = () => {
  const [user, setUser] = useState();
  const [cellphone, setCellphone] = useState();
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const [confirmPassword, setConfirmPassword] = useState();
  const [passwordType, setPasswordType] = useState("password");
  const [type, setType] = useState("password");

  return (
    <section className={styles.container}>
      <Title text="Crie uma conta" />
      <Text text="Realize o cadastro para se conectar" />
      <form method="POST">
        <div className={styles.content}>
          <label className={styles.labels}>Usuário</label>
          <input
            value={user}
            onChange={({ target }) => setUser(target.value)}
          />
          <label className={styles.labels}>Celular</label>
          <input
            value={cellphone}
            onChange={({ target }) => setCellphone(target.value)}
          />
          <label className={styles.labels}>E-mail</label>
          <input
            value={email}
            onChange={({ target }) => setEmail(target.value)}
          />
          <label className={styles.labels}>Senha</label>
          <div className={styles.password}>
            <input
              value={password}
              onChange={({ target }) => setPassword(target.value)}
              type={passwordType}
            />
            <img
              onClick={() =>
                passwordType == "text"
                  ? setPasswordType("password")
                  : setPasswordType("text")
              }
              src={`../../../../assets/icons/${
                passwordType == "text" ? "unsee" : "see"
              }.svg`}
              alt="ver senha"
            />
          </div>
          <label className={styles.labels}>Confirmar senha</label>
          <div className={styles.password}>
            <input
              value={confirmPassword}
              onChange={({ target }) => setConfirmPassword(target.value)}
              type={type}
            />
            <img
              onClick={() =>
                type == "text" ? setType("password") : setType("text")
              }
              src={`../../../../assets/icons/${
                type == "text" ? "unsee" : "see"
              }.svg`}
              alt="ver senha"
            />
          </div>
        </div>
      
      <div className={styles.buttons}>
        <Button type="submit" text="Entrar" />
        <Button link="/login" isEmpty={true} text="Já possui uma conta?" />
      </div>
      </form>
    </section>
  );
};

export default Cadastro;
