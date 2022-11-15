import Button from "../../Buttons/Button";
import Modal from "../Modal";
import styles from "./styles.module.scss";

const EditProfile = ({ actualState, setActualState }) => {
  return (
    <Modal
      text={"Perfil"}
      label={"Sobre"}
      actualState={actualState}
      setActualState={setActualState}
    >
      <textarea className={styles.textArea} />
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

export default EditProfile;
