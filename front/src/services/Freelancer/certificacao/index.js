import { api } from "../../api";

const listCertificadoByFreelancerId = async (id) => {
  const response = await api.get(`/api/v1/certificacao/list/freelancer/${id}`);

  return response.data;
};

export { listCertificadoByFreelancerId }