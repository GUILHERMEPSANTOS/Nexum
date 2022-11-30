import { useState, useMemo } from "react";
import { useQuery } from "@tanstack/react-query";

import {
  listHabilidadesByUserId,
  getHabilidadeById,
} from "../../../services/Freelancer/habilidades";

import EditInfo from "../../Modals/EditInfos/EditInfo";
import Title from "../../Title/Title";
import Text from "../../Text/Text";
import List from "../List/List";
import { INFOS, ACHIEVEMENT, HABILITIES } from "./constants";
import styles from "./styles.module.scss";

const Infos = ({ canEdit = true }) => {
  const userId = useMemo(() => Number(localStorage.getItem("user_id")));
  const [clickEditInfo, setClickEditInfo] = useState(false);

  const {
    data: dataFreelancerHabilidades,
    isLoading: isLoadingFreelancerHabilidades,
  } = useQuery(["consultar freelancer habilidades"], () =>
    listHabilidadesByUserId(userId)
  );

  if (isLoadingFreelancerHabilidades) {
    return <div>Loading...</div>;
  }

  return (
    <>
      <section className={styles.container}>
        {canEdit && (
          <div className={styles.edit}>
            <img
              onClick={() => setClickEditInfo(true)}
              className={styles.editIcon}
              src="../../assets/icons/edit.svg"
            />
          </div>
        )}
        <Title text="Análise" />
        <br />
        <br />
        <br />
        <Text text="Informações" />
        <br />
        <List list={INFOS} />
        <br />
        <Text text="Habilidades" />
        <br />
        {dataFreelancerHabilidades?.data?.legth > 0 && (
          <List list={dataFreelancerHabilidades?.data} />
      
        )}
        <br />
        <Text text="Consquistas" />
        <br />
        <List list={ACHIEVEMENT} />
      </section>
      {clickEditInfo && (
        <EditInfo
          actualState={clickEditInfo}
          setActualState={setClickEditInfo}
        />
      )}
    </>
  );
};

export default Infos;
