import Modal from "../modal";
import styles from "./styles.module.scss";
import { useState } from "react";
import useCadastro from "../../form/cadastro/hooks";
import Button from "../../buttons/button";

const EditPassword = ({ actualState, setActualState }) => {
  const [password, setPassword] = useState();
  const [confirmPassword, setConfirmPassword] = useState();
  const [type, setType] = useState("password");
  const {
    errorPassword,
    errorConfirmPassword,
    verifyPassword,
    verifyConfirmPassword,
  } = useCadastro({
    password,

    confirmPassword,
  });
  return (
    <Modal
      text={"Mudar senha"}
      label={"Insira a nova senha"}
      actualState={actualState}
      setActualState={setActualState}
    >
      <div className={styles.container}>
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
      <div className={styles.buttons}>
        <Button
          onClick={() => setActualState(false)}
          isEmpty={true}
          text="Salvar"
        />
      </div>
    </Modal>
  );
};

export default EditPassword;
