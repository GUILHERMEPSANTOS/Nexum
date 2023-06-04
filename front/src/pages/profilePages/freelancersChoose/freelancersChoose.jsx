import { useCallback, useState, useMemo } from "react";

import { useMutation, useQuery } from "@tanstack/react-query";
import { getFreelancers } from "../../../services/freelancer/freelancer";
import { sendMatchRequest } from "../../../services/freelancer/match/freelancer";

import CreateOffer from "../../../components/modals/createOffer/createOffer";
import CardWithInfo from "../../../components/cards/cardsBanner/cardBanner/cardWithInfo";

import ProfileContainer from "../profile";
import Text from "../../../components/text/text";

import styles from "./styles.module.scss";
import { getAboutUser } from "../../../services/freelancer/user";
import CardEscolha from "./cards";
import Button from "../../../components/buttons/button";
import Modal from "../../../components/modals/modal";
import { getTxt, sendTxt } from "../../../services/importacao/freelancer";
import { Loading } from "../../../components/loading/loading";

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
