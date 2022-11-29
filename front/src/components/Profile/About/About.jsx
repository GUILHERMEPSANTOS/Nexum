import { useCallback, useMemo, useState } from "react";

import { useMutation, useQuery } from "@tanstack/react-query";
import { listSocialByUserId } from "../../../services/Freelancer/social";

import { Link } from "react-router-dom";

import CreateOffer from "../../Modals/CreateOffer/CreateOffer";
import EditData from "../../Modals/EditData/EditData";
import EditProfile from "../../Modals/EditProfile/EditProfile";
import EditSocialMedia from "../../Modals/EditSocialMedia/EditSocialMedia";
import Text from "../../Text/Text";
import Title from "../../Title/Title";
import List from "../List/List";

import styles from "./styles.module.scss";
import { listHabilidadesByUserId } from "../../../services/Freelancer/habilidades";

const About = ({
  isOtherView,
  isCompanyProfile,
  canEdit = true,
  nomeCompany,
  emailCompany,
  enderecoCompany,
  sobreCompany,
  socialCompany,
}) => {
  const [editAbout, setEditAbout] = useState(false);
  const [editSocial, setEditSocial] = useState(false);
  const [editData, setEditData] = useState(false);

  const nome = localStorage.getItem("name") ? localStorage.getItem("name") : "";
  const email = localStorage.getItem("email")
    ? localStorage.getItem("email")
    : "";
  const nomeFormatted = nome.replace(/"/g, "");
  const emailFormatted = email.replace(/"/g, "");
  const userId = useMemo(() => localStorage.getItem("user_id"));

  const { data, isLoading, refetch } = useQuery(
    ["consultar redes"],
    async () => await listSocialByUserId(userId)
  );

  if (isLoading) {
    return <div>Loding...</div>;
  }
  return (
    <>
      <section className={styles.container}>
        <div className={styles.profile}>
          <img
            className={styles.imgProfile}
            src="../../assets/imgs/person-card-1.png"
          />
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
                  <Text isSmall={true} text={enderecoCompany?.cidade} />

                  <Text isSmall={true} text={enderecoCompany?.estado} />
                </>
              ) : (
                <Text isSmall={true} text="Osasco, São Paulo" />
              )}
            </div>
            <Text text="Designer" />
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
              <Link to="/propostas">
                <button>
                  <img src="../../assets/icons/like.svg" />
                </button>
              </Link>
              <button>
                <img src="../../assets/icons/save.svg" />
              </button>
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
            <Text
              text="Curabitur tempus lacus in quam laoreet, eget finibus orci pharetra. Sed molestie leo eget urna egestas tristique ed molestie leo eget urna egestas tristique lacus in quam laoreet eget urna egestas tristique ed molestie leo eget urna egestas.
Curabitur tempus lacus in quam laoreet, eget finibus orci pharetra. Sed molestie leo eget urna egestas tristique. Sed molestie leo eget urna egestas tristique."
            />
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
            // <>oi</>
            <List title="Redes sociais" list={data?.data} />
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
        <EditProfile actualState={editAbout} setActualState={setEditAbout} />
      )}
      {editData && (
        <EditData actualState={editData} setActualState={setEditData} />
      )}
      {editSocial && (
        <EditSocialMedia
          actualState={editSocial}
          setActualState={setEditSocial}
          refetch={refetch}
        />
      )}
    </>
  );
};

export default About;
