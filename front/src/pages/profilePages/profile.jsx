import { OPTIONS } from "./constants";
import Header from "../../components/header/header";
import Footer from "../../components/footer/footer";

const ProfileContainer = ({ children }) => (
  <>
    <Header options={OPTIONS} buttonText="Sair" link="/" />
    {children}
    <Footer />
  </>
);
export default ProfileContainer;
