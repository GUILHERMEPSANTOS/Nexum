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
  const response = await api.post(`api/v1/experiencia/${id}`, {
    curso,
    instituicao,
    cidade,
    estado,
    certificacao_url,
  });
  return response;
};
export { listCertificadoByFreelancerId, postCertificado };
