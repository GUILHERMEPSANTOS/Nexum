import styles from "./styles.module.scss";
import { DATA } from "./Constants";
import CardWithInfo from "./CardBanner/CardWithInfo";

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
