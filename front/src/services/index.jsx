import axios from "axios";

export function APILogin({ email, senha }) {

  console.log(email, senha);
  axios
    .post("http://localhost:8080/api/v1/controle-acesso/sign-in", {
      email: email,
      senha: senha,
    })
    .then((response) => displayOutput(response))
    .catch((err) => console.log(err));
}

export function APICadastro({ email, senha, nome, cpf }) {
  axios
    .post("https://localhost:8080/api/v1/controle-acesso/cadastro", {
      email: email,
      senha: senha,
      nome: nome,
      cpf: cpf,
    })
    .then((response) => displayOutput(response))
    .catch((err) => console.log(err));
}
