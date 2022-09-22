import AboutMain from "../components/About/About";
import BannerMain from "../components/Banner/BannerMain/BannerMain";
import BannerRanking from "../components/Banner/BannerRanking/BannerRanking";
import Info from "../components/Info/Info";

function HomePage() {
  return (
    <>
      <BannerMain />
      <Info />
      <BannerRanking />
      <AboutMain />
    </>
  );
}

export default HomePage;
