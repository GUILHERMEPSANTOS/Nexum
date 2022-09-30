import Banner from "../Banner/Banner";
import Title from "../Title/Title";

const Form = ({ children }) => {
  return (
    <Banner form={true}>
      <section>
        <Title text="Testeeeeeeeeeeeee" />
      </section>
      <section>{children}</section>
    </Banner>
  );
};

export default Form;
