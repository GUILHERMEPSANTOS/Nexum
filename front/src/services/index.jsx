import axios from "axios";
import React, { useCallback } from "react";
import { useNavigate } from "react-router-dom";

export async function APILogin({ email, senha }) {
  return await axios.post(
    "http://localhost:8080/api/v1/controle-acesso/sign-in",
    {
      email: email,
      senha: senha,
    }
  );
}

export function APICadastroFreela({ email, senha, nome, celular }) {
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
export function APICadastroContratante({ email, senha, nome, celular }) {
  axios
    .post("http://localhost:8080/api/v1/contratante/create-account/", {
      email: email,
      senha: senha,
      nome: nome,
      celular: celular,
    })
    .then((response) => displayOutput(response))
    .catch((err) => console.log(err));
}
