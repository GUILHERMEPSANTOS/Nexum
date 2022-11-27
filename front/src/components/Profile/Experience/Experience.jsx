import Title from "../../Title/Title";
import Text from "../../Text/Text";
import styles from "./styles.module.scss";
import { EXPERIENCE } from "./constants";
import EditExperience from "../../Modals/EditExperience/EditExperience";
import { useEffect, useState } from "react";
import { listExperienciaByFreelancerId } from "../../../services/Freelancer/experienca";

const Experience = ({ canEdit = true }) => {
  const [editExperience, setEditExperience] = useState(false);
  const [experience, setExperience] = useState();
  const perfil = localStorage.getItem("role");
  const id = localStorage.getItem("user_id");

  console.log(id, `id`, experience);
  useEffect(() => {
    if (perfil == `"ROLE_FREELANCER"`) setExperience(id);
  }, []);
  async function experiencia() {
    return await listExperienciaByFreelancerId(experience);
  }
  const data = experiencia();
  console.log(data);
  useState(() => {
    experiencia();
  }, [experiencia]);
  return (
    <>
      <section className={styles.container}>
        <div className={styles.containerAdd}>
          <Title text="Experiência" />
          {canEdit && (
            <div className={styles.add}>
              <img
                onClick={() => setEditExperience(true)}
                className={styles.editIcon}
                src="../../assets/icons/add.svg"
              />
            </div>
          )}
        </div>
        {EXPERIENCE.map(({ icon, area, name, location, date, about }) => (
          <div>
            <div className={styles.wrapperContainer}>
              <div className={styles.wrapper}>
                <img src={`../../assets/icons/${icon}.jpg`} />
                <div className={styles.contantContainer}>
                  <div>
                    <Text text={area} />
                    <Text text={name} />
                  </div>
                </div>
              </div>
              {canEdit && (
                <div className={styles.edit}>
                  <img
                    onClick={() => setEditExperience(true)}
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
      {editExperience && (
        <EditExperience
          actualState={editExperience}
          setActualState={setEditExperience}
        />
      )}
    </>
  );
};

export default Experience;
