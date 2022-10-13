
import FooterMain from "../components/Footer/Footer";
import Header from "../components/Header/Header";
import AboutMain from "../components/About/About";
import BannerMain from "../components/Banner/BannerMain/BannerMain";
import BannerRanking from "../components/Banner/BannerRanking/BannerRanking";
import Info from "../components/Info/Info";
import UserMain from "../components/TypeUser/TypeUser";


function HomePage() {
  document.title="Nexum"
  return (
    <>
      <Header />
      <BannerMain />
      <Info />
      <BannerRanking />
      <AboutMain />
      <UserMain />   
      <FooterMain />
    </>
  );
}

export default HomePage;
