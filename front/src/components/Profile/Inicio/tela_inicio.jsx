import Banner from "../../Banner/Banner";
import Text from "../../Text/Text";
import Title from "../../Title/Title";
import styles from "./styles.module.scss"

const InicioMain = () => {
    return (
        <Banner>
            <div className={styles.conteiner}>
                <div className={styles.mensagem}>
                    <p>
                        <Title
                            text="Olá, Ana Carolina, te desejamos uma ótima expêriencia"
                        />
                    </p>
                </div>
            </div>
        </Banner>
    )
}

export default InicioMain;