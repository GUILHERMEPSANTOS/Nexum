import { Link } from "react-router-dom";
import Text from "../../text/text";
import styles from "./styles.module.scss";

const CardMain = ({ title, text, link }) => {
  return (
    <div className={styles.containerCard}>
      <Link to={link}>
        <Text text={title} />
        <Text text={text} />
      </Link>
      <img src="../../../assets/imgs/iconCard.png" alt="icon card" />
    </div>
  );
};

export default CardMain;
