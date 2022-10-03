import Banner from "../Banner";
import styles from "./styles.module.scss";
import { Component, useEffect } from "react";
import React  from "react";
import Slider from 'react-slick'

export default class SecondSection extends Component(){
  render() {
    const settings = {
      dots: true,
      infinite: true,
      speed: 500,
      slidesToShow: 1,
      slidesToScroll: 1
    }
  
    return{
      <div style={{ marginTop: 100}}>
        <Slider {...settings}>
          {[1, 2, 3].map(item, index) => {
            return (
              <div key={index}>{item}
                <h1 style={{ color: "red", fontSize: 100, textAlign: "center"}}>

                </h1>
              </div>
            )
          }}
        </Slider>
      </div>
    }
  }
}    

export default BannerMain;
