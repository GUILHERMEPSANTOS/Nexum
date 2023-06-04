import { useMutation, useQuery } from "@tanstack/react-query";
import { getAboutUser } from "../../../../services/freelancer/user";
import List from "../../../../components/profile/list/list";
import Text from "../../../../components/text/text";
import styles from "./styles.module.scss";
import { listHabilidadesByUserId } from "../../../../services/freelancer/habilidades";
import { useCallback, useMemo } from "react";
import { sendMatchRequest } from "../../../../services/freelancer/match/freelancer";

const CardEscolha = ({ id_user }) => {
  const {
    data: idData,
    isLoading: LoadingData,
    refetch,
  } = useQuery(
    ["consultar about freelas"],
    async () => await getAboutUser(id_user)
  );
  const {
    data: dataFreelancerHabilidades,
    isLoading: isLoadingFreelancerHabilidades,
  } = useQuery(
    ["consultar freelancer habilidades"],
    async () => await listHabilidadesByUserId(id_user)
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

  const idContratante = useMemo(() => localStorage.getItem("user_id"));

  const handleSubmit = useCallback(
    (id_freelancer) => {
      sendMatch({
        id_freelancer,
        id_contratante: Number(idContratante),
      });
    },
    [idContratante, sendMatchRequest]
  );

  return (
    <div key={id_user}>
      <div className={styles.actions}>
        <button onClick={() => handleSubmit(id_user)}>
          <img src="../../assets/icons/like.svg" />
        </button>
        {/* <button>
          <img src="../../assets/icons/save.svg" />
        </button> */}
      </div>
      <Text isSmall={true} text={idData?.data} />

      {dataFreelancerHabilidades?.data?.length > 0 && (
        <List list={dataFreelancerHabilidades?.data} />
      )}
    </div>
  );
};

export default CardEscolha;
