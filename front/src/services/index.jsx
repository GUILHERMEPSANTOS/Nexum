import axios from "axios";

export function APILogin({ email, senha }) {

  axios
    .post("http://localhost:8080/api/v1/controle-acesso/sign-in", {
      email: email,
      senha: senha,
    })
    .then((response) => displayOutput(response))
    .catch((err) => console.log(err));
}

export function APICadastro({ email, senha, nome, celular }) {
  axios
    .post("http://localhost:8080/api/v1/controle-acesso/create-account/freelancer", {
      email: email,
      senha: senha,
      nome: nome,
      celular: celular,
    })
    .then((response) => displayOutput(response))
    .catch((err) => console.log(err));
}
