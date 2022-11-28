import { api } from "../../api";

const listFormacaoByFreelancerId = async (id) => {
  const response = await api.get(`/api/v1/formacao/list/freelancer/${id}`);
  return response;
};

const postFormacao = async ({
  curso,
  instituicao,
  cidade,
  estado,
  sobre,
  data_inicial,
  data_final,
  id,
}) => {
  const response = await api.post(`api/v1/formacao/${id}`, {
    curso: curso,
    instituicao: instituicao,
    cidade: cidade,
    estado: estado,
    sobre: sobre,
    data_inicial: data_inicial,
    data_final: data_final,
  });
  return response;
};
const putFormacao = async ({
  curso,
  instituicao,
  cidade,
  estado,
  sobre,
  data_inicial,
  data_final,
  id,
}) => {
  const response = await api.put(`api/v1/formacao/${id}`, {
    curso: curso,
    instituicao: instituicao,
    cidade: cidade,
    estado: estado,
    sobre: sobre,
    data_inicial: data_inicial,
    data_final: data_final,
  });
  return response;
};

export { listFormacaoByFreelancerId, postFormacao, putFormacao };
