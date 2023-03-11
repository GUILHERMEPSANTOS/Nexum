import About from "../../../components/profile/about/about";
import styles from "./styles.module.scss";

const Company = ({
  isCompanyProfile,
  nomeCompany,
  emailCompany,
  enderecoCompany,
  sobreCompany,
  socialCompany,
  idCompany,
  isOtherView,
  canEdit,
}) => {
  return (
    <About
      idCompany={idCompany}
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
