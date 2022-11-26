import { useCallback, useEffect, useState } from "react";
import Text from "../../Text/Text";
import { DEGREES } from "./constants";
import Title from "../../Title/Title";
import Button from "../../Buttons/Button";
import styles from "./styles.module.scss";
import EditDegrees from "../../Modals/EditDegrees/EditDegrees";
import { listCertificadoByFreelancerId } from "../../../services/Freelancer/certificacao";

const Degrees = ({ canEdit = true }) => {
  const [editDegrees, setEditDegrees] = useState(false);
  const perfil = localStorage.getItem("role");
  const [certificacao, setCertificado] = useState();

  useEffect(() => {
    if (perfil == `"ROLE_FREELANCER"`)
      setCertificado(localStorage.getItem("user_id"));
  }, []);
  async function cerficado() {
    return await listCertificadoByFreelancerId(certificacao);
  }

  useState(() => {
    cerficado();
  }, [cerficado]);

  return (
    <>
      <section className={styles.container}>
        <Title text="Certificações" />
        {canEdit && (
          <div className={styles.add}>
            <img
              onClick={() => setEditExperience(true)}
              className={styles.editIcon}
              src="../../assets/icons/add.svg"
            />
          </div>
        )}
        {DEGREES.map(({ name, icon, text, location }, i) => (
          <div key={`${name} - ${i}`}>
            {canEdit && (
              <div className={styles.edit}>
                <img
                  onClick={() => setEditDegrees(true)}
                  className={styles.editIcon}
                  src="../../assets/icons/edit.svg"
                />
              </div>
            )}

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
