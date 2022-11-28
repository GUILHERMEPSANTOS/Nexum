import { api } from "../../api";

const listSocial = async (id) => {
  const response = await api.get(`api/v1/social-user/${id}`);
  return response;
};

const postSocial = async ({ id_social, user_url, id }) => {
  const response = await api.post(`api/v1/social-user/${id}`, {
    id_social: id_social,
    user_url: user_url,
  });
  return response;
};

export { listSocial, postSocial };
