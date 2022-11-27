import { api } from "../../api";

const listFormacaoByFreelancerId = async (id) => {
  const response = await api.get(`/api/v1/formacao/list/freelancer/${id}`);
  return response;
};

const postFormacao = async ({
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

export { listFormacaoByFreelancerId, postFormacao };
