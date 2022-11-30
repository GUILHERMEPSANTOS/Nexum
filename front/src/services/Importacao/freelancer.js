import { api } from "../api";

const setUpload = async ({ file }) => {
  const response = await api.post(`/api/v1/upload/`, { file });

  return response.data;
};

const getDownload = async () => {
  const response = await api.get(`/api/v1/donwload`);

  return response;
};
const sendTxt = async ({ file }) => {
  const response = await api.post(`/api/v1/importacao=txt/`, { file: file });

  return response.data;
};

const getTxt = async () => {
  const response = await api.get(`/api/v1/exportacao-txt`);

  return response;
};

export { getDownload, setUpload, getTxt, sendTxt };
