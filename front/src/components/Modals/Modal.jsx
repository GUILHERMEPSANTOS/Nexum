import styles from "./styles.module.scss";
import Text from "../Text/Text";

const Modal = ({ text, label, children, actualState, setActualState }) => {
  return (
    <section style={{ display: actualState ? "block" : "none" }}>
      <section className={styles.background}> </section>
      <div className={styles.modal}>
        <div>
          <Text text={text} />
          <div onClick={() => setActualState(false)} className={styles.close}>
            <img
              className={styles.losangleIcon}
              src="../../../assets/icons/losangle-icon.svg"
            />
            <img
              className={styles.xIcon}
              src="../../../assets/icons/x-icon.svg"
            />
          </div>
        </div>
        <Text isSmall={true} text={label} />
        <div>{children}</div>
      </div>
    </section>
  );
};

export default Modal;
