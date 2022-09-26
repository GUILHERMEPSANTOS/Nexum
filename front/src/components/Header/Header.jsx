import Button from "../Buttons/Button";
import useChange from "./hooks";
import styles from "./styles.module.scss";

const Header = () => {
  const { position } = useChange();

  return (
    <header className={position}>
      <nav className={styles.navigation}>
        <img src="../../../assets/imgs/company.png" alt="Nexum" />
        <ul>
          <li>Início</li>
          <li>Sobre nós</li>
          <li>Freelancer</li>
          <li>Contratante</li>
          <li>Contato</li>
          <div className={styles.buttons}>
            <li>Entrar</li>
            <li>
              <Button text="Criar conta" />
            </li>
          </div>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
