import { useCallback, useState } from "react";

import CardEscolha from "./cards";
import ProfileContainer from "../profile";
import { useQuery } from "@tanstack/react-query";
import Modal from "../../../components/modals/modal";
import Button from "../../../components/buttons/button";
import { Loading } from "../../../components/loading/loading";
import { getFreelancers } from "../../../services/freelancer/freelancer";
import { getTxt, sendTxt } from "../../../services/importacao/freelancer";
import { CardWithInfo2 } from "../../../components/cards/cardsBanner/cardBanner/cardWithInfo";

import styles from "./styles.module.scss";

const FreelancerChoose = () => {
  const [modal, setModal] = useState(false);
  const [upload, setUpload] = useState("");

  const { data, isLoading } = useQuery(["consultar freelancers"], () =>
    getFreelancers()
  );

  const importTxt = useCallback(async () => {
    await sendTxt({ file: upload });
  }, [upload]);

  const exportTxt = useCallback(async () => {
    await getTxt();
  }, []);

  if (isLoading) {
    return <Loading />;
  }

  return (
    <>
      <ProfileContainer>
        <div className={styles.cardWrapper}>
          <div className={styles.cardContainer}>
            <CardWithInfo2 data={data?.data ?? []} />
          </div>
          <div className={styles.cardContainerInfo}>
            {data?.data?.map(({ nome, id_user }, i) => (
              <CardEscolha id_user={id_user} />
            ))}
          </div>
        </div>
        <div className={styles.buttons}>
          {/* <Button onClick={() => setModal(true)} text="Importação txt" /> */}
          <Modal actualState={modal} setActualState={setModal}>
            <input
              onChange={({ target }) => setUpload(target.files[0])}
              // value={upload}
              type="file"
              accept=".txt"
            />
            <Button
              onClick={() => {
                setModal(false);
                importTxt();
              }}
              isEmpty={true}
              text="Salvar"
            />
          </Modal>
          {/* <Button onClick={exportTxt} text="Exportação txt" /> */}
        </div>
      </ProfileContainer>
      {/* <CreateOffer actualState={openModal} setActualState={setOpenModal} /> */}
    </>
  );
};

export default FreelancerChoose;
