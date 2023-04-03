import { api } from "../api";

const countFreelancers = async () => {
  const response = await api.get(`/api/v1/dashboard/count-freelancers`);

  return response.data;
};

const countContratantes = async () => {
  const response = await api.get(`/api/v1/dashboard/count-contratantes`);

  return response;
};

export { countContratantes, countFreelancers };
