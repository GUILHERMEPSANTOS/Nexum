import axios from "axios";
import { Navigate } from "react-router-dom";
import { api } from "./api";

export function APILogin({ email, senha }) {
  axios
    .post("http://localhost:8080/api/v1/controle-acesso/sign-in", {
      email: email,
      senha: senha,
    })
    .then((res) =>
      res == 200
        ? Navigate("/inicio")
        : window.alert("Tem algo errado ai irmão")
    )
    .catch((err) => console.log(err));
}

export function APICadastro({ email, senha, nome, celular }) {
  axios
    .post(
      "http://localhost:8080/api/v1/controle-acesso/create-account/freelancer",
      {
        email: email,
        senha: senha,
        nome: nome,
        celular: celular,
      }
    )
    .then((response) => displayOutput(response))
    .catch((err) => console.log(err));
}

export function APIPerfil({ email, senha, nome, celular }) {
  axios
    .get(
      "http://localhost:8080/api/v1/controle-acesso/create-account/freelancer",
      {
        email: email,
        senha: senha,
        nome: nome,
        celular: celular,
      }
    )
    .then((response) => displayOutput(response))
    .catch((err) => console.log(err));
}
