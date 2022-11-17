import About from "../../../components/Profile/About/Profile";
import Degrees from "../../../components/Profile/Degrees/Profile";
import Infos from "../../../components/Profile/Infos/Infos";
import styles from "./styles.module.scss";


import { getFreelancerById } from '../../../services/Freelancer/freelancer';
import { useEffect, useState } from "react";


const Freelancer = () => {
  const [freelancer, setFreelancer] = useState({});


  useEffect(() => {
      const response = getFreelancerById(2);

      if(response)
      setFreelancer(response);
  },[getFreelancerById]);

  return (
    <section className={styles.container}>
      <About />
      <Infos />
      <Degrees />
    </section>
  );
};

export default Freelancer;
