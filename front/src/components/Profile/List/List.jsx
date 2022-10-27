import Title from "src/components/Title/Title";
import styles from "./styles.module.scss";

const List = ({ title, list }) => (
  <section className={styles.container}>
    <Title text={title} />
    <div className={styles.listItemsContainer}>
      {list.map(({ name, icon, data, number, rate, text }) => (
        <div className={styles.listItems}>
            
          <img src={`../../assets/icons/${icon}.svg`} />
          <Text isSmall={true} text={name} />
          <Text isSmall={true} text={data} />
          <Text isSmall={true} text={number} />
          <Text isSmall={true} text={name} />
          <Text isSmall={true} text={name} />
        </div>
      ))}
    </div>
  </section>
);
export default List;
