import axios from "axios";

export function APILogin({ email, senha }) {
  axios
    .get("https://localhost/8080/login", {
      email: { email },
      senha: { senha },
    })
    .then((response) => displayOutput(response))
    .catch((err) => console.log(err));
}
export function APICadastro({ email, senha, nome, cellphone }) {
  axios
    .post("https://localhost/8080/cadastro", {
      email: { email },
      senha: { senha },
      nome: { nome },
      cellphone: { cellphone },
    })
    .then((response) => displayOutput(response))
    .catch((err) => console.log(err));
}
