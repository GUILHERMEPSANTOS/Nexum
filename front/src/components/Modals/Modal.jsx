import styles from "./styles.module.scss";
import Text from "../text/text";
import { redirect } from "react-router-dom";

const Modal = ({
  text,
  label,
  children,
  actualState,
  setActualState,
  offers,
}) => {
  return (
    <section style={{ display: actualState ? "block" : "none" }}>
      <section className={styles.background}> </section>
      <div className={styles.modal}>
        <div>
          <Text text={text} />
          <div
            onClick={() => {
              setActualState(false);
              if (offers) {
                window.location.href = "http://127.0.0.1:5173/inicio";
              }
            }}
            className={styles.close}
          >
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
