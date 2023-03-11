import styles from "./styles.module.scss";

const Text = ({ text, upperCase, isSmall }) => {
  return (
    <p
      className={
        upperCase ? styles.upperCase : isSmall ? styles.textSmall : styles.text
      }
    >
      {text}
    </p>
  );
};

export default Text;
