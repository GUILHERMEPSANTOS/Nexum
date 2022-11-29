import { api } from "../../api";

const listSocialByUserId = async (id) => {
  const response = await api.get(`api/v1/social-user/${id}`);
  return response;
};

const listSocial = async () => {
  const response = await api.get("api/v1/social");

  return response;
};

const postSocial = async (data, user_id) => {
  const response = await api.post(`api/v1/social-user/${user_id}`, data);

  return response;
};

export { listSocialByUserId, postSocial, listSocial };
