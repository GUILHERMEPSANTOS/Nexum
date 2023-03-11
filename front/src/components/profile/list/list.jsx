import Text from "../../text/text";
import Title from "../../title/title";
import styles from "./styles.module.scss";

const List = ({ title = "", list }) => {

  return (
    <section className={styles.container}>
      <Title text={title} />
      <ul className={styles.listItemsContainer}>
        {list?.map(
          ({ name, icon, date, number, rate, text, social, nome }, i) => {
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
                {!!nome && (
                  <>
                    <img src={`../../assets/icons/${nome}.svg`} />{" "}
                    <Text isSmall={true} text={nome} />
                  </>
                )}
              </li>
            );
          }
        )}
      </ul>
    </section>
  );
};
export default List;
