import { OPTIONS } from "./constants";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import Company from "../../components/Profile/Pages/Company/Company";
import Freelancer from "../../components/Profile/Pages/Freelancer/Profile";

const Profile = ({ isCompanyProfile }) => (
  <>
    <Header options={OPTIONS} buttonText="Sair" link="/" />
    {isCompanyProfile ? <Company isCompany={isCompanyProfile}/> : <Freelancer />}
    <Footer />
  </>
);
export default Profile;
