import CardInfo from "../cardInfo/cardInfo";
import styles from "./styles.module.scss";

export const CardWithInfo = ({ data }) => {
  return (
    <>
      {data.map(({ id_user, nome, endereco, profession }, i) => (
        <div key={`${id_user}-${nome}-${i}`} className={styles.card}>
          <img
            className={styles.foto}
            src={`../../../../../assets/imgs/person-card-${id_user}.png`}
            alt={nome}
          />
          <CardInfo
            name={nome}
            locationCity={endereco?.cidade}
            location={endereco?.estado}
            profession={profession}
          />
        </div>
      ))}
    </>
  );
};

export const CardWithInfo2 = ({ data }) => {
  return (
    <>
      {data.map(({ id_user, nome, endereco, profession }, i) => (
        <div key={`${id_user}-${nome}-${i}`} className={styles.card}>
          <img
            className={styles.foto}
            src={`../../../../../assets/imgs/avatar.png`}
            alt={nome}
          />
          <CardInfo
            name={nome}
            locationCity={endereco?.cidade}
            location={endereco?.estado}
            profession={profession}
          />
        </div>
      ))}
    </>
  );
};

export default CardWithInfo;
