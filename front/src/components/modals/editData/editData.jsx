import Text from "../../text/text";
import Button from "../../buttons/button";
import Modal from "../modal";
import styles from "./styles.module.scss";
import { useCallback, useMemo, useState } from "react";
import { putCEP } from "../../../services/freelancer/user/index";
import { useMutation } from "@tanstack/react-query";

const EditData = ({ actualState, setActualState, refetch=() => {}}) => {

  const userId = useMemo(() => localStorage.getItem("user_id"));
  const { mutate: updateRequest } = useMutation(
    ({ id_freelancer,
      cep }) =>
      putCEP({
        id_freelancer,
        cep
      }),
    {
      onSuccess: () => {
        refetch();
      },
    }
  );

  const [nome, setNome] = useState();
  const [cep, setCep] = useState();
  const [marketing, setMarketing] = useState();
  const [programador, setProgramador] = useState();
  const [designer, setDesigner] = useState();
  const [page, setPage] = useState(1);

  const handlePut = useCallback(() => {
    updateRequest({
      id_freelancer: userId,
      cep
    });
  }, [userId,
    cep]);


  return (
    <Modal
      text={"Perfil"}
      actualState={actualState}
      setActualState={setActualState}
      label={
        page == 1
          ? "Atualize seus dados"
          : page == 2
            ? "Atualize sua profissão"
            : ""
      }
    >
      <div className={styles.container}>
            <Text isSmall={true} text="CEP" />
            <input
              onChange={({ target }) => setCep(target.value)}
              value={cep}
            />

 </div>
      <div className={styles.buttons}>

            <Button
              onClick={() => {
                setActualState(false)
                handlePut()
              }}
              isEmpty={true}
              text="Salvar" />
          </div>

       
    </Modal>
  );
};

export default EditData;
