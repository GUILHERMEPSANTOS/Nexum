import { useCallback, useState } from "react";
import Text from "../../Text/Text";
import { DEGREES } from "./constants";
import Title from "../../Title/Title";
import Button from "../../Buttons/Button";
import styles from "./styles.module.scss";
import EditDegrees from "../../Modals/EditDegrees/EditDegrees";
import { listCertificadoByFreelancerId } from "../../../services/Freelancer/freelancer";

const Degrees = ({ canEdit = true }) => {
  const [editDegrees, setEditDegrees] = useState(false);

  async function cerficado() {
    return await listCertificadoByFreelancerId(2);
  }

  useState(() => {
    cerficado();
  }, [cerficado]);

  return (
    <>
      <section className={styles.container}>
        {canEdit && (
          <div className={styles.edit}>
            <img
              onClick={() => setEditDegrees(true)}
              className={styles.editIcon}
              src="../../assets/icons/edit.svg"
            />
          </div>
        )}
        <Title text="Certificações" />
        {DEGREES.map(({ name, icon, text, location }, i) => (
          <div key={`${name} - ${i}`}>
            <div className={styles.wrapper}>
              <img src={`../../assets/icons/${icon}.svg`} />
              <div className={styles.contentContainer}>
                <div>
                  <Text text={name} />
                  <Text text={text} isSmall={true} />
                </div>
                <Button text="ver credenciais" />
              </div>
            </div>
            <Text text={location} isSmall={true} />
          </div>
        ))}
      </section>
      {editDegrees && (
        <EditDegrees
          actualState={editDegrees}
          setActualState={setEditDegrees}
        />
      )}
    </>
  );
};

export default Degrees;
