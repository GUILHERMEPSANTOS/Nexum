import { useMemo } from "react";

import { useQuery } from "@tanstack/react-query";
import { getMatchsRequestByFreelancerId } from "../../../services/freelancer/match/freelancer";
import { OPTIONS } from "./constants";
import styles from "./styles.module.scss";

import Company from "../../../pages/profile/company/company";
import Header from "../../header/header";
import { Loading } from "../../loading/loading";

const Matched = () => {
  const userId = useMemo(() => localStorage.getItem("user_id"));

  const { data, isLoading } = useQuery(
    ["consultar solicitações de match"],
    () => getMatchsRequestByFreelancerId({ id_freelancer: userId })
  );

  if (isLoading) {
    return <Loading />;
  }
  console.log(data?.data.length);

  return (
    <>
      <Header options={OPTIONS} buttonText="Sair" link="/" />
      {data?.data.length > 0 ? (
        data?.data.map(
          ({ email, endereco, nome, sobre, socialsUserDTO, id_user }) => {
            return (
              <Company
                nomeCompany={nome}
                emailCompany={email}
                enderecoCompany={endereco}
                sobreCompany={sobre}
                socialCompany={socialsUserDTO}
                canEdit={false}
                isCompanyProfile={true}
                isOtherView={true}
                idCompany={id_user}
              />
            );
          }
        )
      ) : (
        <div className={styles.container}>
          <h1 className={styles.sorry}>Ainda não há matchs</h1>
          <div className={styles.img}>
            <img src="https://media.tenor.com/XqKgFl1R4YcAAAAM/peach-sad.gif" />
          </div>
        </div>
      )}
    </>
  );
};

export default Matched;
