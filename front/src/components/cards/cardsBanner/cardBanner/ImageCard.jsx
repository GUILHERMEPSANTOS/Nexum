import React, { useState } from "react";

import { useQuery } from "@tanstack/react-query";
import { getImageProfile } from "../../../../services/freelancer/user";

import { Loading } from "../../../loading/loading";

import styles from "../styles.module.scss";

export const ImageCard = ({ id_user }) => {
  const [imageUrl, setImageUrl] = useState(null);

  const { data: dataImage, isLoading } = useQuery(
    ["consultar imagem Perfil card", id_user],
    () => getImageProfile({ userId: id_user }),
    {
      onSuccess: (data) => {
        setImageUrl(URL.createObjectURL(data.data));
      },
    }
  );

  if (isLoading) {
    return <Loading />;
  }

  return (
    <img
      className={styles.foto}
      src={imageUrl ?? `../../../../../assets/imgs/avatar.png`}
    />
  );
};
