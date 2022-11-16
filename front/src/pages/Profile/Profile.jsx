import Company from "./Company/Company";
import Freelancer from "./Freelancer/Profile";
import ProfileContainer from "../ProfilePages/profile";

const Profile = ({ isCompanyProfile }) => (
  <ProfileContainer>
    {isCompanyProfile ? (
      <Company isCompany={isCompanyProfile} />
    ) : (
      <Freelancer />
    )}
  </ProfileContainer>
);
export default Profile;
