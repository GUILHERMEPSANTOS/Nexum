import { api } from "../../api";

export function postMatch({ id_contratante, id_freelancer }) {
  api
    .post("/api/v1/match", {
      id_contratante: id_contratante,
      id_freelancer: id_freelancer,
    })
    .then((response) => displayOutput(response))
    .catch((err) => console.log(err));
}
