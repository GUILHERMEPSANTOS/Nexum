import { useState } from "react";
import Text from "../../Text/Text";
import Title from "../../Title/Title";
import Button from "../../Buttons/Button";
import styles from "./styles.module.scss";
import EditDegrees from "../../Modals/EditDegrees/EditDegrees";
import { listCertificadoByFreelancerId } from "../../../services/Freelancer/certificacao";
import { useQuery } from "@tanstack/react-query";

const Degrees = ({ canEdit = true }) => {
  const [editDegrees, setEditDegrees] = useState(false);
  const userId = localStorage.getItem("user_id");

  const { data, isLoading } = useQuery(["consultar certificados"], () =>
    listCertificadoByFreelancerId(userId)
  );

  if (isLoading) {
    return <div>Loding...</div>;
  }

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
        {data?.map(({ curso, instituicao, cidade, estado }, i) => (
          <div key={`${curso} - ${i}`}>
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
              <img src={`../../assets/icons/${instituicao}.svg`} />
              <div className={styles.contentContainer}>
                <div>
                  <Text text={curso} />
                  <Text text={instituicao} isSmall={true} />
                </div>
                <Button text="ver credenciais" />
              </div>
            </div>
            <Text text={cidade} isSmall={true} />
            <Text text={estado} isSmall={true} />
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
