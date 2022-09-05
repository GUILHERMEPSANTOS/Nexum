import Button from '../../Buttons/Button';
import CardBanner from '../../Cards/CardsBanner/CardBanner';
import CardInfo from '../../Cards/CardsBanner/CardInfo/CardInfo';
import Text from '../../Text/Text';
import Title from '../../Title/Title';
import Banner from '../Banner'
import styles from './styles.module.scss'
// import Cards from '../Cards/CardsBanner/Cards';
// import CardInfo from '../Cards/CardsBanner/CardInfo/CardInfo';

const BannerMain = () => {
    return(
        <Banner main={true}>
            <div className={styles.container}>
                <Title 
                text="Nexum criado para você encontrar a conexão perfeita"/>
                <Text 
                upperCase={false} 
                text="A Nexum conecta pessoas que buscam crescer no mercado e freelancers que desejam ser vistos pelas suas habilidades"
                /><div>
                 <Text 
                upperCase={true} 
                text="crie agora mesmo a sua conta"
                />
                <div className={styles.buttons}>
                <Button 
                text="Freelancer"/>
                <Button 
                isEmpty={true} 
                text="Contratante"/>
                </div>
                </div>
            </div>
        <CardBanner/>
        </Banner>
    )
}

export default BannerMain;