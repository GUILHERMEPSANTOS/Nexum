import { useMemo, useState } from "react";

import { useQuery } from "@tanstack/react-query";

import { Loading } from "../../../loading/loading";

import { getImageProfile } from "../../../../services/freelancer/user";

import styles from "./styles.module.scss";

const PhotoProfile = ({
  idCompany,
  isOtherView,
  setEditPhoto,
  perfil,
  refetch = () => {},
}) => {
  const userId = useMemo(() => localStorage.getItem("user_id"));
  const companyId = useMemo(() => localStorage.getItem("company_id"));
  const [imageUrl, setImageUrl] = useState(null);
  const [imageUrlContratante, setImageUrlContratante] = useState(null);

  const { data: dataImage, isLoading } = useQuery(
    ["consultar imagem Perfil", userId],
    () => getImageProfile({ userId }),
    {
      onSuccess: (data) => {
        setImageUrl(URL.createObjectURL(data.data));
        refetch();
        // location.reload();
      },
    }
  );
  {
  }
  const { data: dataImageContratante, isLoadingContratante } = useQuery(
    ["consultar imagem Perfil contratante", companyId],
    () => getImageProfile({ userId: companyId }),
    {
      onSuccess: (data) => {
        setImageUrlContratante(URL.createObjectURL(data.data));
        refetch();
        // location.reload();
      },
    }
  );

  if (isLoading) {
    return <Loading />;
  }
  if (isLoadingContratante) {
    return <Loading />;
  }

  return (
    <div className={styles.imgProfileContainers}>
      {perfil ? (
        <img className={styles.imgProfile} src={imageUrl} />
      ) : (
        <img className={styles.imgProfile} src={imageUrlContratante} />
      )}

      {isOtherView && (
        <div className={styles.editIcon}>
          <img
            onClick={() => setEditPhoto(true)}
            className={styles.editIcon}
            src="../../assets/icons/editAbout.svg"
          />
        </div>
      )}
    </div>
  );
};

export default PhotoProfile;
