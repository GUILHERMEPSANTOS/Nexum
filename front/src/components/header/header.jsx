import useChange from "./hooks";
import Button from "../buttons/button";
import { Link } from "react-router-dom";
import styles from "./styles.module.scss";

const Header = ({ options, buttonText, buttonTextLogin, link }) => {
  const { position } = useChange();
  return (
    <header className={position}>
      <nav className={styles.navigation}>
        <img src="../../../assets/imgs/company.png" alt="Nexum" />
        <ul>
          {options.map(({ name, path }, i) => (
            <Link key={`${name} - ${i}= ${path} `} to={path}>
              <li>
                {name}
                <div></div>
              </li>
            </Link>
          ))}
          <div className={styles.buttons}>
            {buttonTextLogin && (
              <li>
                <Link to="/login"> Entrar</Link>
              </li>
            )}
            <li>
              <Button link={link} text={buttonText} />
            </li>
          </div>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
