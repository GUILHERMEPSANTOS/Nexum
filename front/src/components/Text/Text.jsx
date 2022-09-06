import styles from "./styles.module.scss";

const Text = ({ text, upperCase }) => {
  return <p className={upperCase ? styles.upperCase : styles.text}>{text}</p>;
};

export default Text;
