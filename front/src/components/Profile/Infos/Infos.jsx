import Title from "../../Title/Title";
import Text from "../../Text/Text";
import List from "../List/List";
import { INFOS, ACHIEVEMENT, HABILITIES } from "./constants";
import styles from "./styles.module.scss";

const Infos = ({canEdit = true}) => (
  <section className={styles.container}>
     {canEdit && 
     <div className={styles.edit}>
       <img className={styles.editIcon} src="../../assets/icons/edit.svg" />
       <img className={styles.editIcon} src="../../assets/icons/add.svg" />
     </div>
        }
    <Title text="Análise" />
    <Text text="Informações" />
    <List list={INFOS} />
    <Text text="Habilidades" />
    <List list={HABILITIES} />
    <Text text="Consquistas" />
    <List list={ACHIEVEMENT} />
  </section>
);

export default Infos;
