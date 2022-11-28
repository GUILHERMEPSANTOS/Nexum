import Title from "../../Title/Title";
import Text from "../../Text/Text";
import styles from "./styles.module.scss";

import { useMemo, useState } from "react";
import EditGraduate from "../../Modals/EditGraduate/EditGraduate";
import { listFormacaoByFreelancerId } from "../../../services/Freelancer/formacao";
import { useQuery } from "@tanstack/react-query";

const Formation = ({ canEdit = true }) => {
  const [editGraduate, setEditGraduate] = useState(false);
  const userId = useMemo(() => localStorage.getItem("user_id"));
  const [add, setAdd] = useState(false);
  const [edit, setEdit] = useState(false);
  const { data, isLoading, refetch } = useQuery(
    ["consultar certificados"],
    () => listFormacaoByFreelancerId(userId)
  );

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
                onClick={() => {
                  setAdd(true);
                  setEdit(false);
                  setEditGraduate(true);
                }}
                className={styles.editIcon}
                src="../../assets/icons/add.svg"
              />
            </div>
          )}
        </div>
        {data?.data.map(
          ({
            curso,
            instituicao,
            cidade,
            estado,
            data_final,
            sobre,
            data_inicial,
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
                  <img src={`../../assets/icons/${instituicao}.png`} />
                  <div className={styles.contantContainer}>
                    <div>
                      <Text text={instituicao} />
                      <Text text={curso} />
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

              <Text text={cidade} isSmall={true} />
              <Text text={estado} isSmall={true} />
              <Text text={data_inicial} isSmall={true} />
              <Text text={data_final} isSmall={true} />
              <Text text={sobre} isSmall={true} />
            </div>
          )
        )}
      </section>
      {editGraduate && (
        <EditGraduate
          edit={edit}
          add={add}
          refetch={refetch}
          actualState={editGraduate}
          setActualState={setEditGraduate}
        />
      )}
    </>
  );
};

export default Formation;
