import { api } from "../../api";

const listExperienciaByFreelancerId = async (id) => {
  const response = await api.get(`/api/v1/experiencia/list/freelancer/${id}`);

  return response;
};
const postExperiencia = async ({
  cargo,
  empresa,
  cidade,
  estado,
  sobre,
  data_inicial,
  data_final,
  id,
}) => {
  const response = await api.post(`api/v1/experiencia/${id}`, {
    cargo,
    empresa,
    cidade,
    estado,
    sobre,
    data_inicial,
    data_final,
  });
  return response;
};
export { listExperienciaByFreelancerId, postExperiencia };
