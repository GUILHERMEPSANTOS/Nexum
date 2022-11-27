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
  console.log(data);
  return (
    <>
      {data?.data.map(() => (
        <Company canEdit={false} isFreela={true} />
      ))}
    </>
  );
};

export default Matched;
