import { api } from "./api";

export async function APILogin({ email, senha }) {
  return await api.post("/api/v1/controle-acesso/sign-in", {
    email: email,
    senha: senha,
  });
}

export function APICadastroFreela({ email, senha, nome, celular }) {
  api
    .post("/api/v1/freelancer/create-account", {
      email: email,
      senha: senha,
      nome: nome,
      celular: celular,
    })
    .then((response) => displayOutput(response))
    .catch((err) => console.log(err));
}
export function APICadastroContratante({ email, senha, nome, celular }) {
  api
    .post("/api/v1/contratante/create-account/", {
      email: email,
      senha: senha,
      nome: nome,
      celular: celular,
    })
    .then((response) => displayOutput(response))
    .catch((err) => console.log(err));
}
