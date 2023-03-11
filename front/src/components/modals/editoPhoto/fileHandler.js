const fileReader = new FileReader();
const formData = new FormData();

const clearFormData = () => {
  formData.delete("file");
};

const convertFileToBase64 = (file) => {
  return new Promise((resolve, reject) => {
    fileReader.readAsDataURL(file);

    fileReader.onload = () => {
      resolve(fileReader.result);
    };

    fileReader.onerror = () => {
      reject(fileReader.result);
    };
  });
};

const appendFile = (fileName, file) => {
  formData.append("file", file);
};

export { fileReader, formData, clearFormData, convertFileToBase64, appendFile };
