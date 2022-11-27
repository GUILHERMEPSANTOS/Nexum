import Title from "../../Title/Title";
import Text from "../../Text/Text";
import styles from "./styles.module.scss";
import { FORMATION } from "./constants";
import { useState } from "react";
import EditGraduate from "../../Modals/EditGraduate/EditDegrees";
import { listFormacaoByFreelancerId } from "../../../services/Freelancer/formacao";
import { useQuery } from "@tanstack/react-query";

const Formation = ({ canEdit = true }) => {
  const [editGraduate, setEditGraduate] = useState(false);
  const userId = localStorage.getItem("user_id");

  const { data, isLoading } = useQuery(["consultar certificados"], () =>
    listFormacaoByFreelancerId(userId)
  );
  console.log(data, "formacao");
  if (isLoading) {
    return <div>Loding...</div>;
  }
  return (
    <>
      <section className={styles.container}>
        <div className={styles.containerAdd}>
          <Title text="Formação" />
          {canEdit && (
            <div className={styles.add}>
              <img
                onClick={() => setEditGraduate(true)}
                className={styles.editIcon}
                src="../../assets/icons/add.svg"
              />
            </div>
          )}
        </div>
        {data?.lenght > 0 &&
          data?.map(
            ({
              icon,
              institution,
              UniversityDegree,
              location,
              date,
              about,
            }) => (
              <div>
                {canEdit && (
                  <div className={styles.edit}>
                    <img
                      onClick={() => setEditGraduate(true)}
                      className={styles.editIcon}
                      src="../../assets/icons/edit.svg"
                    />
                  </div>
                )}
                <div className={styles.wrapperContainer}>
                  <div className={styles.wrapper}>
                    <img src={`../../assets/icons/${icon}.png`} />
                    <div className={styles.contantContainer}>
                      <div>
                        <Text text={institution} />
                        <Text text={UniversityDegree} />
                      </div>
                    </div>
                  </div>
                  {canEdit && (
                    <div className={styles.edit}>
                      <img
                        onClick={() => setEditGraduate(true)}
                        className={styles.editIcon}
                        src="../../assets/icons/edit.svg"
                      />
                    </div>
                  )}
                </div>

                <Text text={location} isSmall={true} />
                <Text text={date} isSmall={true} />
                <Text text={about} isSmall={true} />
              </div>
            )
          )}
      </section>
      {editGraduate && (
        <EditGraduate
          actualState={editGraduate}
          setActualState={setEditGraduate}
        />
      )}
    </>
  );
};

export default Formation;
