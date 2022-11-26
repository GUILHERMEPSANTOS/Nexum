import { api } from "../api";

const getFreelancerById = async (id = 1) => {
  const response = await api.get(`/api/v1/freelancer/${id}`);

  return response.data;
};
const getFreelancer = async () => {
  const response = await api.get(`/api/v1/freelancer/list`);

  return response.data;
};


export {
  getFreelancerById,
  getFreelancer,
};
