import Text from "../../Text/Text";
import Title from "../../Title/Title";
import styles from "./styles.module.scss";

const List = ({ title = "", list }) => (
  <section className={styles.container}>
    <Title text={title} />
    <ul className={styles.listItemsContainer}>
      {list.map(({ name, icon, date, number, rate, text }) => (
        <li className={styles.listItems}>
          {!!!icon && <img src={`../../assets/icons/${icon}.svg`} />}
          {!!!name && <Text isSmall={true} text={name} />}
          {!!!date && <Text isSmall={true} text={date} />}
          {!!!rate && <Text isSmall={true} text={number} />}
          {!!!text && <Text isSmall={true} text={rate} />}
          {!!!number && <Text isSmall={true} text={text} />}
        </li>
      ))}
    </ul>
  </section>
);
export default List;
