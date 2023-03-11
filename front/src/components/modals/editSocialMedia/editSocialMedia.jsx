import { useCallback, useMemo, useState } from "react";

import { useMutation, useQuery } from "@tanstack/react-query";
import { listSocial, postSocial } from "../../../services/freelancer/social";

import Button from "../../buttons/button";
import Modal from "../modal";
import OptionSocialMedia from "./optionSocialMedia/optionSocialMedia";

import styles from "./styles.module.scss";

const EditSocialMedia = ({
  actualState,
  setActualState,
  refetch = () => {},
}) => {
  const userId = useMemo(() => Number(localStorage.getItem("user_id")));

  const [socialNetworks, setSocialNetworks] = useState([]);

  const { data } = useQuery(["consultar redes sociais"], () => listSocial(), {
    onSuccess: (data) => {
      setSocialNetworks(
        data?.data?.map(({ id_social }) => ({
          id_social,
          user_url: "",
        }))
      );
    },
  });

  const { mutate } = useMutation(
    ({ data, userId }) => postSocial(data, userId),
    {
      onSuccess: () => {
        refetch();
      },
    }
  );

  const handleChangeCurrentValueOption = useCallback(
    (data) => {
      const updateSocialNetwork = socialNetworks.map((socialNetwork) => {
        if (socialNetwork.id_social === data.id_social) {
          return { ...socialNetwork, ...data };
        }

        return socialNetwork;
      });

      setSocialNetworks(updateSocialNetwork);
    },
    [setSocialNetworks, socialNetworks]
  );

  const handleUpdateSocialMedia = useCallback(() => {
    mutate({ data: socialNetworks, userId });
    setActualState(false);
  }, [socialNetworks]);

  return (
    <Modal
      text={"Perfil"}
      label={"Coloque o link das suas redes sociais"}
      actualState={actualState}
      setActualState={setActualState}
    >
      <div className={styles.container}>
        {data?.data.map((dataSocialNetworks) => (
          <OptionSocialMedia
            key={dataSocialNetworks.id_social}
            id_social={dataSocialNetworks.id_social}
            nome={dataSocialNetworks.nome}
            onChageOption={handleChangeCurrentValueOption}
          />
        ))}
      </div>
      <div className={styles.buttons}>
        <Button
          onClick={handleUpdateSocialMedia}
          isEmpty={true}
          text="Salvar"
        />
      </div>
    </Modal>
  );
};

export default EditSocialMedia;
