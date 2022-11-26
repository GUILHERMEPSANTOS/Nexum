import Title from "../../Title/Title";
import Text from "../../Text/Text";
import styles from "./styles.module.scss";
import { EXPERIENCE } from "./constants";

const Experience = ({canEdit, canAdd}) => {
    return(
        <section className={styles.container}>
            <div className={styles.containerAdd}>
                <Title text="Experiência"/>
                {canAdd && (
                    <div className={styles.add}>
                        <img
                        onClick={() => setEditDegrees(true)}
                        className={styles.editIcon}
                        src="../../assets/icons/add.svg"
                        />
                    </div>
                )}
            </div>
            {EXPERIENCE.map(({icon, area, name, location, date, about}) => (
                <div>
                    <div className={styles.wrapperContainer}>
                        <div className={styles.wrapper}>
                            <img src={`../../assets/icons/${icon}.jpg`} />
                            <div className={styles.contantContainer}>
                                <div>
                                    <Text text={area}/>
                                    <Text text={name}/>
                                </div>
                            </div>
                        </div>
                        {canEdit && (
                            <div className={styles.edit}>
                                <img
                                onClick={() => setEditDegrees(true)}
                                className={styles.editIcon}
                                src="../../assets/icons/edit.svg"
                                />
                            </div>
                        )}
                    </div>
                    <Text text={location} isSmall={true} />
                    <Text text={date} isSmall={true} />
                    <Text text={about} isSmall={true} />
                </div>
            ))}
        </section>
    );
};

export default Experience;