import Button from '../../Buttons/Button';
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
                /><div className={styles.buttons}>
                 <Text 
                upperCase={true} 
                text="crie agora mesmo a sua conta"
                />
                
                <Button 
                isPink={true} 
                text="Freelancer"/>
                <Button 
                isPink={false} 
                text="Contratante"/>
                </div>
            </div>
            <div className={styles.card}>
                <div className={styles.teste}>
           <CardInfo/>
           <CardInfo/>
           <CardInfo/>
           <CardInfo/>
           <CardInfo/>
           </div>
           </div>
        </Banner>
    )
}

export default BannerMain;