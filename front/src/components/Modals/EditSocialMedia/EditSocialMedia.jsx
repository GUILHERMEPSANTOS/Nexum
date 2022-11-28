import Text from "../../Text/Text";
import Button from "../../Buttons/Button";
import Modal from "../Modal";
import styles from "./styles.module.scss";
import { useCallback, useMemo, useState } from "react";
import { useMutation } from "@tanstack/react-query";
import { postSocial } from "../../../services/Freelancer/social";
import { useEffect } from "react";

const EditSocialMedia = ({
  actualState,
  setActualState,
  refetch = () => {},
}) => {
  const [linkedin, setLinkedin] = useState();
  const [facebook, setFacebook] = useState();
  const [instagram, setInstagram] = useState();
  const [idSocial, setIdSocial] = useState();

  const userId = useMemo(() => localStorage.getItem("user_id"));

  // useEffect(() => {
  //   if() {

  //   } else if() {

  //   } else {

  //   }

  // },[linkedin,facebook, instagram ])

  const { mutate } = useMutation(
    ({ linkedin, facebook, instagram, idSocial, id }) =>
      postSocial({
        linkedin,
        facebook,
        instagram,
        idSocial,
        id,
      }),
    {
      onSuccess: () => {
        refetch();
      },
    }
  );

  const handlePost = useCallback(() => {
    mutate({
      linkedin,
      facebook,
      instagram,
      idSocial,
      id: userId,
    });
  }, [linkedin, facebook, instagram]);

  return (
    <Modal
      text={"Perfil"}
      label={"Coloque o link das suas redes sociais"}
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
