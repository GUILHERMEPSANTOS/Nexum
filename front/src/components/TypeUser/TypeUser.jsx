import Title from "../Title/Title";
import Text from "../Text/Text";
import Banner from "../Banner/Banner";
import Button from "../Buttons/Button";
import styles from "./styles.module.scss";

const UserMain = () => {
    return (

        <Banner>

            <div className={styles.container}>
                <div className={styles.saiba_mais}>
                    <Text
                        text="CRIE AGORA MESMO A SUA CONTA"
                    />
                    <Title
                        text="Encontre o melhor da Nexum"
                    />
                    <Text
                        text="Conecte-se a pessoas que buscam crescer no mercado e freelancers que desejam ser vistos pelas suas habilidades"
                    />
                    
                </div>
                <div className={styles.box_conta}>
                    <Text
                        text="Frellancer"
                    />
                    <Text
                        text="Para você que deseja encontrar o trabalho perfeito "
                    />
                    <div className={styles.buttons}>
                        <Button
                            text="Conta Freelancer"
                        />
                    </div>
                </div>
                <div className={styles.box_conta}>
                    <Text
                        text="Contratante"
                    />
                    <Text
                        text="Para você que busca encontrar os melhores pofissionais"
                    />
                    <div className={styles.buttons}>
                        <Button
                            text="Conta Contratante" isEmpty={true}
                        />
                    </div>
                </div>
            </div>
        </Banner>

    )
}

export default UserMain;