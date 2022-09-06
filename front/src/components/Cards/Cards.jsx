import styles from "./styles.module.scss";
import ITEMS from "./Constants";

const Cards = () => {
  return (
    <nav className={styles.exemplo}>
      <ul>
        {ITEMS.map(
          (item,
          (i) => {
            <li key={`item-${i}`}>{item}</li>;
          })
        )}
      </ul>
    </nav>
  );
};

export default Cards;
