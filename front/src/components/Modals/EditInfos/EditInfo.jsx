import Text from "../../Text/Text";
import Button from "../../Buttons/Button";
import Modal from "../Modal";
import styles from "./styles.module.scss";
import { useState } from "react";

const EditInfo = ({ actualState, setActualState }) => {
  const [illustrator, setIllustrator] = useState(false);
  const [premier, setPremier] = useState(false);
  const [photoshop, setPhotoshop] = useState(false);
  const [inkscape, setInkscape] = useState(false);
  const [figma, setFigma] = useState(false);

  return (
    <Modal
      text={"Perfil"}
      label={"Coloque as suas redes sociais"}
      actualState={actualState}
      setActualState={setActualState}
    >
      <div className={styles.container}>
        <div className={styles.containerLabel}>
          <Text isSmall={true} text="Illustrator" />
          <label className={styles.switch}>
            <input
              onChange={({ target }) => setIllustrator(target.checked)}
              value={illustrator}
              type="checkbox"
            />
            <span className={styles.slider}></span>
          </label>
        </div>
        <div className={styles.containerLabel}>
          <Text isSmall={true} text="Premier" />
          <label className={styles.switch}>
            <input
              onChange={({ target }) => setPremier(target.checked)}
              value={premier}
              type="checkbox"
            />
            <span className={styles.slider}></span>
          </label>
        </div>
        <div className={styles.containerLabel}>
          <Text isSmall={true} text="Photoshop" />
          <label className={styles.switch}>
            <input
              onChange={({ target }) => setPhotoshop(target.checked)}
              value={photoshop}
              type="checkbox"
            />
            <span className={styles.slider}></span>
          </label>
        </div>
        <div className={styles.containerLabel}>
          <Text isSmall={true} text="Inkscape" />
          <label className={styles.switch}>
            <input
              onChange={({ target }) => setInkscape(target.checked)}
              value={inkscape}
              type="checkbox"
            />
            <span className={styles.slider}></span>
          </label>
        </div>
        <div className={styles.containerLabel}>
          <Text isSmall={true} text="Figma" />
          <label className={styles.switch}>
            <input
              onChange={({ target }) => setFigma(target.checked)}
              value={figma}
              type="checkbox"
            />
            <span className={styles.slider}></span>
          </label>
        </div>
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

export default EditInfo;
