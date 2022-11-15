import Title from "../../Title/Title";
import Text from "../../Text/Text";
import List from "../List/List";
import { INFOS, ACHIEVEMENT, HABILITIES } from "./constants";
import styles from "./styles.module.scss";
import { useState } from "react";
import EditInfo from "../../Modals/EditInfos/EditInfo";

const Infos = ({ canEdit = true }) => {
  const [clickEditInfo, setClickEditInfo] = useState(false);
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
        <List list={HABILITIES} />
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
