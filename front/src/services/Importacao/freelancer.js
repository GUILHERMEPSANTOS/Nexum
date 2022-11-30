import { api } from "../api";

const postUpload = async ( file ) => {


  try {
    const response = await api.post(`/upload`, {
      data: file,
      headers: {
        "Content-Type": "multipart/form-data",
      },
    });

    return response.data;
  } catch (error) {
    console.log(error);
  }
};

const getDownload = async ({ file }) => {
  const response = await api.get(`/api/v1/download/${file}`);

  return response;
};
const sendTxt = async ({ file }) => {
  const response = await api.post(`/api/v1/importacao-txt/`, { file: file });

  return response.data;
};

const getTxt = async () => {
  const response = await api.get(`/api/v1/exportacao-txt`);

  return response;
};

export { getDownload, postUpload, getTxt, sendTxt };
