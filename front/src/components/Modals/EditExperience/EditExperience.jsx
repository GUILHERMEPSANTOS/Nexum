import Text from "../../Text/Text";
import Button from "../../Buttons/Button";
import Modal from "../Modal";
import styles from "./styles.module.scss";
import { useState } from "react";

const EditExperience = ({ actualState, setActualState }) => {
  const [cargo, setCargo] = useState();
  const [empresa, setEmpresa] = useState();
  const [estado, setEstado] = useState();
  const [cidade, setCidade] = useState();
  const [dataInicio, setDataInicio] = useState();
  const [dataFinal, setDataFinal] = useState();
  const [sobre, setSobre] = useState();

  return (
    <Modal
      text={"Experiência"}
      label={"Coloque suas experiências"}
      actualState={actualState}
      setActualState={setActualState}
    >
      <div className={styles.container}>
        <Text isSmall={true} text="Cargo" />
        <input
          onChange={({ target }) => setCargo(target.value)}
          value={cargo}
        />
        <Text isSmall={true} text="Nome da empresa" />
        <input
          onChange={({ target }) => setEmpresa(target.value)}
          value={empresa}
        />
        <Text isSmall={true} text="Local" />
        <div className={styles.location}>
          <input
            placeholder="Estado"
            onChange={({ target }) => setEstado(target.value)}
            value={estado}
          />
          <input
            placeholder="Cidade"
            onChange={({ target }) => setCidade(target.value)}
            value={cidade}
          />
        </div>
        <Text isSmall={true} text="Caminho para certificado" />
        <div className={styles.location}>
          <input
            placeholder="Inicio"
            onChange={({ target }) => setDataInicio(target.value)}
            value={dataInicio}
            type="date"
          />
          <input
            placeholder="Término"
            onChange={({ target }) => setDataFinal(target.value)}
            value={dataFinal}
            type="date"
          />
        </div>
        <Text isSmall={true} text="Instituição de empresa" />
        <textarea
          onChange={({ target }) => setSobre(target.value)}
          value={sobre}
          className={styles.textArea}
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

export default EditExperience;
