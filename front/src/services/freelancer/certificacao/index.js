import { api } from "../../api";

const listCertificadoByFreelancerId = async (id) => {
  const response = await api.get(`/api/v1/certificacao/list/freelancer/${id}`);
  return response;
};

const postCertificado = async ({
  curso,
  instituicao,
  cidade,
  estado,
  certificacao_url,
  id,
}) => {
  const response = await api.post(`api/v1/certificacao/${id}`, {
    curso: curso,
    instituicao: instituicao,
    cidade: cidade,
    estado: estado,
    certificacao_url: certificacao_url,
  });
  return response;
};

const putCertificado = async ({
  curso,
  instituicao,
  cidade,
  estado,
  certificacao_url,

  id,
}) => {
  const response = await api.put(`api/v1/certificacao/${id}`, {
    curso: curso,
    instituicao: instituicao,
    cidade: cidade,
    estado: estado,
    certificacao_url: certificacao_url,
  });
  return response;
};
export { listCertificadoByFreelancerId, postCertificado, putCertificado };
