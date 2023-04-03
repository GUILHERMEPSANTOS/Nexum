import { api } from "../../api";

const getAboutUser = async (id_user) => {
  const response = await api.get(`/api/v1/user/${id_user}/sobre`);

  return response;
};

export async function putAboutUser({ id_user, sobre }) {
  const response = await api.put(`/api/v1/user/update-sobre`, {
    id_user: id_user,
    sobre: sobre,
  });

  return response;
}

const putCEP = async ({ id_freelancer, cep }) => {
  const response = await api.put(
    `/api/v1/freelancer/${id_freelancer}/update-endereco/${cep}`
  );
  return response;
};

export const getImageProfile = async ({ userId }) => {
  const response = await api.get(`/api/v1/profile-photo/${userId}`, {
    responseType: "blob",
  });

  return response;
};

export { getAboutUser, putCEP };
