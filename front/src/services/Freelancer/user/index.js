import { api } from "../../api";

const getAboutUser = async (id_user) => {
  const response = await api.get(`api/v1/user/${id_user}/sobre`);

  return response;
};

export { getAboutUser };
