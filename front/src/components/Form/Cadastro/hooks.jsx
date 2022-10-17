import { useState } from "react";

const useCadastro = ({ email, password, user, cellphone }) => {
  const [errorEmail, setErrorEmail] = useState("");
  const [errorPassword, setErrorPassword] = useState("");
  const [errorUser, setErrorUser] = useState("teste");
  const [errorCellphone, setErrorCellphone] = useState("");
  console.log(user);
  console.log(errorUser);
  const verifyUser = () => {
    console.log(user);
    if (user == "oi") {
      console.log(user);
      setErrorUser("Preencher usuario");
    }
  };

  console.log(errorUser);
  return errorEmail, errorPassword, errorUser, errorCellphone, verifyUser;
};
export default useCadastro;
