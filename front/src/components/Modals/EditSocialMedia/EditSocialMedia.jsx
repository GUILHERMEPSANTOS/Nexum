import Text from "../../Text/Text";
import Button from "../../Buttons/Button";
import Modal from "../Modal";
import styles from "./styles.module.scss";
import { useState } from "react";

const EditSocialMedia = ({ actualState, setActualState }) => {
  const [linkedin, setLinkedin] = useState();
  const [facebook, setFacebook] = useState();
  const [instagram, setInstagram] = useState();
  const [email, setEmail] = useState();

  return (
    <Modal
      text={"Perfil"}
      label={"Coloque as suas redes sociais"}
      actualState={actualState}
      setActualState={setActualState}
    >
      <div className={styles.container}>
        <Text isSmall={true} text="Linkedin" />
        <input
          onChange={({ target }) => setLinkedin(target.value)}
          value={linkedin}
        />
        <Text isSmall={true} text="Facebook" />
        <input
          onChange={({ target }) => setFacebook(target.value)}
          value={facebook}
        />
        <Text isSmall={true} text="Instagram" />
        <input
          onChange={({ target }) => setInstagram(target.value)}
          value={instagram}
        />
        <Text isSmall={true} text="Email" />
        <input
          onChange={({ target }) => setEmail(target.value)}
          value={email}
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

export default EditSocialMedia;
