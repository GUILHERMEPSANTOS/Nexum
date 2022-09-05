
import styles from './styles.module.scss'

const Button = ({text, isEmpty}) => {

    return( 
        <button className={isEmpty ? styles.buttonEmptyBackground : styles.buttonFillBackground}>
            {text}
        </button>
    )
}

export default Button;