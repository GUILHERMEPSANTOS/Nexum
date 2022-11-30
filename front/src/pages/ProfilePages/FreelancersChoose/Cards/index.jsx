import { useQuery } from "@tanstack/react-query";
import { getAboutUser } from "../../../../services/Freelancer/user";
import List from "../../../../components/Profile/List/List";
import Text from "../../../../components/Text/Text";
import styles from "./styles.module.scss";
import { listHabilidadesByUserId } from "../../../../services/Freelancer/habilidades";

const CardEscolha = ({id_user}) => {
    const { data: idData, isLoading: LoadingData, refetch } = useQuery(
        ["consultar about freelas"],
        async () => await getAboutUser(id_user)
      );
      const {
        data: dataFreelancerHabilidades,
        isLoading: isLoadingFreelancerHabilidades,
      } = useQuery(["consultar freelancer habilidades"], async () =>
        await listHabilidadesByUserId(id_user)
      );
      console.log(dataFreelancerHabilidades?.data?.length)
      
        return(
        <div key={id_user}>
          <div className={styles.actions}>
            <button onClick={() => handleSubmit(id_user)}>
              <img src="../../assets/icons/like.svg" />
            </button>
            <button>
              <img src="../../assets/icons/save.svg" />
            </button>
          </div>
          <Text isSmall={true} text={idData?.data} />

          {dataFreelancerHabilidades?.data?.length > 0 && (
      <List list={dataFreelancerHabilidades?.data} />
 
    )} 
        </div>
        )
}

export default CardEscolha