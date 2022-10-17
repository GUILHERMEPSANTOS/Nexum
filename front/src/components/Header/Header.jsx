import useChange from "./hooks";
import Button from "../Buttons/Button";
import { Link } from "react-router-dom";
import styles from "./styles.module.scss";

const Header = () => {
  const { position } = useChange();

  return (
    <header className={position}>
      <nav className={styles.navigation}>
        <img src="../../../assets/imgs/company.png" alt="Nexum" />
        <ul>
          <li>
            Início<div></div>
          </li>
          <li>
            Sobre nós<div></div>
          </li>
          <li>
            Freelancer<div></div>
          </li>
          <li>
            Contratante<div></div>
          </li>
          <li>
            Contato<div></div>
          </li>
          <div className={styles.buttons}>
            <li>
              <Link to="/login"> Entrar</Link>
            </li>
            <li>
              <Button link="/cadastro" text="Criar conta" />
            </li>
          </div>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
