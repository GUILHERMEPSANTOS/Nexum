import { useEffect, useState } from "react";

const useLogin = ({ email, password }) => {
  const [errorEmail, setErrorEmail] = useState("");
  const [errorPassword, setErrorPassword] = useState("");
  const [disabled, setDisbaled] = useState(false)

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

  useEffect(() => {
    email != undefined &&
    password != undefined &&
    errorPassword == "" &&
    errorEmail == "" 
      ? setDisbaled(false)
      : setDisbaled(true);
  }, [
    errorEmail,
    errorPassword,
  ]);



  return {
    errorEmail,
    errorPassword,
    verifyEmail,
    verifyPassword,
    disabled,
  };
};
export default useLogin;
