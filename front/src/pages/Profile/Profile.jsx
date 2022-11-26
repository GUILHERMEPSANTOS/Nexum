import Company from "./Company/Company";
import Freelancer from "./Freelancer/Profile";
import ProfileContainer from "../ProfilePages/profile";
import { useState } from "react";
import { useEffect } from "react";

const Profile = () => {
  const [isCompanyProfile, setIsCompanyProfile] = useState(false);

  const perfil = localStorage.getItem("role");
  console.log(perfil);
  useEffect(() => {
    perfil == "ROLE_FREELANCER"
      ? setIsCompanyProfile(false)
      : setIsCompanyProfile(true);
  }, [perfil]);
  return (
    <ProfileContainer>
      {isCompanyProfile ? (
        <Company isCompany={isCompanyProfile} />
      ) : (
        <Freelancer />
      )}
    </ProfileContainer>
  );
};
export default Profile;
