import Title from "src/components/Title/Title";
import Form from "../Form";
import styles from "./styles.module.scss"

const Login = () => {
  return (
    <Form>
      <Title text="Seja bem vindo"/>
      <Text text="Preecha os campos para continuar"/>
      <label>Usuário</label>
      <input/>
      <label>Senha</label>
      <input/>
      <div>
        <input/> <label>Lembrar conta</label>
        <label>Esqueci a senha</label>
      </div>
    </Form>
  );
};

export default Form;