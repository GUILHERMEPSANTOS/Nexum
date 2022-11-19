import Banner from "../../Banner/Banner";
import { TEXTS, OPTIONS } from "./constants"
import Title from "../../Title/Title";
import CardMain from "../CardTelaInicio/card";
import styles from "./styles.module.scss"
import Header from "../../Header/Header";

const InicioMain = () => {

const data = localStorage.getItem("id")

console.log(data)

    return (<div>
             <Header options={OPTIONS} buttonText="Sair" link="/" />s
        <Banner>
            <div className={styles.conteiner}>
                <div className={styles.mensagem}>

                    <Title
                        text="Olá, Ana Carolina, te desejamos uma ótima expêriencia"
                    />

                </div>
                <div className={styles.containerCards}>
                    {TEXTS.map(({ title, text }) => (

                        <CardMain  title={title} text={text} />
                    ))}

                </div>
            </div>
        </Banner>
        </div>
    )
}

export default InicioMain;