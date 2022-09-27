import Banner from "../Banner/Banner";
import Title from "../Title/Title";
import Text from "../Text/Text";
import Button from "../Buttons/Button";
import Styles from "./styles.modules.scss"



const FooterMain = () => {
    return (

        <div className="conteiner">
            <div className="conteinerConteudo">
                <div className="sobre">
                    <p>
                        <Text
                            text="Sobre"
                        />
                    </p>
                    <ul>
                        <li>A Nexum conecta pessoas que buscam crescer no mercado e freelancers que desejam ser vistos pelas suas habilidades</li>
                    </ul>
                    <ul className="membro">
                        <li>TORNE-SE MEMBRO</li>
                    </ul>
                </div>
                <div className="box">
                    <p>
                        <Text
                            text="SERVIÇOES"
                        />
                    </p>
                    <ul>
                        <li>Plataforma Web</li>
                        <li>Comunidade Nexum</li>
                        <li>Sobre nós</li>
                    </ul>
                </div>
                <div className="box">
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
                <div className="box">
                    <p>
                        <Text
                            text="REDES SOCIAIS"
                        />
                    </p>
                    <ul className="redesSociais">
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
            <div className="finalFooter">
                <img src="assets\imgs\logo_footer.png" alt="Logo Nexum" />
                <span>
                    COPYRIGHT © 2022 for NEXUM COMPANY - TODOS OS DIREITOS RESERVADOS
                </span>
            </div>

        </div>
    )
}

export default FooterMain