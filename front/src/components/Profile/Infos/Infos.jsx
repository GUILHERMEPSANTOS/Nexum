import Title from "../../Title/Title";
import Text from "../../Text/Text";
import List from "../List/List";
import { INFOS, ACHIEVEMENT, HABILITIES } from "./constants";
import styles from "./styles.module.scss";

const Infos = ({ canEdit = true }) => (
  <section className={styles.container}>
    {canEdit && (
      <div className={styles.edit}>
        <img className={styles.editIcon} src="../../assets/icons/edit.svg" />
      </div>
    )}
    <Title text="Análise" />
    <br />
    <br />
    <br />
    <Text text="Informações" />
    <br />
    <List list={INFOS} />
    <br />
    <Text text="Habilidades" />
    <br />
    <List list={HABILITIES} />
    <br />
    <Text text="Consquistas" />
    <br />
    <List list={ACHIEVEMENT} />
  </section>
);

export default Infos;
