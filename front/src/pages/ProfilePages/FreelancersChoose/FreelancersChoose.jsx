import { useCallback, useState, useMemo } from "react";

import { useMutation, useQuery } from "@tanstack/react-query";
import { getFreelancers } from "../../../services/Freelancer/freelancer";
import { sendMatchRequest } from "../../../services/Freelancer/match/freelancer";

import CreateOffer from "../../../components/Modals/CreateOffer/CreateOffer";
import CardWithInfo from "../../../components/Cards/CardsBanner/CardBanner/CardWithInfo";

import ProfileContainer from "../profile";
import Text from "../../../components/Text/Text";

import styles from "./styles.module.scss";
import { getAboutUser } from "../../../services/Freelancer/user";
import CardEscolha from "./Cards";
import Button from "../../../components/Buttons/Button";
import Modal from "../../../components/Modals/Modal";
import { getTxt, sendTxt } from "../../../services/Importacao/freelancer";

const FreelancerChoose = () => {
  const [modal, setModal] = useState(false);
  const [upload, setUpload] = useState("");

  const idContratante = useMemo(() => localStorage.getItem("user_id"));

  const { data, isLoading } = useQuery(["consultar freelancers"], () =>
    getFreelancers()
  );

  const { mutate: sendMatch } = useMutation(
    ({ id_freelancer, id_contratante }) =>
      sendMatchRequest({ id_freelancer, id_contratante }),
    {
      onSuccess: () => {
        alert("Sucesso");
      },
      onError: () => {
        alert("Error");
      },
    }
  );

  const importTxt = useCallback(async () => {
    await sendTxt({ file: upload });
  }, [upload]);

  const exportTxt = useCallback(async () => {
    await getTxt();
  }, []);

  const handleSubmit = useCallback(
    (id_freelancer) => {
      sendMatch({
        id_freelancer,
        id_contratante: Number(idContratante),
      });
    },
    [idContratante, sendMatchRequest]
  );

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return (
    <>
      <ProfileContainer>
        <div className={styles.cardWrapper}>
          <div className={styles.cardContainer}>
            <CardWithInfo data={data?.data ?? []} />
          </div>
          <div className={styles.cardContainerInfo}>
            {data?.data?.map(({ nome, id_user }, i) => (
              <CardEscolha id_user={id_user} />
            ))}
          </div>
        </div>
        <div className={styles.buttons}>
          <Button onClick={() => setModal(true)} text="Importação txt" />
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
          <Button onClick={exportTxt} text="Exportação txt" />
        </div>
      </ProfileContainer>
      {/* <CreateOffer actualState={openModal} setActualState={setOpenModal} /> */}
    </>
  );
};

export default FreelancerChoose;
