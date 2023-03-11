import styles from "./styles.module.scss";
import { DATA } from "./constants";
import CardWithInfo from "./cardBanner/cardWithInfo";

const CardBanner = () => {
  return (
    <div className={styles.container}>
      <div className={styles.card__animation}>
        <CardWithInfo data={DATA} />
      </div>
    </div>
  );
};

export default CardBanner;
