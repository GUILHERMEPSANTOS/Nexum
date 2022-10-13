import Button from "../../Buttons/Button";
import Title from "../../Title/Title";
import Text from "../../Text/Text";

import styles from "./styles.module.scss";
import { useCallback, useEffect, useState } from "react";
import { APICadastro } from "../../../services";

const Cadastro = () => {
  const [user, setUser] = useState();
  const [cpf, setCpf] = useState();
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const [confirmPassword, setConfirmPassword] = useState();
  const [passwordType, setPasswordType] = useState("password");
  const [type, setType] = useState("password");

  const handleSubmit = useCallback(() => {
    APILogin({ email, senha: password, nome: user, cpf });
  }, [email, password, user, cpf]);

  return (
    <section className={styles.container}>
      <Title text="Crie uma conta" />
      <Text text="Realize o cadastro para se conectar" />
        <div className={styles.content}>
          <label className={styles.labels}>Usuário</label>
          <input
            value={user}
            onChange={({ target }) => setUser(target.value)}
          />
          <label className={styles.labels}>CPF</label>
          <input
            value={cpf}
            onChange={({ target }) => setCpf(target.value)}
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
          <Button onClick={handleSubmit} text="Entrar" />
          <Button link="/login" isEmpty={true} text="Já possui uma conta?" />
        </div>
    </section>
  );
};

export default Cadastro;
