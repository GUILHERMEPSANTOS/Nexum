import { useState } from "react";

import { useQuery } from "@tanstack/react-query";
// import { } from '../../../services/Freelancer/user';

import Button from "../../Buttons/Button";
import Modal from "../Modal";
import styles from "./styles.module.scss";

const EditProfile = ({ actualState, setActualState }) => {
  const [about, setAbout] = useState();
  const {} = useQuery();


  return (
    <Modal
      text={"Perfil"}
      label={"Sobre"}
      actualState={actualState}
      setActualState={setActualState}
    >
      <textarea
        onChange={({ target }) => setAbout(target.value)}
        value={about}
        className={styles.textArea}
      />
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
