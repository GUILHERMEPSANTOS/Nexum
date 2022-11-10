import { OPTIONS } from "./constants";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";

const ProfileContainer = ({ children }) => (
  <>
    <Header options={OPTIONS} buttonText="Sair" link="/" />
    {children}
    <Footer />
  </>
);
export default ProfileContainer;
