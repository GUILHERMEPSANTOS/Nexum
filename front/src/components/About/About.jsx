import Title from "../Title/Title";
import Text from "../Text/Text";
import Banner from "../Banner/Banner";
import Button from "../Buttons/Button";
import styles from "./styles.modules.scss";

const AboutMain = () => {
  return (
    <Banner>
      <div className="style">
        <div id="image" className="describe">
          <img id="image" src="../../../assets/imgs/logo.png" alt="Logo" />
        </div>
        <hr className="hr" />
        <div id="about" className="describe">
          <Title text="Sobre a Nexum" />
          <Text text="A Nexum nasce com o propósito de facilitar a vida do freelancer assim como do empregador de forma onde o empregador é quem buscar o freelancer e não o contrário, isso possibilita que o empregador só entre em contato com o colaborador se de fato houver o interesse por seus trabalhos" />

          <div className="teste">
            <Button text="Descubra mais sobre nós" />
          </div>
        </div>
      </div>
    </Banner>
  );
};

export default AboutMain;
