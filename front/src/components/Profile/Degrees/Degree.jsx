import { useMemo, useState } from "react";
import Text from "../../Text/Text";
import Title from "../../Title/Title";
import Button from "../../Buttons/Button";
import styles from "./styles.module.scss";
import EditDegrees from "../../Modals/EditDegrees/EditDegrees";
import { listCertificadoByFreelancerId } from "../../../services/Freelancer/certificacao";
import { useQuery } from "@tanstack/react-query";

const Degrees = ({ canEdit = true }) => {
  const [editDegrees, setEditDegrees] = useState(false);
  const [add, setAdd] = useState(false);
  const userId = useMemo(() => localStorage.getItem("user_id"));

  const { data, isLoading } = useQuery(
    ["consultar certificados"],
    async () => await listCertificadoByFreelancerId(userId)
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
              onClick={() => {
                setAdd(true);
                setEditDegrees(true);
              }}
              className={styles.editIcon}
              src="../../assets/icons/add.svg"
            />
          </div>
        )}
        {data?.data.map(({ curso, instituicao, cidade, estado }, i) => (
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
          add={add}
          actualState={editDegrees}
          setActualState={setEditDegrees}
        />
      )}
    </>
  );
};

export default Degrees;
