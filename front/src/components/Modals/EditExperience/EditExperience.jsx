import Text from "../../Text/Text";
import Button from "../../Buttons/Button";
import Modal from "../Modal";
import styles from "./styles.module.scss";
import { useCallback, useMemo, useState } from "react";
import {
  postExperiencia,
  putExperiencia,
} from "../../../services/Freelancer/experienca";
import { useMutation } from "@tanstack/react-query";
const EditExperience = ({
  actualState,
  setActualState,
  add,
  edit,
  idExperiencia,
  refetch = () => {},
}) => {
  const [cargo, setCargo] = useState();
  const [empresa, setEmpresa] = useState();
  const [estado, setEstado] = useState();
  const [cidade, setCidade] = useState();
  const [dataInicio, setDataInicio] = useState();
  const [dataFinal, setDataFinal] = useState();
  const [sobre, setSobre] = useState();
  const userId = useMemo(() => localStorage.getItem("user_id"));
  const { mutate: sendRequest } = useMutation(
    ({ cargo, empresa, cidade, estado, sobre, data_inicial, data_final, id }) =>
      postExperiencia({
        cargo,
        empresa,
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
    ({ cargo, empresa, cidade, estado, sobre, data_inicial, data_final, id }) =>
      putExperiencia({
        cargo,
        empresa,
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
      cargo,
      empresa,
      cidade,
      estado,
      sobre,
      data_inicial: dataInicio,
      data_final: dataFinal,
      id: userId,
    });
  }, [cargo, empresa, cidade, estado]);
  const handlePut = useCallback(() => {
    updateRequest({
      cargo,
      empresa,
      cidade,
      estado,
      sobre,
      data_inicial: dataInicio,
      data_final: dataFinal,

      id: idExperiencia,
    });
  }, [cargo, empresa, cidade, estado]);
  return (
    <Modal
      text={"Experiência"}
      label={"Coloque suas experiências"}
      actualState={actualState}
      setActualState={setActualState}
    >
      <div className={styles.container}>
        <Text isSmall={true} text="Cargo" />
        <input
          onChange={({ target }) => setCargo(target.value)}
          value={cargo}
        />
        <Text isSmall={true} text="Nome da empresa" />
        <input
          onChange={({ target }) => setEmpresa(target.value)}
          value={empresa}
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

export default EditExperience;
