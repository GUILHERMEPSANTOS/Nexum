import About from "../../../components/Profile/About/About";
import styles from "./styles.module.scss";

const Company = ({ isCompany, isFreela }) => {
  return <About isOtherView={isFreela} isCompanyProfile={isCompany} />;
};

export default Company;
