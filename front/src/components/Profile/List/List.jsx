import Text from "../../Text/Text";
import Title from "../../Title/Title";
import styles from "./styles.module.scss";

const List = ({ title = "", list }) => {
  console.log(list);
  return (
    <section className={styles.container}>
      <Title text={title} />
      <ul className={styles.listItemsContainer}>
        {list.map(({ name, icon, date, number, rate, text, social }, i) => {
          return (
            <li key={`${name} - ${i}`} className={styles.listItems}>
              {!!icon && <img src={`../../assets/icons/${icon}.svg`} />}
              <div>
                {!!name && <Text isSmall={true} text={name} />}
                {!!text && <Text isSmall={true} text={text} />}
              </div>
              {!!number && <Text isSmall={true} text={number} />}
              {!!rate && <Text isSmall={true} text={rate} />}
              {!!date && <Text isSmall={true} text={date} />}
              {!!social && (
                <>
                  <img src={`../../assets/icons/${social.nome}.svg`} />{" "}
                  <Text isSmall={true} text={social.nome} />
                </>
              )}
            </li>
          );
        })}
      </ul>
    </section>
  );
};
export default List;
