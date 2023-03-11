import List from "../list/list";
import { HABILITIES } from "./constants";
import styles from "./styles.module.scss";

const FavoritosMain = () => {
  return (
    <div className={styles.container}>
      <div className={styles.usuario}>
        <img
          src="../../../../assets/imgs/person-card-1.png"
          alt="Foto de perfil user"
          className={styles.imgUser}
        />
        <div>
          <p className={styles.nickName}>Abel Medeiros</p>
          <ul className={styles.fonte}>
            <li>
              <img
                src="../../../../assets/icons/location.png"
                alt="Icon de localização"
                className={styles.iconLocalizacao}
              />
              Mauá, São Paulo
            </li>
            <li>Designer</li>
          </ul>
        </div>
      </div>
      <div className={styles.containerDecritivo}>
        <div className={styles.descricao}>
          <p className={styles.nickName}>Sobre</p>
          <p className={styles.bio}>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Excepturi
            facere tempore earum minus, ipsum ducimus!
          </p>
        </div>
        <div className={styles.competencia}>
          <div className={styles.list}>
            <List list={HABILITIES} title={"Habilidades"} />
          </div>
        </div>
      </div>
    </div>
  );
};

export default FavoritosMain;
