import { useMemo, useState } from "react";

import { useQuery } from "@tanstack/react-query";

import { Loading } from "../../../loading/loading";

import { getImageProfile } from "../../../../services/freelancer/user";

import styles from "./styles.module.scss";

const PhotoProfile = ({ setEditPhoto, refetch = () => {} }) => {
  const userId = useMemo(() => localStorage.getItem("user_id"));
  const [imageUrl, setImageUrl] = useState(null);

  const { data: dataImage, isLoading } = useQuery(
    ["consultar imagem Perfil", userId],
    () => getImageProfile({ userId }),
    {
      onSuccess: (data) => {
        setImageUrl(URL.createObjectURL(data.data));
        refetch();
        window.reload();
      },
    }
  );

  if (isLoading) {
    return <Loading />;
  }

  return (
    <div className={styles.imgProfileContainers}>
      <img className={styles.imgProfile} src={imageUrl} />
      <div className={styles.editIcon}>
        <img
          onClick={() => setEditPhoto(true)}
          className={styles.editIcon}
          src="../../assets/icons/editAbout.svg"
        />
      </div>
    </div>
  );
};

export default PhotoProfile;
