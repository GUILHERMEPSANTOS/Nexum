import { api } from "../api";

const getFreelancerById = async (id = 1) => {
  const response = await api.get(`/api/v1/freelancer/${id}`);

  return response.data;
};

const listCertificadoByFreelancerId = async (id = 2) => {
  const response = await api.get(`/api/v1/certificacao/list/freelancer/${id}`);

  return response.data;
};

const listFormacaoByFreelancerId = async (id = 2) => {
  const response = await api.get(`/api/v1/formacao/list/freelancer/${id}`);

  return response.data;
};

const listExperienciaByFreelancerId = async (id = 2) => {
  const response = await api.get(`/api/v1/experiencia/list/freelancer/${id}`);

  return response.data;
};

export { getFreelancerById, listCertificadoByFreelancerId,listFormacaoByFreelancerId,listExperienciaByFreelancerId,  };
