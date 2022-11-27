import { useMemo } from "react";

import { useQuery } from "@tanstack/react-query";
import { getMatchsRequestByFreelancerId } from "../../../services/Freelancer/match/freelancer";

import { Link } from "react-router-dom";

import Company from "../../../pages/Profile/Company/Company";

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
