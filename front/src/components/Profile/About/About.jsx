import styles from "./styles.module.scss";
import Title from "../../Title/Title";
import Text from "../../Text/Text";
import { SOCIAL_MEDIA, INFO } from "./constants";
import List from "../List/List";
import EditProfile from "../../Modals/EditProfile/EditProfile";
import { useState } from "react";
import EditSocialMedia from "../../Modals/EditSocialMedia/EditSocialMedia";
import CreateOffer from "../../Modals/CreateOffer/CreateOffer";

const About = ({
  isOtherView,
  isCompanyProfile,
  canEdit = !isCompanyProfile,
}) => {
  const [editAbout, setEditAbout] = useState(false);
  const [editSocial, setEditSocial] = useState(false);

  const nome = localStorage.getItem("name") ? localStorage.getItem("name") : "";
  const email = localStorage.getItem("email")
    ? localStorage.getItem("email")
    : "";
  const nomeFormatted = nome.replace(/"/g, "");
  const emailFormatted = email.replace(/"/g, "");

  return (
    <>
      <section className={styles.container}>
        <div className={styles.profile}>
          <img
            className={styles.imgProfile}
            src="../../assets/imgs/person-card-1.png"
          />
          <div>
            <h1 className={styles.title}>{nomeFormatted} </h1>
            <div className={styles.location}>
              <img src="../../assets/icons/location.png" />
              <Text isSmall={true} text="Osasco, São Paulo" />
            </div>
            <Text text="Designer" />
          </div>
          {isOtherView && (
            <div className={styles.actions}>
              <button>
                <img src="../../assets/icons/back.svg" />
              </button>
              <button>
                <img src="../../assets/icons/like.svg" />
              </button>
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
          <Text
            text="Curabitur tempus lacus in quam laoreet, eget finibus orci pharetra. Sed molestie leo eget urna egestas tristique ed molestie leo eget urna egestas tristique lacus in quam laoreet eget urna egestas tristique ed molestie leo eget urna egestas.
Curabitur tempus lacus in quam laoreet, eget finibus orci pharetra. Sed molestie leo eget urna egestas tristique. Sed molestie leo eget urna egestas tristique."
          />
          {canEdit && (
            <img
              onClick={() => setEditSocial(true)}
              className={styles.editSocial}
              src="../../assets/icons/editAbout.svg"
            />
          )}
          <List title="Redes sociais" list={SOCIAL_MEDIA} />

          <Title text="Email" />
          <div className={styles.socialMedia}>
            <Text isSmall={true} text={emailFormatted} />
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
              {isOtherView && (
                <>
                  <List title="Informações do projeto" list={INFO} />
                  <Text text="Curabitur tempus lacus in quam laoreet, eget finibus orci pharetra. Sed molestie leo eget urna egestas tristique ed molestie leo eget urna egestas tristique lacus in quam laoreet eget urna egestas tristique ed molestie leo eget." />
                </>
              )}
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
      {editSocial && (
        <EditSocialMedia
          actualState={editSocial}
          setActualState={setEditSocial}
        />
      )}
    </>
  );
};

export default About;
