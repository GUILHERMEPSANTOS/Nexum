import { Link } from "react-router-dom";
import styles from "./styles.module.scss";

const Button = ({ text, isEmpty, link }) => {
  return (
    <Link to={link}>
      <button
        className={
          isEmpty ? styles.buttonEmptyBackground : styles.buttonFillBackground
        }
      >
        {text}
      </button>
    </Link>
  );
};

export default Button;
