import CardInfo from "../CardInfo/CardInfo";
import styles from "./styles.module.scss";

const CardWithInfo = ({ data }) => {
  return (
    <>
      {data.map(({ id, name, location, profession }) => (
        <div key={id} className={styles.card}>
          <img
            src={`../../../../../assets/imgs/person-card-${id}.png`}
            alt={name}
          />
          <CardInfo name={name} location={location} profession={profession} />
        </div>
      ))}
    </>
  );
};

export default CardWithInfo;
