import { Link } from "react-router-dom";
import styles from "./styles.module.scss";

const Button = ({ text, isEmpty, link, type, onClick, disabled }) => {
  return (
    <Link to={link}>
      <button
        disabled={disabled ? true : ""}
        type={type}
        onClick={onClick}
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
