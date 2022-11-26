import { api } from "../../api";

const listFormacaoByFreelancerId = async (id = 2) => {
  const response = await api.get(`/api/v1/formacao/list/freelancer/${id}`);

  return response.data;
};

export { listFormacaoByFreelancerId }