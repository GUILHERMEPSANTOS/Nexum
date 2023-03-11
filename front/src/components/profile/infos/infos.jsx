import { useState, useMemo } from "react";
import { useQuery } from "@tanstack/react-query";

import {
  listHabilidadesByUserId,
  getHabilidadeById,
} from "../../../services/freelancer/habilidades";

import EditInfo from "../../modals/editInfos/editInfo";
import Title from "../../title/title";
import Text from "../../text/text";
import List from "../list/list";
import { INFOS, ACHIEVEMENT, HABILITIES } from "./constants";
import styles from "./styles.module.scss";
import { Loading } from "../../loading/loading";

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
    return <Loading />;
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
        {dataFreelancerHabilidades?.data?.length > 0 && (
          <List list={dataFreelancerHabilidades?.data} />
        )}
        <br />
        <Text text="Consquistas" />
        <br />
        {/* <List list={ACHIEVEMENT} /> */}
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
