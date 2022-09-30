
import FooterMain from "../components/Footer/Footer";
import Header from "../components/Header/Header";
import AboutMain from "../components/About/About";
import BannerMain from "../components/Banner/BannerMain/BannerMain";
import BannerRanking from "../components/Banner/BannerRanking/BannerRanking";
import Info from "../components/Info/Info";

function HomePage() {
  return (
    <>
      <Header />
      <BannerMain />
      <SecondSection />
      <Info />
      <BannerRanking />
      <AboutMain />
      <FooterMain />
    </>
  );
}

export default HomePage;
