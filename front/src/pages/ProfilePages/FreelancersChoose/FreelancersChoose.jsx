import { useCallback, useState, useMemo } from "react";

import { useMutation, useQuery } from "@tanstack/react-query";
import { getFreelancers } from "../../../services/Freelancer/freelancer";
import { sendMatchRequest } from "../../../services/Freelancer/match/freelancer";

import CreateOffer from "../../../components/Modals/CreateOffer/CreateOffer";
import CardWithInfo from "../../../components/Cards/CardsBanner/CardBanner/CardWithInfo";

import ProfileContainer from "../profile";
import Text from "../../../components/Text/Text";

import styles from "./styles.module.scss";

const FreelancerChoose = () => {
  const [openModal, setOpenModal] = useState(true);

  const idContratante = useMemo(() => localStorage.getItem("user_id"));

  const { data, isLoading } = useQuery(["consultar freelancers"], () =>
    getFreelancers()
  );

  const { mutate } = useMutation(({ id_freelancer, id_contratante }) =>
    sendMatchRequest({ id_freelancer, id_contratante }),
    {
      onSuccess: () => {
        alert("Sucesso")
      },
      onError: () => {
        alert("Error");
      }
    }
  );

const handleSubmit = useCallback(
  (id_freelancer) => {
    mutate({
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
            <div key={i}>
              <div className={styles.actions}>
                <button onClick={() => handleSubmit(id_user)}>
                  <img src="../../assets/icons/like.svg" />
                </button>
                <button>
                  <img src="../../assets/icons/save.svg" />
                </button>
              </div>
              <Text isSmall={true} text={nome} />

              <Text isSmall={true} text={"Ver perfil"} />
              {/* <List list={habilidades} /> */}
            </div>
          ))}
        </div>
      </div>
    </ProfileContainer>
    {/* <CreateOffer actualState={openModal} setActualState={setOpenModal} /> */}
  </>
);
};

export default FreelancerChoose;
