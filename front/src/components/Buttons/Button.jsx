import styles from "./styles.module.scss";

const Button = ({ text, isEmpty, type }) => {
  return (
    <button
      type={type}
      className={
        isEmpty ? styles.buttonEmptyBackground : styles.buttonFillBackground
      }
    >
      {text}
    </button>
  );
};

export default Button;
