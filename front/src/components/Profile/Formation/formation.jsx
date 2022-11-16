import Title from "../../Title/Title";
import Text from "../../Text/Text";
import styles from "./styles.module.scss";
import { FORMATION } from "./constants";

const Formation = () => {
    return(
        <section className={styles.container}>
            <Title text="Experiência"/>
            {EXPERIENCE.map(({icon, area, name, location, date, about}) => (
                <div>
                    <div className={styles.wrapper}>
                        <img src={`../../assets/icons/${icon}.svg`} />
                        <div className={syles.contantContainer}>
                            <div>
                                <Text text={institution}/>
                                <Text text={UniversityDegree}/>
                            </div>
                        </div>
                    </div>
                    <Text text={location} isSmall={true} />
                    <Text text={date} isSmall={true} />
                    <Text text={about} isSmall={true} />
                </div>
            ))}
        </section>
    );
};

export default Formation;