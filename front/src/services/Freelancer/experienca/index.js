import { api } from "../../api";

const listExperienciaByFreelancerId = async (id) => {
  console.log(id, `teste`);
  const response = await api.get(`/api/v1/experiencia/list/freelancer/${id}`);

  return response.data;
};

export { listExperienciaByFreelancerId };
