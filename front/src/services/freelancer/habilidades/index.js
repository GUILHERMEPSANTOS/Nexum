import { api } from "../../api";

const listHabilidadesByUserId = async (id) => {
  const response = await api.get(`/api/v1/freelancer/${id}/habilidade/list`);
  return response;
};

const listHabilidades = async () => {
  const response = await api.get("/api/v1/habilidade");

  return response;
};

const getHabilidadeById = async (id_habilidade) => {
  const response = await api.get(`/api/v1/habilidade/${id_habilidade}`);

  return response;
};

const postHabilidades = async (data, user_id) => {
  const response = await api.post(
    `/api/v1/freelancer/${user_id}/habilidade`,
    data
  );

  return response;
};

export {
  listHabilidades,
  postHabilidades,
  listHabilidadesByUserId,
  getHabilidadeById,
};
