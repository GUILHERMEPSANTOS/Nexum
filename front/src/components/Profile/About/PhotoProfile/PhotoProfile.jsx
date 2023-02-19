import { useMemo, useState } from "react";

import { useQuery } from "@tanstack/react-query";

import { Loading } from "../../../Loading/Loading";

import { getImageProfile } from "../../../../services/Freelancer/user";

import styles from "./styles.module.scss";

const PhotoProfile = ({ setEditPhoto }) => {
  const userId = useMemo(() => localStorage.getItem("user_id"));
  const [imageUrl, setImageUrl] = useState(null);

  const {
    data: dataImage,
    isLoading,
    refetch,
  } = useQuery(
    ["consultar imagem Perfil", userId],
    () => getImageProfile({ userId }),
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
