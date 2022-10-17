import Button from "../../Buttons/Button";
import Title from "../../Title/Title";
import Text from "../../Text/Text";

import styles from "./styles.module.scss";
import { useCallback, useState } from "react";
import { APICadastro } from "../../../services";
import useCadastro from "./hooks";

const Cadastro = () => {
  const [user, setUser] = useState();
  const [cellphone, setCellphone] = useState();
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const [confirmPassword, setConfirmPassword] = useState();
  const [passwordType, setPasswordType] = useState("password");
  const [type, setType] = useState("password");

  const handleSubmit = useCallback(() => {
    APICadastro({ email, senha: password, nome: user, cellphone });
  }, [email, password, user, cellphone]);

  const { errorEmail, errorPassword, errorUser, errorCellphone, verifyUser } =
    useCadastro({
      email,
      password,
      user,
      cellphone,
    });

  console.log(errorUser);

  return (
    <section className={styles.container}>
      <Title text="Crie uma conta" />
      <Text text="Realize o cadastro para se conectar" />
      <div className={styles.content}>
        <label className={styles.labels}>Usuário</label>
        <input
          placeholder="nome do usuário"
          onBlur={verifyUser}
          value={user}
          onChange={({ target }) => setUser(target.value)}
        />
        <p className={styles.error}>{errorUser}</p>
        <label className={styles.labels}>Celular</label>
        <input
          placeholder="celular"
          value={cellphone}
          onChange={({ target }) => setCellphone(target.value)}
        />
        <p className={styles.error}>{errorCellphone}</p>
        <label className={styles.labels}>E-mail</label>
        <input
          placeholder="email"
          value={email}
          onChange={({ target }) => setEmail(target.value)}
        />
        <p className={styles.error}>{errorEmail}</p>
        <label className={styles.labels}>Senha</label>
        <div className={styles.password}>
          <input
            placeholder="senha"
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
        <p className={styles.error}>{errorPassword}</p>
        <label className={styles.labels}>Confirmar senha</label>
        <div className={styles.password}>
          <input
            placeholder="confirmar senha"
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
        <p className={styles.error}>Eu sou o erro</p>
      </div>

      <div className={styles.buttons}>
        <Button onClick={handleSubmit} text="Entrar" />
        <Button link="/login" isEmpty={true} text="Já possui uma conta?" />
      </div>
    </section>
  );
};

export default Cadastro;
