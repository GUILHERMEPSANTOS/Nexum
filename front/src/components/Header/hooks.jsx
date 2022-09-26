import { useState } from "react";
import styles from "./styles.module.scss";

const useChange = () => {
  const [position, setPosition] = useState();

  window.onscroll = () => {
    let top = window.scrollY;
    top > 180
      ? setPosition(styles.containerFill)
      : setPosition(styles.containerEmpty);
  };

  return {
    position,
  };
};

export default useChange;
