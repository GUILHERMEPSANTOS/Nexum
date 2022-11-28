import Text from "../../Text/Text";
import Button from "../../Buttons/Button";
import Modal from "../Modal";
import styles from "./styles.module.scss";
import { useCallback, useMemo, useState } from "react";
import {
  postFormacao,
  putFormacao,
} from "../../../services/Freelancer/formacao";
import { useMutation } from "@tanstack/react-query";
const EditGraduate = ({
  actualState,
  setActualState,
  add,
  edit,
  refetch = () => {},
}) => {
  const [curso, setCurso] = useState();
  const [ensino, setEnsino] = useState();
  const [estado, setEstado] = useState();
  const [cidade, setCidade] = useState();
  const [dataInicio, setDataInicio] = useState();
  const [dataFinal, setDataFinal] = useState();
  const [sobre, setSobre] = useState();
  const userId = useMemo(() => localStorage.getItem("user_id"));
  const { mutate: sendRequest } = useMutation(
    ({
      curso,
      instituicao,
      cidade,
      estado,
      sobre,
      data_inicial,
      data_final,
      id,
    }) =>
      postFormacao({
        curso,
        instituicao,
        cidade,
        estado,
        sobre,
        data_inicial,
        data_final,
        id,
      }),
    {
      onSuccess: () => {
        refetch();
      },
    }
  );
  const { mutate: updateRequest } = useMutation(
    ({
      curso,
      instituicao,
      cidade,
      estado,
      sobre,
      data_inicial,
      data_final,
      id,
    }) =>
      putFormacao({
        curso,
        instituicao,
        cidade,
        estado,
        sobre,
        data_inicial,
        data_final,
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
      sobre,
      data_inicial: dataInicio,
      data_final: dataFinal,
      id: userId,
    });
  }, [curso, cidade, estado]);
  const handlePut = useCallback(() => {
    updateRequest({
      curso,
      instituicao: ensino,
      cidade,
      estado,
      sobre,
      data_inicial: dataInicio,
      data_final: dataFinal,
      id: userId,
    });
  }, [curso, cidade, estado]);
  return (
    <Modal
      text={"Formação"}
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
        <Text isSmall={true} text="Data" />
        <div className={styles.location}>
          <input
            placeholder="Inicio"
            onChange={({ target }) => setDataInicio(target.value)}
            value={dataInicio}
            type="date"
          />
          <input
            placeholder="Término"
            onChange={({ target }) => setDataFinal(target.value)}
            value={dataFinal}
            type="date"
          />
        </div>
        <Text isSmall={true} text="Sobre" />
        <textarea
          onChange={({ target }) => setSobre(target.value)}
          value={sobre}
          className={styles.textArea}
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

export default EditGraduate;
