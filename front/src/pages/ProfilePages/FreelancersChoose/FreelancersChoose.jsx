import { useState } from "react";
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

  useState(() => {
    cerficado();
  }, [cerficado]);
  return (
    <>
      <ProfileContainer>
        <div className={styles.cardWrapper}>
          <div className={styles.cardContainer}>
            <CardWithInfo data={DATA} />
          </div>
          <div className={styles.cardContainerInfo}>
            {DATA.map(({ sobre, habilidades }) => (
              <div>
                <div className={styles.actions}>
                  <button>
                    <img src="../../assets/icons/like.svg" />
                  </button>
                  <button>
                    <img src="../../assets/icons/save.svg" />
                  </button>
                </div>
                <Text isSmall={true} text={sobre} />
                <List list={habilidades} />
              </div>
            ))}
          </div>
        </div>
      </ProfileContainer>
      <CreateOffer actualState={openModal} setActualState={setOpenModal} />
    </>
  );
};

export default FreelancerChoose;
