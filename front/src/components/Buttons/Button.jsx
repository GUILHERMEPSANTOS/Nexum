import { Link } from "react-router-dom";
import styles from "./styles.module.scss";

const Button = ({ text, isEmpty, link, type }) => {
  return (
    <Link to={link}>
      <button
        type={type}
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
