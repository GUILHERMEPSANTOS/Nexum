import useChange from "./hooks";
import Button from "../Buttons/Button";
import { Link } from "react-router-dom";
import styles from "./styles.module.scss";

const Header = ({ options, buttonText,buttonTextLogin }) => {
  const { position } = useChange();

  return (
    <header className={position}>
      <nav className={styles.navigation}>
        <img src="../../../assets/imgs/company.png" alt="Nexum" />
        <ul>
          {options.map((options) => (
            <li>
              {options}
              <div></div>
            </li>
          ))}
          <div className={styles.buttons}>
            { buttonTextLogin &&
            <li>
              <Link to="/login"> Entrar</Link>
            </li>

            }
            <li>
              <Button link="/cadastro" text={buttonText} />
            </li>
          </div>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
