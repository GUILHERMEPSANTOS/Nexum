import Text from "../../Text/Text";
import Button from "../../Buttons/Button";
import Modal from "../Modal";
import styles from "./styles.module.scss";
import { useState } from "react";

const EditData = ({ actualState, setActualState }) => {
  const [nome, setNome] = useState();
  const [estado, setEstado] = useState();
  const [cidade, setCidade] = useState();
  const [profissao, setProfissao] = useState();

  return (
    <Modal
      text={"Perfil"}
      label={"Atualize seus dados"}
      actualState={actualState}
      setActualState={setActualState}
    >
      <div className={styles.container}>
        <Text isSmall={true} text="Nome" />
        <input onChange={({ target }) => setNome(target.value)} value={nome} />
        <Text isSmall={true} text="Cidade" />
        <input
          onChange={({ target }) => setCidade(target.value)}
          value={cidade}
        />
        <Text isSmall={true} text="Estado" />
        <input
          onChange={({ target }) => setEstado(target.value)}
          value={estado}
        />
        <Text isSmall={true} text="Profissao" />
        <input
          onChange={({ target }) => setProfissao(target.value)}
          value={profissao}
        />
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

export default EditData;
