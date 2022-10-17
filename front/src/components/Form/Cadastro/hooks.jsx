import { useEffect, useState } from "react";

const useCadastro = ({ email, password, user, cellphone, confirmPassword }) => {
  const [errorEmail, setErrorEmail] = useState("");
  const [errorPassword, setErrorPassword] = useState("");
  const [errorUser, setErrorUser] = useState("");
  const [errorCellphone, setErrorCellphone] = useState("");
  const [errorConfirmPassword, setErrorConfirmPassword] = useState("");
  const [disabled, setDisbaled] = useState(true);

  const verifyUser = () => {
    !!!user ? setErrorUser("Preencher usuario") : setErrorUser("");
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
    const validCellphone = new RegExp('([0-9]{2,3})?(\([0-9]{2}\))([0-9]{4,5})([0-9]{4})')
    if (!!!cellphone) {
      setErrorCellphone("Preencher celular");
    } else if(!validCellphone.test(cellphone)) {
      setErrorCellphone("Preencha um celular válido");
    }else {
      setErrorCellphone("");
    }
  };

  useEffect(() => {
    user != undefined &&
    email != undefined &&
    cellphone != undefined &&
    confirmPassword != undefined &&
    password != undefined &&
    errorCellphone == "" &&
    errorUser == "" &&
    errorPassword == "" &&
    errorEmail == "" &&
    errorConfirmPassword == ""
      ? setDisbaled(false)
      : setDisbaled(true);
  }, [
    errorEmail,
    errorPassword,
    errorUser,
    errorCellphone,
    errorConfirmPassword,
  ]);

  return {
    errorEmail,
    errorPassword,
    errorUser,
    errorCellphone,
    errorConfirmPassword,
    verifyUser,
    verifyEmail,
    verifyPassword,
    verifyCellphone,
    verifyConfirmPassword,
    disabled,
  };
};
export default useCadastro;
