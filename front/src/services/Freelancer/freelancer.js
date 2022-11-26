import { api } from "../api";

const getFreelancerById = async (id) => {
  const response = await api.get(`/api/v1/freelancer/${id}`);

  return response.data;
};

const getFreelancers = async () => {
  const response = await api.get(`/api/v1/freelancer/list`);
  console.log(response);
  return response;
};


export {
  getFreelancerById,
  getFreelancers,
};
