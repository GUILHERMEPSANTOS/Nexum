import Title from "../../Title/Title";
import Text from "../../Text/Text";
import styles from "./styles.module.scss";
import { FORMATION } from "./constants";

const Formation = ({ canEdit = true }, { canAdd = true }) => {
    return(
        <section className={styles.container}>
            <div className={styles.containerAdd}>
                <Title text="Formação"/>
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
            {FORMATION.map(({icon, institution, UniversityDegree, location, date, about}) => (
                <div>
                    <div className={styles.wrapperContainer}>
                        <div className={styles.wrapper}>
                            <img src={`../../assets/icons/${icon}.png`} />
                            <div className={styles.contantContainer}>
                                <div>
                                    <Text text={institution}/>
                                    <Text text={UniversityDegree}/>
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

export default Formation;