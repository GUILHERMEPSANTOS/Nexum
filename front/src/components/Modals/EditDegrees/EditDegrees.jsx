import Text from "../../Text/Text";
import Button from "../../Buttons/Button";
import Modal from "../Modal";
import styles from "./styles.module.scss";
import { useCallback, useMemo, useState } from "react";
import {
  postCertificado,
  putCertificado,
} from "../../../services/Freelancer/certificacao";
import { useMutation } from "@tanstack/react-query";
import { postUpload } from "../../../services/Importacao/freelancer";

const EditDegrees = ({
  actualState,
  setActualState,
  add,
  edit,
  idCertificado,
  refetch = () => {},
}) => {
  const [curso, setCurso] = useState();
  const [ensino, setEnsino] = useState();
  const [estado, setEstado] = useState();
  const [cidade, setCidade] = useState();
  const [urlCertificado, setUrlCertificado] = useState();
  const [file, setFile] = useState(null);
  const userId = useMemo(() => localStorage.getItem("user_id"));

  const { mutate: sendRequest } = useMutation(
    ({ curso, instituicao, cidade, estado, certificacao_url, id }) =>
      postCertificado({
        curso,
        instituicao,
        cidade,
        estado,
        certificacao_url,
        id,
      }),
    {
      onSuccess: () => {
        refetch();
      },
    }
  );
  const { mutate: updateRequest } = useMutation(
    ({ curso, instituicao, cidade, estado, certificacao_url, id }) =>
      putCertificado({
        curso,
        instituicao,
        cidade,
        estado,
        certificacao_url,
        id,
      }),
    {
      onSuccess: () => {
        refetch();
      },
    }
  );

  const handlePost = useCallback(() => {
    sendRequest({
      curso,
      instituicao: ensino,
      cidade,
      estado,
      certificacao_url: urlCertificado,
      id: userId,
    });
  }, [curso, cidade, estado]);

  const handlePut = useCallback(() => {
    updateRequest({
      curso,
      instituicao: ensino,
      cidade,
      estado,
      certificacao_url: urlCertificado,
      id: idCertificado,
    });
  }, [curso, cidade, estado]);

  const handleUpload = useCallback(async () => {
    console.log(file)
    const formData = new FormData();
    formData.append("file", file);

    await postUpload( file);
    
    localStorage.setItem("upload", JSON.stringify(file));
  }, [file]);


  return (
    <Modal
      text={"Certificaçôes"}
      label={"Coloque suas experiências"}
      actualState={actualState}
      setActualState={setActualState}
    >
      <div className={styles.container}>
        <Text isSmall={true} text="Curso" />
        <input
          onChange={({ target }) => setCurso(target.value)}
          value={curso}
        />
        <Text isSmall={true} text="Instituição de ensino" />
        <input
          onChange={({ target }) => setEnsino(target.value)}
          value={ensino}
        />
        <Text isSmall={true} text="Local" />
        <div className={styles.location}>
          <input
            placeholder="Estado"
            onChange={({ target }) => setEstado(target.value)}
            value={estado}
          />
          <input
            placeholder="Cidade"
            onChange={({ target }) => setCidade(target.value)}
            value={cidade}
          />
        </div>
        <Text isSmall={true} text="URL do certificado" />
        <input
          onChange={({ target }) => setUrlCertificado(target.value)}
          value={urlCertificado}
        />
        <Text isSmall={true} text="Suba seu certificado" />
        <input
          onChange={({ target }) => setFile(target.files[0])}
          // value={upload}
          type="file"
          // accept="image/png, image/jpeg"
        />
      </div>
      <div className={styles.buttons}>
        <Button
          onClick={() => {
            if (add) handlePost();
            if (edit) handlePut();
            handleUpload();
            setActualState(false);
          }}
          isEmpty={true}
          text="Salvar"
        />
      </div>
    </Modal>
  );
};

export default EditDegrees;
