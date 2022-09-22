import styles from "./styles.module.scss";

const Button = ({ text, isPink = false }) => {
  return (
    <button
      className={
        isPink ? styles.buttonFillBackground : styles.buttonEmptyBackground
      }
    >
      {text}
    </button>
  );
};

export default Button;
