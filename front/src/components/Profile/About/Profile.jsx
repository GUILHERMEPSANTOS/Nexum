import styles from "./styles.module.scss";
import Title from "../../Title/Title";
import Text from "../../Text/Text";
import { SOCIAL_MEDIA } from "./constants";

const About = ({ isCompanyView = true }) => {
  return (
    <section className={styles.container}>
      <div>
        <img
          className={styles.imgProfile}
          src="../../assets/imgs/person-card-1.png"
        />
        <Title text={"Ana Carolina"} />
        <div className={styles.location}>
          <img src="../../assets/icons/location.png" />
          <Text isSmall={true} text="Osasco, São Paulo" />
        </div>
        <Text text="Designer" />

        {isCompanyView && (
          <div className={styles.actions}>
            <button>
              <img src="../../assets/icons/back.svg" />
            </button>
            <button>
              <img src="../../assets/icons/like.svg" />
            </button>
            <button>
              <img src="../../assets/icons/save.svg" />
            </button>
          </div>
        )}
      </div>
      <div className={styles.aboutContainer}>
        <Title text="Sobre" />
        <Text
          text="Curabitur tempus lacus in quam laoreet, eget finibus orci pharetra. Sed molestie leo eget urna egestas tristique ed molestie leo eget urna egestas tristique lacus in quam laoreet eget urna egestas tristique ed molestie leo eget urna egestas.
Curabitur tempus lacus in quam laoreet, eget finibus orci pharetra. Sed molestie leo eget urna egestas tristique. Sed molestie leo eget urna egestas tristique."
        />
        <Title text="Redes sociais" />
        <div className={styles.socialMediaContainer}>
          {SOCIAL_MEDIA.map(({ name, icon }) => (
            <div className={styles.socialMedia}>
              <img src={`../../assets/icons/${icon}.svg`} />
              <Text isSmall={true} text={name} />
            </div>
          ))}
        </div>
        <Title text="Email" />
        <div className={styles.socialMedia}>
          <Text isSmall={true} text="anacarolina2001@gmail.com.br" />
        </div>
      </div>
    </section>
  );
};

export default About;