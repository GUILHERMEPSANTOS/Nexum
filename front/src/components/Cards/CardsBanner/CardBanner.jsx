import styles from './styles.module.scss'
import { DATA } from './Constants'
import CardInfo from './CardInfo/CardInfo'

const CardBanner = () => {
    return( 
        <div className={styles.container}>
        <div className={styles.card__animation}>
        {DATA.map(({id, name, location, profession}) => ( 
            <div className={styles.card}>
                <img src={`../../../../assets/imgs/person-card-${id}.png`} alt={name}/>
                <CardInfo 
                name={name} 
                location={location} 
                profession={profession}
                />
            </div>
        ))}
           </div>
           </div>
    )
}

export default CardBanner;