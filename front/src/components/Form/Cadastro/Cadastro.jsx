import Button from "../../buttons/button";
import Title from "../../title/title";
import Text from "../../text/text";

import styles from "./styles.module.scss";
import { useCallback, useState } from "react";
import { APICadastroContratante, APICadastroFreela } from "../../../services";
import useCadastro from "./hooks";

const Cadastro = () => {
  const [user, setUser] = useState();
  const [cellphone, setCellphone] = useState();
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const [confirmPassword, setConfirmPassword] = useState();
  const [passwordType, setPasswordType] = useState("password");
  const [type, setType] = useState("password");
  const [contratante, setContratante] = useState(false);

  const handleSubmit = useCallback(() => {
    if (contratante) {
      APICadastroContratante({
        email,
        senha: password,
        nome: user,
        celular: cellphone,
      });
    } else {
      APICadastroFreela({
        email,
        senha: password,
        nome: user,
        celular: cellphone,
      });
    }
  }, [
    email,
    password,
    user,
    cellphone,
    contratante,
    APICadastroContratante,
    APICadastroFreela,
  ]);

  const {
    errorEmail,
    errorPassword,
    errorProfession,
    errorUser,
    errorCellphone,
    errorConfirmPassword,
    verifyUser,
    verifyEmail,
    verifyCellphone,
    verifyPassword,
    verifyConfirmPassword,
    disabled,
  } = useCadastro({
    email,
    password,
    user,
    cellphone,
    confirmPassword,
  });

  return (
    <section className={styles.container}>
      <Title text="Crie uma conta" />
      <Text text="Realize o cadastro para se conectar" />
      <div className={styles.content}>
        <div className={styles.users}>
          <div>
            <label className={styles.labels}>Usuário</label>
            <input
              onBlur={verifyUser}
              value={user}
              onChange={({ target }) => setUser(target.value)}
            />
            <p className={styles.error}>{errorUser}</p>
          </div>
          <div className={styles.contratante}>
            <label className={styles.labels}>Sou contratante</label>
            <label className={styles.switch}>
              <input
                onChange={({ target }) => setContratante(target.checked)}
                value={contratante}
                type="checkbox"
              />
              <span className={styles.slider}></span>
            </label>
          </div>
        </div>

        <div>
          <label className={styles.labels}>Celular</label>
          <input
            type="number"
            onBlur={verifyCellphone}
            value={cellphone}
            onChange={({ target }) => setCellphone(target.value)}
          />

          <p className={styles.error}>{errorCellphone}</p>
        </div>
        <div>
          <label className={styles.labels}>E-mail</label>
          <input
            onBlur={verifyEmail}
            value={email}
            onChange={({ target }) =>
              setEmail(target.value.trim().toLocaleLowerCase())
            }
          />
          <p className={styles.error}>{errorEmail}</p>
        </div>
        <div>
          <label className={styles.labels}>Senha</label>
          <div className={styles.password}>
            <input
              onBlur={verifyPassword}
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
        </div>
        <div>
          <label className={styles.labels}>Confirmar senha</label>
          <div className={styles.password}>
            <input
              onBlur={verifyConfirmPassword}
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
          <p className={styles.error}>{errorConfirmPassword}</p>
        </div>
      </div>

      <div className={styles.buttons}>
        <Button
          disabled={disabled}
          link="/login"
          onClick={handleSubmit}
          text="Cadastrar"
        />
        <Button link="/login" isEmpty={true} text="Já possui uma conta?" />
      </div>
    </section>
  );
};

export default Cadastro;
