import CardWithInfo from "../../../components/Cards/CardsBanner/CardBanner/CardWithInfo";
import ProfileContainer from "../profile";
import { DATA } from "./Constants";
import styles from "./styles.module.scss";

const FreelancerChoose = () => {
  return (
    <ProfileContainer>
      <div className={styles.cardWrapper}>
        <div className={styles.cardContainer}>
          <CardWithInfo data={DATA} />
        </div>
        <div className={styles.tooltip}></div>
      </div>
    </ProfileContainer>
  );
};

export default FreelancerChoose;
