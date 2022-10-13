import styles from "./styles.module.scss";
import { ITEMS } from "./Constants";
import Title from "../Title/Title";
import Text from "../Text/Text";

const Cards = () => {
  return (
    <section className={styles.wrapper}>
      <ul className={styles.list}>
        {ITEMS.map((item, i) => (
          <li key={`item-${i}`}>
            <img src={`../../../assets/imgs/person-${i + 1}.png`} />
            <div className={styles.info}>
              <Title text={item.name} />
              <Text text={item.profession} />
            </div>
          </li>
        ))}
      </ul>
    </section>
  );
};

export default Cards;
