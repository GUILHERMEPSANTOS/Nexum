import Button from '../../Buttons/Button';
import Text from '../../Text/Text';
import Title from '../../Title/Title';
import Banner from '../Banner'
import styles from './styles.module.scss'

const BannerRanking = () => {
    return(
        <Banner main={false}>
            <section className={styles.container}>
            <Title text="Alguns dos Freelancers mais bem avaliados"/>
            <Text text="Entre agora mesmo e encontre o Profissional perfeito para o seu projeto"/>
            <Button text="Entrar"/>
            </section>
        </Banner>
    )
}

export default BannerRanking;