import { api } from "../../api";

export async function sendMatchRequest({ id_contratante, id_freelancer }) {
  const response = await api.post("api/v1/match", {
    id_contratante,
    id_freelancer,
  });

  return response;
}

export async function getMatchsRequestByFreelancerId({
  id_freelancer,
}) {
  const response = await api.get(
    `api/v1/freelancer/${id_freelancer}/match/requests`
  );

  return response;
}
