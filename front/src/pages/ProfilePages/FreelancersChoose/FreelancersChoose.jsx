import { useCallback, useEffect, useState } from "react";
import CreateOffer from "../../../components/Modals/CreateOffer/CreateOffer";
import CardWithInfo from "../../../components/Cards/CardsBanner/CardBanner/CardWithInfo";
import ProfileContainer from "../profile";
import { DATA } from "./Constants";
import styles from "./styles.module.scss";
import List from "../../../components/Profile/List/List";
import Text from "../../../components/Text/Text";
import { getFreelancer } from "../../../services/Freelancer/freelancer";

const FreelancerChoose = () => {
  const [openModal, setOpenModal] = useState(true);
  const [data, setData] = useState();

  const handleSubmit = useCallback(async () => {
    const teste = await getFreelancer();
    setData(teste);
  }, []);
  console.log(data);
  useEffect(() => {
    handleSubmit();
  }, []);
  return (
    <>
      <ProfileContainer>
        <div className={styles.cardWrapper}>
          <div className={styles.cardContainer}>
            <CardWithInfo data={data} />
          </div>
          <div className={styles.cardContainerInfo}>
            {data.map(({ nome, endereco }, i) => (
              // ({ sobre, habilidades }, i)
              <div key={i}>
                <div className={styles.actions}>
                  <button>
                    <img src="../../assets/icons/like.svg" />
                  </button>
                  <button>
                    <img src="../../assets/icons/save.svg" />
                  </button>
                </div>
                <Text isSmall={true} text={nome} />

                <Text isSmall={true} text={"Ver perfil"} />
                {/* <List list={endereco} /> */}
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
