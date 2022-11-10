import About from "../../../components/Profile/About/Profile";
import styles from "./styles.module.scss";

const Company = ({ isCompany }) => {
  return <About isCompanyProfile={isCompany} />;
};

export default Company;
