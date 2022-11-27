import { api } from "../../api";

export async function sendMatchRequest({ id_contratante, id_freelancer }) {
  const response = await  api.post("api/v1/match", {
      id_contratante,
      id_freelancer
    });

  return response;
}
