import { useEffect, useState } from "react";

const useCadastro = ({ email, password, user, cellphone, confirmPassword, profession }) => {
  const [errorEmail, setErrorEmail] = useState("");
  const [errorPassword, setErrorPassword] = useState("");
  const [errorUser, setErrorUser] = useState("");
  const [errorCellphone, setErrorCellphone] = useState("");
  const [errorProfession, setErrorProfession] = useState("");
  const [errorConfirmPassword, setErrorConfirmPassword] = useState("");
  const [disabled, setDisbaled] = useState(true);

  const verifyUser = () => {
    !!!user ? setErrorUser("Preencher usuario") : setErrorUser("");
  };
  const verifyProfession = () => {
    !!!profession ? setErrorProfession("Preencher usuario") : setErrorProfession("");
  };
  const verifyEmail = () => {
    const validEmail = new RegExp(
      "^[a-zA-Z0-9._:$!%-]+@[a-zA-Z0-9.-]+.[a-zA-Z]$"
    );
    if (!!!email) {
      setErrorEmail("Preencher o email");
    } else if (!validEmail.test(email)) {
      setErrorEmail("Preencher um email valido");
    } else {
      setErrorEmail("");
    }
  };
  const verifyPassword = () => {
    if (!!!password) {
      setErrorPassword("Preencher senha");
    } else {
      setErrorPassword("");
    }
  };
  const verifyConfirmPassword = () => {
    if (!!!confirmPassword) {
      setErrorConfirmPassword("Preencher confirmação de senha");
    } else if (confirmPassword != password) {
      setErrorConfirmPassword("Senhas não conferem");
    } else {
      setErrorConfirmPassword("");
    }
  };

  const verifyCellphone = () => {
    if (!!!cellphone) {
      setErrorCellphone("Preencher celular");
    } else {
      setErrorCellphone("");
    }
  };

  useEffect(() => {

    user != undefined &&
    profession != undefined &&
    email != undefined &&
    cellphone != undefined &&
    confirmPassword != undefined &&
    password != undefined &&
    errorCellphone == "" &&
    errorUser == "" &&
    errorProfession == "" &&
    errorPassword == "" &&
    errorEmail == "" &&
    errorConfirmPassword == ""
      ? setDisbaled(false)
      : setDisbaled(true);
  }, [
    errorEmail,
    errorProfession,
    errorPassword,
    errorUser,
    errorCellphone,
    errorConfirmPassword,
    email, cellphone, confirmPassword, 
    confirmPassword,
    password,
    profession,
    
  ]);



  return {
    errorEmail,
    errorProfession,
    errorPassword,
    errorUser,
    errorCellphone,
    errorConfirmPassword,
    verifyUser,
    verifyProfession,
    verifyEmail,
    verifyPassword,
    verifyCellphone,
    verifyConfirmPassword,
    disabled,
  };
};
export default useCadastro;
