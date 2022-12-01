import { api } from "../../api";

const getAboutUser = async (id_user) => {
  const response = await api.get(`api/v1/user/${id_user}/sobre`);

  return response;
};

export async function putAboutUser({
  id_user, sobre
}) {
  console.log(id_user, sobre)
  const response = await api.put(`api/v1/user/update-sobre`,  {
    id_user: id_user,
    sobre:sobre
  }
  );
console.log(response)
  return response;
}

const putCEP = async ({id_freelancer, cep}) => {
  const response = await api.put(`api/v1/freelancer/${id_freelancer}/update-endereco/${cep}`);
  return response
}

export { getAboutUser, putCEP };
