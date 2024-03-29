import Text from "../../text/text";
import Button from "../../buttons/button";
import Modal from "../modal";
import styles from "./styles.module.scss";
import { useCallback, useMemo, useState } from "react";
import {
  postCertificado,
  putCertificado,
} from "../../../services/freelancer/certificacao";
import { useMutation } from "@tanstack/react-query";
import { postUpload } from "../../../services/importacao/freelancer";
import { useEffect } from "react";

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
  useEffect(() => {
    localStorage.setItem("url_certificado", urlCertificado);
  }, [urlCertificado]);

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
    const formData = new FormData();
    formData.append("file", file);

    await postUpload(file);

    localStorage.setItem("upload", JSON.stringify(file.name));
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
      </div>
      <div className={styles.buttons}>
        <Button
          onClick={() => {
            if (add) handlePost();
            if (edit) handlePut();

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
