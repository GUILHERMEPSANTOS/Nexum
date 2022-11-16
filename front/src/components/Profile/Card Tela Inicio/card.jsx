import Text from "../../Text/Text";
import styles from "./styles.module.scss"

const CardMain = () => {
    return (
        <div className={styles.containerCard}>
            <p className={styles.texto}>
                <Text
                text="Clique aqui para visualizar"
                />
                <Text 
                text="Propostas"
                />
            </p>
            <img src="../../../assets/imgs/iconCard.png" alt="icon card" />
        </div>
    )
}

export default CardMain