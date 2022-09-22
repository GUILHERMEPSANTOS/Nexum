import styles from "./styles.module.scss";
import { ITEMS } from "./Constants";

const Cards = () => {
  return (
    <ul className={styles.list}>
      {ITEMS.map((item, i) => (
        <li key={`item-${i}`}>
          <img src={`../../../assets/imgs/person-${i + 1}.png`} />
          {/* <div>
              <h2>{item.name}</h2>
              <h3>{item.profession}</h3>
              <p>{item.description}</p>
            </div> */}
        </li>
      ))}
    </ul>
  );
};

export default Cards;
