import Text from "../text/text";

import styles from "./styles.module.scss";

const Footer = () => {
  return (
    <div className={styles.conteiner}>
      <div className={styles.conteinerConteudo}>
        <div className={styles.sobre}>
          <Text text="Sobre" />

          <ul>
            <li>
              A Nexum conecta pessoas que buscam crescer no mercado e
              freelancers que desejam ser vistos pelas suas habilidades
            </li>

            <li className={styles.membro}>TORNE-SE MEMBRO</li>
          </ul>
        </div>
        <div className={styles.box}>
          <Text text="SERVIÇOES" />

          <ul>
            <li>Plataforma Web</li>
            <li>Comunidade Nexum</li>
            <li>Sobre nós</li>
          </ul>
        </div>
        <div className={styles.box}>
          <Text text="AJUDA & SUPORTE" />
          <ul>
            <li>SAQ</li>
            <li>Contate-nos</li>
            <li>Cookies</li>
            <li>Reporte Algo</li>
          </ul>
        </div>
        <div className={styles.box}>
          <Text text="REDES SOCIAIS" />

          <ul className={styles.redesSociais}>
            <li>
              <img
                src="../../../public/assets/icons/instagram.svg"
                alt="Icon instagram"
              />
              Instagram
            </li>
            <li>
              <img
                src="../../../public/assets/icons/facebook.svg"
                alt="Icon Facebook"
              />
              Facebook
            </li>
            <li>
              <img
                src="../../../public/assets/icons/twitter.svg"
                alt="Icon Twitter"
              />
              Twitter
            </li>
          </ul>
        </div>
      </div>
      <div className={styles.finalFooterContainer}>
        <hr />
        <div className={styles.finalFooter}>
          <img src="assets\imgs\logo_footer.png" alt="Logo Nexum" />
          <span>
            COPYRIGHT © 2022 for NEXUM COMPANY - TODOS OS DIREITOS RESERVADOS
          </span>
        </div>
      </div>
    </div>
  );
};

export default Footer;
