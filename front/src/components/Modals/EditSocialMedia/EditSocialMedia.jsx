import Text from "../../Text/Text";
import Button from "../../Buttons/Button";
import Modal from "../Modal";
import styles from "./styles.module.scss";
import { useMemo, useState } from "react";
import { useMutation } from "@tanstack/react-query";
import { postSocial } from "../../../services/Freelancer/social";

const EditSocialMedia = ({
  actualState,
  setActualState,
  refetch = () => {},
}) => {
  const [linkedin, setLinkedin] = useState();
  const [facebook, setFacebook] = useState();
  const [instagram, setInstagram] = useState();

  const userId = useMemo(() => localStorage.getItem("user_id"));

  const { mutate: sendRequest } = useMutation(
    ({ linkedin, facebook, instagram, idSocial, id }) =>
      postSocial({
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
      id: userId,
    });
  }, [curso, cidade, estado]);
  return (
    <Modal
      text={"Perfil"}
      label={"Coloque as suas redes sociais"}
      actualState={actualState}
      setActualState={setActualState}
    >
      <div className={styles.container}>
        <Text isSmall={true} text="Linkedin" />
        <input
          onChange={({ target }) => setLinkedin(target.value)}
          value={linkedin}
        />
        <Text isSmall={true} text="Facebook" />
        <input
          onChange={({ target }) => setFacebook(target.value)}
          value={facebook}
        />
        <Text isSmall={true} text="Instagram" />
        <input
          onChange={({ target }) => setInstagram(target.value)}
          value={instagram}
        />
      </div>
      <div className={styles.buttons}>
        <Button
          onClick={() => setActualState(false)}
          isEmpty={true}
          text="Salvar"
        />
      </div>
    </Modal>
  );
};

export default EditSocialMedia;
