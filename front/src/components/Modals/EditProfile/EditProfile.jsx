import { useCallback, useMemo, useState } from "react";

import { useMutation, useQuery } from "@tanstack/react-query";
import { getAboutUser, putAboutUser } from "../../../services/Freelancer/user";

import Button from "../../Buttons/Button";
import Modal from "../Modal";
import styles from "./styles.module.scss";

const EditProfile = ({ actualState, setActualState, refetch = () => {}}) => {
  const user_id = useMemo(() => Number(localStorage.getItem("user_id")));
  const [about, setAbout] = useState("");

  const { mutate } = useMutation(
    ({ id_user, sobre }) =>
    putAboutUser({
      id_user,
      sobre
      }),
    {
      onSuccess: () => {
        refetch();
      },
    }
  );
  const handleSubmit = useCallback(() => {
    mutate({
      id_user: user_id,
      sobre: about,
    });
  }, [user_id, about]);

  return (
    <Modal
      text={"Perfil"}
      label={"Sobre"}
      actualState={actualState}
      setActualState={setActualState}
    >
      <textarea
        onChange={({ target }) => setAbout(target.value)}
        value={about}
        className={styles.textArea}
      />
      <div className={styles.buttons}>
        <Button
          onClick={() => {
            handleSubmit()
            setActualState(false)}}
          isEmpty={true}
          text="Salvar"
        />
      </div>
    </Modal>
  );
};

export default EditProfile;
