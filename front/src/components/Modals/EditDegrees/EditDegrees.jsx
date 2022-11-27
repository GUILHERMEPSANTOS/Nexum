import Text from "../../Text/Text";
import Button from "../../Buttons/Button";
import Modal from "../Modal";
import styles from "./styles.module.scss";
import { useCallback, useMemo, useState } from "react";
import {
  postCertificado,
  putCertificado,
} from "../../../services/Freelancer/certificacao";

const EditDegrees = ({ actualState, setActualState, add }) => {
  const [curso, setCurso] = useState();
  const [ensino, setEnsino] = useState();
  const [estado, setEstado] = useState();
  const [cidade, setCidade] = useState();
  const [urlCertificado, setUrlCertificado] = useState();
  const userId = useMemo(() => localStorage.getItem("user_id"));
  const handlePost = useCallback(() => {
    postCertificado({
      curso,
      instituicao: ensino,
      cidade,
      estado,
      certificacao_url: urlCertificado,
      id: userId,
    });
  }, [curso, cidade, estado]);
  const handlePut = useCallback(() => {
    putCertificado({
      curso,
      instituicao: ensino,
      cidade,
      estado,
      certificacao_url: urlCertificado,
      id: userId,
    });
  }, [curso, cidade, estado]);

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
        <Text isSmall={true} text="Caminho para certificado" />
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
