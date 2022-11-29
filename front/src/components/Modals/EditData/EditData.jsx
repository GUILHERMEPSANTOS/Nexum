import Text from "../../Text/Text";
import Button from "../../Buttons/Button";
import Modal from "../Modal";
import styles from "./styles.module.scss";
import { useState } from "react";

const EditData = ({ actualState, setActualState }) => {
  const [nome, setNome] = useState();
  const [estado, setEstado] = useState();
  const [cidade, setCidade] = useState();
  const [marketing, setMarketing] = useState();
  const [programador, setProgramador] = useState();
  const [designer, setDesigner] = useState();
  const [page, setPage] = useState(1);
console.log(page)
  return (
    <Modal
      text={"Perfil"}
      actualState={actualState}
      setActualState={setActualState}
      label={
        page == 1
          ? "Atualize seus dados"
          : page == 2
          ? "Atualize sua profissão"
          : ""
      }
    >
      <div className={styles.container}>
      {page == 1 && (
        <>
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
        </>
        )}
        {page == 2 && (
          <>
       <div className={styles.containerLabel}>
              <Text isSmall={true} text="Designer" />
              <label className={styles.switch}>
                <input
                  onChange={({ target }) => setDesigner(target.checked)}
                  value={designer}
                  type="checkbox"
                />
                <span className={styles.slider}></span>
              </label>
            </div>
            <div className={styles.containerLabel}>
              <Text isSmall={true} text="Programador" />
              <label className={styles.switch}>
                <input
                  onChange={({ target }) => setProgramador(target.checked)}
                  value={programador}
                  type="checkbox"
                />
                <span className={styles.slider}></span>
              </label>
            </div>
            <div className={styles.containerLabel}>
              <Text isSmall={true} text="Marketing" />
              <label className={styles.switch}>
                <input
                  onChange={({ target }) => setMarketing(target.checked)}
                  value={marketing}
                  type="checkbox"
                />
                <span className={styles.slider}></span>
              </label>
            </div>
        </>
        )}
      </div>
      <div className={styles.buttons}>
        {page == 2 && (
          <>
          <img
            className={styles.back}
            onClick={() => setPage(page - 1)}
            src="../../assets/icons/back.svg"
          />
          <Button
          onClick={() => setActualState(false)}
          isEmpty={true}
          text="Salvar"/>
          </>
        
        )}
       : (
          <img
            onClick={() =>
                setPage(page + 1)
            }
            className={styles.icon}
            src="../../assets/icons/back.svg"
          />
        )
      </div>
    </Modal>
  );
};

export default EditData;
