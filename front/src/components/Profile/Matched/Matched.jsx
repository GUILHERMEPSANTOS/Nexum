import { useMemo } from "react";

import { useQuery } from "@tanstack/react-query";
import { getMatchsRequestByFreelancerId } from "../../../services/Freelancer/match/freelancer";
import { OPTIONS } from "./constants";

import Company from "../../../pages/Profile/Company/Company";
import Header from "../../Header/Header";

const Matched = () => {
  const userId = useMemo(() => localStorage.getItem("user_id"));

  const { data, isLoading } = useQuery(
    ["consultar solicitações de match"],
    () => getMatchsRequestByFreelancerId({ id_freelancer: userId })
  );

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return (
    <>
      <Header options={OPTIONS} buttonText="Sair" link="/" />
      {data?.data.map(({ email, endereco, nome, sobre, socialsUserDTO }) => {
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
          />
        );
      })}
    </>
  );
};

export default Matched;
