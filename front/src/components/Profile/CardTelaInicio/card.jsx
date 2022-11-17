import { Link } from "react-router-dom";
import Text from "../../Text/Text";
import styles from "./styles.module.scss"

const CardMain = ({title, text}) => {
    return (
        <div className={styles.containerCard}>
            <Link to="/escolha-freelancer">
            <p className={styles.texto}>
                <Text
                text={title}
                />
                <Text 
                text={text}
                />
            </p>
            </Link>
            <img src="../../../assets/imgs/iconCard.png" alt="icon card" />
        </div>
    )
}

export default CardMain