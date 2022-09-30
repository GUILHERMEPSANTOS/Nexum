import Button from "../../Buttons/Button";
import SecondSection from "./SecondSection";
import Text from "../../Text/Text";
import Title from "../../Title/Title";
import Banner from "../Banner";
import styles from "./styles.module.scss";
import { useEffect } from "react";

const SecontSection = () => {
    var slideIndex = 0;
    showSlides();
    
    function showSlides() {
      var i;
      var slides = document.getElementsByClassName("mySlides");
      var dots = document.getElementsByClassName("dot");
      for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";  
      }
      slideIndex++;
      if (slideIndex > slides.length) {slideIndex = 1}    
      for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
      }
      slides[slideIndex-1].style.display = "block";  
      setTimeout(showSlides, 8000);
    }    

    useEffect(() => {
      showSlides()
    },[showSlides])

  return (
    <Banner main={true}>
        <div className={styles.container}>
            <div className="mySlides fade">
                <div className="banner"></div>
                <div className="banner"></div>
                <div className="banner"></div>
            </div>
        </div>
      <CardBanner />
    </Banner>
  );
};

export default BannerMain;
