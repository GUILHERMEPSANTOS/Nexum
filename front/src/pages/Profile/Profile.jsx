import Company from "./company/company";
import Freelancer from "./freelancer/profile";
import ProfileContainer from "../profilePages/profile";
import { useState } from "react";
import { useEffect } from "react";

const Profile = () => {
  const [isCompanyProfile, setIsCompanyProfile] = useState(false);

  const perfil = localStorage.getItem("role");

  useEffect(() => {
    perfil == `"ROLE_FREELANCER"`
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
