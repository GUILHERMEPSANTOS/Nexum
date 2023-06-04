import { useCallback, useMemo, useState } from "react";

import { useMutation, useQuery } from "@tanstack/react-query";
import { listSocialByUserId } from "../../../services/freelancer/social";

import { Link } from "react-router-dom";

import CreateOffer from "../../modals/createOffer/createOffer";
import EditPhoto from "../../modals/editoPhoto/editPhoto";
import EditData from "../../modals/editData/editData";
import EditProfile from "../../modals/editProfile/editProfile";
import EditSocialMedia from "../../modals/editSocialMedia/editSocialMedia";
import Text from "../../text/text";
import Title from "../../title/title";
import List from "../list/list";

import { putMatchRequest } from "../../../services/freelancer/match/freelancer";
import {
  getAboutUser,
  getImageProfile,
} from "../../../services/freelancer/user";
import {
  getFreelancerById,
  getContratanteById,
} from "../../../services/freelancer/freelancer";
import { Loading } from "../../loading/loading";
import styles from "./styles.module.scss";
import PhotoProfile from "./photoProfile/photoProfile";

const About = ({
  isOtherView,
  idCompany,
  isCompanyProfile,
  canEdit = true,
  nomeCompany,
  emailCompany,
  enderecoCompany,
  sobreCompany,
  socialCompany,
}) => {
  const userId = useMemo(() => localStorage.getItem("user_id"));
  const nome = localStorage.getItem("name") ? localStorage.getItem("name") : "";
  const email = localStorage.getItem("email")
    ? localStorage.getItem("email")
    : "";
  const nomeFormatted = nome.replace(/"/g, "");
  const emailFormatted = email.replace(/"/g, "");
  localStorage.setItem("company_id", idCompany);
  const [editPhoto, setEditPhoto] = useState(false);
  const [editAbout, setEditAbout] = useState(false);
  const [editSocial, setEditSocial] = useState(false);
  const [editData, setEditData] = useState(false);
  const perfil = localStorage.getItem("role");

  const { data: dataImage, refetch: refetchImage } = useQuery(
    ["consultar imagem Perfil", userId],
    () => getImageProfile({ userId })
  );
  const { data: dataImageContratante, refetch: refetchImageContratante } =
    useQuery(["consultar imagem Perfil contratante", idCompany], () =>
      getImageProfile({ userId: idCompany })
    );

  const {
    data: dataEnd,
    isLoading: loadingEnd,
    refetch: refetchEnd,
  } = useQuery(["consultar solicitações de freela"], () =>
    getFreelancerById(userId)
  );

  const {
    data: dataEndContratante,
    isLoading: loadingEndContratante,
    refetch: refetchEndContratante,
  } = useQuery(["consultar solicitações de contratantee"], () =>
    getContratanteById(userId)
  );

  const {
    data: dataAbout,
    isLoading: isLoadingAbout,
    refetch: refetchAbout,
  } = useQuery(["consultar about"], async () => await getAboutUser(userId));

  const {
    data: dataSocialMedia,
    isLoading: isLoadingSocial,
    refetch: refetchSocial,
  } = useQuery(
    ["consultar redes"],
    async () => await listSocialByUserId(userId)
  );

  const handleMatchConfirm = useCallback(async () => {
    await putMatchRequest({ id_freelancer: userId, id_contratante: idCompany });
  }, [userId, idCompany]);

  if (isLoadingSocial || isLoadingAbout || loadingEnd) {
    return <Loading />;
  }

  return (
    <>
      <section className={styles.container}>
        <div className={styles.profile}>
          {isOtherView ? (
            <PhotoProfile
              refetch={refetchImageContratante}
              setEditPhoto={setEditPhoto}
            />
          ) : (
            <PhotoProfile
              isOtherView={true}
              idCompany={idCompany}
              refetch={refetchImage}
              perfil={true}
            />
          )}
          {console.log(idCompany)}
          <div>
            {isOtherView ? (
              <h1 className={styles.title}>{nomeCompany} </h1>
            ) : (
              <h1 className={styles.title}>{nomeFormatted} </h1>
            )}
            <div className={styles.location}>
              <img src="../../assets/icons/location.png" />

              {isOtherView ? (
                <>
                  <Text isSmall={true} text={`${enderecoCompany?.cidade},`} />

                  <Text isSmall={true} text={enderecoCompany?.estadoBuis} />
                </>
              ) : perfil == `"ROLE_CONTRATANTE"` ? (
                <>
                  <Text
                    isSmall={true}
                    text={`${dataEndContratante?.endereco?.cidade},`}
                  />

                  <Text
                    isSmall={true}
                    text={dataEndContratante?.endereco?.estado}
                  />
                </>
              ) : (
                <>
                  <Text isSmall={true} text={`${dataEnd?.endereco?.cidade},`} />
                  <span>,</span>
                  <Text isSmall={true} text={dataEnd?.endereco?.estado} />
                </>
              )}
            </div>

            {isOtherView || perfil == `"ROLE_CONTRATANTE"` ? (
              ""
            ) : (
              <Text text="Programador" />
            )}
            {canEdit && (
              <img
                onClick={() => setEditData(true)}
                className={styles.editDatas}
                src="../../assets/icons/editAbout.svg"
              />
            )}
          </div>
          {isOtherView && (
            <div className={styles.actions}>
              <Link onClick={handleMatchConfirm} to="/propostas">
                <button>
                  <img src="../../assets/icons/like.svg" />
                </button>
              </Link>
            </div>
          )}
        </div>
        <div className={styles.aboutContainer}>
          {canEdit && (
            <img
              onClick={() => setEditAbout(true)}
              className={styles.edit}
              src="../../assets/icons/editAbout.svg"
            />
          )}
          <Title text="Sobre" />
          {isOtherView ? (
            <Text text={sobreCompany} />
          ) : (
            <Text text={dataAbout?.data} />
          )}
          {canEdit && (
            <img
              onClick={() => setEditSocial(true)}
              className={styles.editSocial}
              src="../../assets/icons/editAbout.svg"
            />
          )}
          {isOtherView ? (
            <List title="Redes sociais" list={socialCompany} />
          ) : (
            dataSocialMedia?.data?.length > 0 && (
              <List title="Redes sociais" list={dataSocialMedia?.data} />
            )
          )}
          <Title text="Email" />
          <div className={styles.socialMedia}>
            {isOtherView ? (
              <Text isSmall={true} text={emailCompany} />
            ) : (
              <Text isSmall={true} text={emailFormatted} />
            )}
          </div>
          {isCompanyProfile && (
            <>
              {canEdit && (
                <img
                  onClick={() => setEditAbout(true)}
                  className={styles.edit}
                  src="../../assets/icons/editAbout.svg"
                />
              )}
              {/* {isOtherView && (
                <>
                  <List title="Informações do projeto" list={INFO} />
                  <Text text="Curabitur tempus lacus in quam laoreet, eget finibus orci pharetra. Sed molestie leo eget urna egestas tristique ed molestie leo eget urna egestas tristique lacus in quam laoreet eget urna egestas tristique ed molestie leo eget." />
                </>
              )} */}
              {canEdit && (
                <img
                  onClick={() => setEditSocial(true)}
                  className={styles.editSocial}
                  src="../../assets/icons/editAbout.svg"
                />
              )}
            </>
          )}
        </div>
      </section>
      {editAbout && (
        <EditProfile
          refetch={refetchAbout}
          actualState={editAbout}
          setActualState={setEditAbout}
        />
      )}
      {editData && (
        <EditData
          refetch={refetchEnd}
          actualState={editData}
          setActualState={setEditData}
        />
      )}
      {editSocial && (
        <EditSocialMedia
          actualState={editSocial}
          setActualState={setEditSocial}
          refetch={refetchSocial}
        />
      )}
      {editPhoto && (
        <EditPhoto actualState={editPhoto} setActualState={setEditPhoto} />
      )}
    </>
  );
};

export default About;
