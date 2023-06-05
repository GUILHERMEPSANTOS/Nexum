import { useState, useMemo } from "react";
import { useMutation } from "@tanstack/react-query";

import { postProfilePhoto } from "../../../services/freelancer/freelancer";

import Button from "../../buttons/button";
import Modal from "../modal";

import { appendFile, clearFormData, convertFileToBase64 } from "./fileHandler";

import styles from "./styles.module.scss";

const EditProfile = ({ actualState, setActualState }) => {
  const [fileData, setFileData] = useState({ file: null, preview: null });
  const userId = useMemo(() => localStorage.getItem("user_id"));

  const { mutate } = useMutation(
    ({ userId, file, base64Image }) =>
      postProfilePhoto({ userId, file, base64Image }),
    {
      onSuccess: () => {
        setActualState(false);
        location.reload();
      },
    }
  );

  const handleSubmit = async (e) => {
    e.preventDefault();

    const { file } = fileData;

    if (!file) {
      alert("Selecione um arquivo!");
      return;
    }

    appendFile("file", file);

    var base64Image = await convertFileToBase64(file);

    mutate({ userId, file, base64Image });
    clearFormData();
  };

  const handleFileChange = (e) => {
    const selectedFile = e.target.files[0];
    const preview = URL.createObjectURL(selectedFile);
    setFileData({ file: selectedFile, preview });
  };

  return (
    <Modal
      text={"Perfil"}
      label={"Editar foto perfil"}
      actualState={actualState}
      setActualState={setActualState}
    >
      <form onSubmit={handleSubmit} className={styles.formContainer}>
        <input type="file" onChange={handleFileChange} />
        {fileData.preview && (
          <img
            className={styles.imgProfile}
            src={fileData.preview}
            alt="Preview"
          />
        )}
        <div>
          <Button className={styles.button} type="submit" text="Enviar" />
        </div>
      </form>
    </Modal>
  );
};

export default EditProfile;
