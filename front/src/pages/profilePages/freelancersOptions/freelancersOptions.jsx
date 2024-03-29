import FavoritosMain from "../../../components/profile/telaFavoritos/favoritos";
import Profile from "../profile";
import { FAVORITES } from "./constanst";

import styles from "./styles.module.scss";

const FreelancersOptions = () => {
  return (
    <Profile>
      <div className={styles.wrapper}>
        <div className={styles.containerList}>
          {FAVORITES.map((item) => (
            <FavoritosMain />
          ))}
        </div>
      </div>
    </Profile>
  );
};
export default FreelancersOptions;
