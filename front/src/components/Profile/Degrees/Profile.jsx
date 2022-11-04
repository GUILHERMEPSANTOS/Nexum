import Button from "../../Buttons/Button";
import Title from "../../Title/Title";
import Text from "../../Text/Text";
import { DEGREES } from "./constants";
import styles from "./styles.module.scss";

const Degrees = ({canEdit = true}) => {
  return (
  <section className={styles.container} >
      {canEdit && 
     <div className={styles.edit}>
       <img className={styles.editIcon} src="../../assets/icons/edit.svg" />
       <img className={styles.editIcon} src="../../assets/icons/add.svg" />
     </div>
        }
  <Title text="Certificações"/>
  {DEGREES.map(({name, icon, text, location}) => (
<div>
  <div className={styles.wrapper}>
<img src={`../../assets/icons/${icon}.svg`}/>
<div className={styles.contentContainer}>
  <div>
<Text text={name}/>
<Text text={text} isSmall={true}/>
</div>
<Button text="ver credenciais"/>
</div>
</div>
<Text text={location} isSmall={true}/>
</div>
  ))}
  </section>
  );
};

export default Degrees;
