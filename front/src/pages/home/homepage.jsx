import Footer from "../../components/footer/footer";
import Header from "../../components/header/header";
import AboutMain from "../../components/about/about";
import BannerMain from "../../components/banner/bannerMain/bannerMain";
import BannerRanking from "../../components/banner/bannerRanking/bannerRanking";
import Info from "../../components/info/Info";
import UserMain from "../../components/typeUser/typeUser";
import { OPTIONS } from "./constants";

const HomePage = () => {
  document.title = "Nexum";
  return (
    <>
      <Header
        options={OPTIONS}
        buttonTextLogin={true}
        buttonText="Criar conta"
        link="/cadastro"
      />
      <BannerMain />
      <Info />
      <BannerRanking />
      <AboutMain />
      <UserMain />
      <Footer />
    </>
  );
};

export default HomePage;
