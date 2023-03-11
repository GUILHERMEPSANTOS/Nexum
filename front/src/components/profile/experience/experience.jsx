import { useMemo, useState } from "react";

import { useQuery } from "@tanstack/react-query";
import { listExperienciaByFreelancerId } from "../../../services/freelancer/experienca";

import EditExperience from "../../modals/editExperience/editExperience";
import Title from "../../title/title";
import Text from "../../text/text";

import styles from "./styles.module.scss";

const Experience = ({ canEdit = true }) => {
  const [editExperience, setEditExperience] = useState(false);
  const [add, setAdd] = useState(false);
  const [edit, setEdit] = useState(false);
  const [idExperiencia, setIdExperiencia] = useState(false);
  const userId = useMemo(() => localStorage.getItem("user_id"));

  const { data, isLoading, refetch } = useQuery(
    ["consultar experiencia"],
    async () => await listExperienciaByFreelancerId(userId)
  );

  if (isLoading) {
    return <div>Loding...</div>;
  }

  return (
    <>
      <section className={styles.container}>
        <div className={styles.containerAdd}>
          <Title text="Experiência" />
          {canEdit && (
            <div className={styles.add}>
              <img
                onClick={() => {
                  setAdd(true);
                  setEdit(false);
                  setEditExperience(true);
                }}
                className={styles.editIcon}
                src="../../assets/icons/add.svg"
              />
            </div>
          )}
        </div>
        {data?.data.map(
          ({
            cargo,
            empresa,
            cidade,
            estado,
            data_final,
            sobre,
            data_inicial,
            id_experiencia,
          }) => (
            <div>
              <div className={styles.wrapperContainer}>
                <div className={styles.wrapper}>
                  <img
                    className={styles.logo}
                    src={`../../assets/imgs/${empresa}.png`}
                  />
                  <div className={styles.contantContainer}>
                    <div>
                      <Text text={cargo} />
                      <Text text={empresa} isSmall={true} />
                    </div>
                  </div>
                </div>
                {canEdit && (
                  <div className={styles.edit}>
                    <img
                      onClick={() => {
                        setEdit(true);
                        setAdd(false);
                        setEditExperience(true);
                        setIdExperiencia(id_experiencia);
                      }}
                      className={styles.editIcon}
                      src="../../assets/icons/edit.svg"
                    />
                  </div>
                )}
              </div>
              <Text text={cidade} isSmall={true} />
              <Text text={estado} isSmall={true} />
              <Text text={data_inicial} isSmall={true} />
              <Text text={data_final} isSmall={true} />
              <Text text={sobre} isSmall={true} />
            </div>
          )
        )}
      </section>
      {editExperience && (
        <EditExperience
          idExperiencia={idExperiencia}
          edit={edit}
          add={add}
          refetch={refetch}
          actualState={editExperience}
          setActualState={setEditExperience}
        />
      )}
    </>
  );
};

export default Experience;
