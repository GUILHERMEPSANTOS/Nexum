import { OPTIONS } from "./constants";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
import Company from "../../components/Profile/Pages/Company/Company";
import Freelancer from "../../components/Profile/Pages/Freelancer/Profile";
import FavoritosMain from "../../components/TelaFavoritos/Favoritos"

const Profile = ({ isCompanyProfile = false }) => (
  <>
    <Header options={OPTIONS} buttonText="Sair" link="/" />
    {/* {isCompanyProfile ? <Company /> : <Freelancer />} */}
    <FavoritosMain />
    <Footer />
  </>
);
export default Profile;
