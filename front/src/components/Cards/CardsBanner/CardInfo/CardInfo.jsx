import styles from "./styles.module.scss";

const CardInfo = ({ name, location, profession }) => {
  return (
    <div className={styles.card}>
      <div className={styles.container}>
        <h4>{name}</h4>
        <img src="../../../../../assets/icons/available.png" alt="available" />
      </div>
      <div className={styles.container__location}>
        <img src="../../../../../assets/icons/location.png" alt="localização" />
        <p>{location}</p>
      </div>
      <p>{profession}</p>
    </div>
  );
};

export default CardInfo;
