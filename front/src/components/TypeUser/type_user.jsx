import Title from "../Title/Title";
import Text from "../Text/Text";
import Banner from "../Banner/Banner";
import Button from "../Buttons/Button";
import styles from "./styles.module.scss";

const UserMain = () => {
    return (

        <Banner>

            <div className="conatainer">
                <div className="saiba_mais">
                    <Text
                        text="CRIE AGORA MESMO A SUA CONTA"
                    />
                    <Title
                        Text="Encontre o melhor da Nexum"
                    />
                    <Text
                        text="Conecte-se a pessoas que buscam crescer no mercado e freelancers que desejam ser vistos pelas suas habilidades"
                    />
                    <Button
                        text="Saiba mais"
                    />
                </div>
                <div className="box_conta">
                    <Text
                        text="Frellancer"
                    />
                    <Text
                        text="Para você que deseja encontrar o trabalho perfeito "
                    />
                    <Button
                        text="Conta Freelancer"
                    />
                </div>
                <div className="box_conta">
                    <Text
                        text="Contratante"
                    />
                    <Text
                        text="Para você que busca encontrar os melhores pofissionais"
                    />
                    <Button
                        text="Conta Contratante"
                    />
                </div>

            </div>


        </Banner>

    )
}

export default UserMain;