import styles from "./styles.module.scss";
import { ITEMS } from "./constants";
import Title from "../title/title";
import Text from "../text/text";
import { useQuery } from "@tanstack/react-query";
import {
  countFreelancers,
  countContratantes,
} from "../../services/dashboard/dashboard";
const Info = () => {
  const {
    data: dataFreela,
    isLoading: isLoadingFreela,
    refetch: refetchFreela,
  } = useQuery(["count freela"], async () => await countFreelancers());

  const {
    data: dataContratante,
    isLoading: isLoadingContratante,
    refetch: refetchContratante,
  } = useQuery(["count contratante"], async () => await countContratantes());

  console.log(dataContratante);
  return (
    <div className={styles.wrapper}>
      <section className={styles.background}>
        <img src={`../../assets/icons/logo.png`} alt="Nexum" />
        <hr className={styles.line} />
        {ITEMS.map(({ title, text, icon }, i) => (
          <div key={`${title} - ${i}`} className={styles.card}>
            <Text text={title} />
            <Text text={text} isSmall={true} />
            <div className={styles.container}>
              <img src={`../../assets/icons/${icon}.png`} alt={title} />
              {title == "Freelancers" ? (
                <h1 className={styles.title}>{dataFreela} </h1>
              ) : (
                <h1 className={styles.title}>{dataContratante?.data} </h1>
              )}
            </div>
          </div>
        ))}
      </section>
    </div>
  );
};

export default Info;
