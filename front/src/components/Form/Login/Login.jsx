import { useCallback } from "react";

import Title from "../../Title/Title";
import Text from "../../Text/Text";
import styles from "./styles.module.scss";
import Button from "../../Buttons/Button";
import { useState } from "react";
import { APILogin } from "../../../services";
import useLogin from "./hooks";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const [type, setType] = useState("password");
  const navigate = useNavigate()

  const handleSubmit = useCallback(async () => {
   const handlelogin = await APILogin({ email, senha: password });


   handlelogin.status == 200 ?
    navigate("/inicio")
    :
    window.alert("Usuário ou senha incorretos")

    localStorage.setItem("id", handlelogin.data)
    console.log(handlelogin.data)
  }, [email, password]);

  const {
    errorEmail,
    errorPassword,
    verifyEmail,
    verifyPassword,
    disabled,
  } = useLogin({
    email,
    password,
  });

  return (
    <section className={styles.container}>
      <Title text="Seja bem-vindo" />
      <Text text="Preecha os campos para continuar" />

      <div className={styles.content}>
        <label className={styles.labels}>Usuário</label>
        <input
         onBlur={verifyEmail}
          value={email}
          onChange={({ target }) => setEmail(target.value)}
        />
        <p className={styles.error}>{errorEmail}</p>
        <label className={styles.labels}>Senha</label>
        <div className={styles.password}>
          <input
          onBlur={verifyPassword}
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
        <p className={styles.error}>{errorPassword}</p>
      </div>
      <div className={styles.settings}>
        <label className={styles.labels}>Esqueci a senha</label>
      </div>
      <div className={styles.buttons}>
        <Button disabled={disabled} onClick={handleSubmit} text="Entrar" />
        <Button link="/cadastro" isEmpty={true} text="Criar conta" />
      </div>
    </section>
  );
};

export default Login;
