import About from "../../../components/Profile/About/About";
import styles from "./styles.module.scss";

const Company = ({ isCompany, isFreela, canEdit }) => {
  return (
    <About
      canEdit={canEdit}
      isOtherView={isFreela}
      isCompanyProfile={isCompany}
    />
  );
};

export default Company;
