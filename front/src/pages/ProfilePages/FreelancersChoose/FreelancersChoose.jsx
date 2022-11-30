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

const FreelancerChoose = () => {
  const [id, setId] = useState();
  

  const idContratante = useMemo(() => localStorage.getItem("user_id"));

  const { data, isLoading } = useQuery(["consultar freelancers"], () =>
    getFreelancers()
  );



  const { mutate: sendMatch } = useMutation(({ id_freelancer, id_contratante }) =>
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
    sendMatch({
      id_freelancer,
      id_contratante: Number(idContratante),
    });
  },
  [idContratante, sendMatchRequest]
);


if (isLoading ) {
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
<CardEscolha id_user={id_user}/>
          ))}
        </div>
      </div>
      <div className={styles.buttons}>
      <Button text="Importar txt"/>
      <Button text="Exportar txt"/>
      </div>
    </ProfileContainer>
    {/* <CreateOffer actualState={openModal} setActualState={setOpenModal} /> */}
  </>
);
};

export default FreelancerChoose;
