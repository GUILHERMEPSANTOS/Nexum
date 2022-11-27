import About from "../../../components/Profile/About/About";
import styles from "./styles.module.scss";

const Company = ({
  isCompanyProfile,
  nomeCompany,
  emailCompany,
  enderecoCompany,
  sobreCompany,
  socialCompany,
  isOtherView,
  canEdit,
}) => {
  return (
    <About
      nomeCompany={nomeCompany}
      emailCompany={emailCompany}
      enderecoCompany={enderecoCompany}
      sobreCompany={sobreCompany}
      socialCompany={socialCompany}
      canEdit={canEdit}
      isCompanyProfile={isCompanyProfile}
      isOtherView={isOtherView}
    />
  );
};

export default Company;
