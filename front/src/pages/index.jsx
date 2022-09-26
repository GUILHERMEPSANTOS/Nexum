import Header from "../components/Header/Header";
import AboutMain from "../components/About/About";
import BannerMain from "../components/Banner/BannerMain/BannerMain";
import Info from "../components/Info/Info";

function HomePage() {
  return (
    <>
      <Header />
      <BannerMain />
      <Info />
      <AboutMain />
    </>
  );
}

export default HomePage;
