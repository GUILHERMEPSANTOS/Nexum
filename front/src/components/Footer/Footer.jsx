
import Text from "../Text/Text";
import styles from "./styles.module.scss"



const FooterMain = () => {
    return (

        <footer className={styles.conteiner}>
            <div className={styles.wrapper}>
            <div className={styles.conteinerConteudo}>
                <div className={styles.sobre}>
                    <p>
                        <Text
                            text="SOBRE"
                        />
                    </p>
                    <ul>
                        <li>A Nexum conecta pessoas que buscam crescer no mercado e freelancers que desejam ser vistos pelas suas habilidades</li>
                    </ul>
                    <ul className={styles.membro}>
                        <li>TORNE-SE MEMBRO</li>
                    </ul>
                </div>
                <div className={styles.box}>
                    <p>
                        <Text
                            text="SERVIÇOS"
                        />
                    </p>
                    <ul>
                        <li>Plataforma Web</li>
                        <li>Comunidade Nexum</li>
                        <li>Sobre nós</li>
                    </ul>
                </div>
                <div className={styles.box}>
                    <p><Text
                        text="AJUDA & SUPORTE"
                    />
                    </p>
                    <ul>
                        <li>SAQ</li>
                        <li>Contate-nos</li>
                        <li>Cookies</li>
                        <li>Reporte Algo</li>
                    </ul>
                </div>
                <div className={styles.box}>
                    <p>
                        <Text
                            text="REDES SOCIAIS"
                        />
                    </p>
                    <ul className={styles.redesSociais}>
                        <li>
                            <img src="assets\imgs\instagram.png" alt="Icon instagram" />
                            Instagram
                        </li>
                        <li>
                            <img src="assets\imgs\facebook.png" alt="Icon Facebook" />
                            Facebook
                        </li>
                        <li>
                            <img src="assets\imgs\twitter.png" alt="Icon Twitter" />
                            Twitter
                        </li>
                    </ul>
                </div>
            </div>
            <hr />
            <div className={styles.finalFooter}>
                <img src="assets\imgs\logo_footer.png" alt="Logo Nexum" />
                <span>
                    COPYRIGHT © 2022 for NEXUM COMPANY - TODOS OS DIREITOS RESERVADOS
                </span>
            </div>
            </div>
        </footer>
    )
}

export default FooterMain