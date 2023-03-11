import axios from "axios";

export async function APILogin({ email, senha }) {
  return await axios.post(
    "http://localhost:8000/api/v1/controle-acesso/sign-in",
    {
      email: email,
      senha: senha,
    }
  );
}

export function APICadastroFreela({ email, senha, nome, celular }) {
  axios
    .post("http://localhost:8000/api/v1/freelancer/create-account", {
      email: email,
      senha: senha,
      nome: nome,
      celular: celular,
    })
    .then((response) => displayOutput(response))
    .catch((err) => console.log(err));
}
export function APICadastroContratante({ email, senha, nome, celular }) {
  axios
    .post(
      "ec2-44-212-184-96.compute-1.amazonaws.com:8000/api/v1/contratante/create-account/",
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
