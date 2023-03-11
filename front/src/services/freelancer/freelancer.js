import { api } from "../api";

const getFreelancerById = async (id) => {
  const response = await api.get(`/api/v1/freelancer/${id}`);

  return response.data;
};
const getContratanteById = async (id) => {
  const response = await api.get(`/api/v1/contratante/${id}`);

  return response.data;
};

const getFreelancers = async () => {
  const response = await api.get(`/api/v1/freelancer/list`);

  return response;
};

const postProfilePhoto = async ({ base64Image, file, userId }) => {
  const response = await api.post(`/api/v1/profile-photo/upload`, {
    userId,
    data: base64Image,
    fileName: file.name,
  });

  return response;
};

export {
  getFreelancerById,
  getFreelancers,
  getContratanteById,
  postProfilePhoto,
};
