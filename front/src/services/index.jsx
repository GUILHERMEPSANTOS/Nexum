export const APILogin = ({ email, senha }) => {
  const axios = require("axios");
  axios
    .get("https://localhost/8080/login", {
      email: { email },
      senha: { senha },
    })
    .then((response) => displayOutput(response))
    .catch((err) => console.log(err));
};
export const APICadastro = ({ email, senha, nome, cellphone }) => {
  const axios = require("axios");
  axios
    .post("https://localhost/8080/cadastro", {
      email: { email },
      senha: { senha },
      nome: { nome },
      cellphone: { cellphone },
    })
    .then((response) => displayOutput(response))
    .catch((err) => console.log(err));
};
