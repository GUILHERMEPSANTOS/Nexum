import Banner from "../../Banner/Banner";
import Text from "../../Text/Text";
import Title from "../../Title/Title";
import CardMain from "../CardTelaInicio/card";
import styles from "./styles.module.scss"

const InicioMain = () => {
    return (
        <Banner>
            <div className={styles.conteiner}>
                <div className={styles.mensagem}>
                    
                        <Title
                            text="Olá, Ana Carolina, te desejamos uma ótima expêriencia"
                        />
                   
                </div>
                <CardMain title="busque a experiencia" text="veja propostas"/>
                <CardMain title="busque a experiencia" text="veja propostas"/>
                <CardMain title="busque a experiencia" text="veja propostas"/>
            </div>
        </Banner>
    )
}

export default InicioMain;