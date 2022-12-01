import { api } from "../api";

const postUpload = async (file) => {
  try {
    console.log(file)
    const response = await api.post(`/upload`, file, {
      headers: {
        "Content-Type":
          "multipart/form-data; boundary=---011000010111000001101001",
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
  const response = await api.post(`/api/v1/admin/importacao-txt/${file.name}`);

  return response.data;
};

const getTxt = async () => {
  const response = await api.get(`/api/v1/admin/exportacao-txt`);

  return response;
};

export { getDownload, postUpload, getTxt, sendTxt };
