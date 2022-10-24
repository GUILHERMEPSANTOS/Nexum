import { useCallback } from "react";

import Title from "../../Title/Title";
import Text from "../../Text/Text";
import styles from "./styles.module.scss";
import Button from "../../Buttons/Button";
import { useState } from "react";
import { APILogin } from "../../../services";

const Login = () => {
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const [type, setType] = useState("password");

  const handleSubmit = useCallback(() => {
    APILogin({ email, senha: password });
  }, [email, password]);

  return (
    <section className={styles.container}>
      <Title text="Seja bem-vindo" />
      <Text text="Preecha os campos para continuar" />

      <div className={styles.content}>
        <label className={styles.labels}>Usuário</label>
        <input
          value={email}
          onChange={({ target }) => setEmail(target.value)}
          
        />
        <label className={styles.labels}>Senha</label>
        <div className={styles.password}>
          <input
            type={type}
            value={password}
            onChange={({ target }) => setPassword(target.value)}
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
      <div className={styles.settings}>
        <div className={styles.remember}>
          <input type="checkbox" />
          <label className={styles.labelSetting}>Lembrar conta</label>
        </div>
        <label className={styles.labels}>Esqueci a senha</label>
      </div>
      <div className={styles.buttons}>
        <Button onClick={handleSubmit} text="Entrar" />
        <Button link={"/cadastro"} isEmpty={true} text="Criar conta" />
      </div>
    </section>
  );
};

export default Login;
