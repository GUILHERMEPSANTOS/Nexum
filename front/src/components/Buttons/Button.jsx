
import styles from './styles.module.scss'

const Button = ({text, isPink}) => {

    return( 
        <button className={isPink ? styles.buttonFillBackground : styles.buttonEmptyBackground}>
            {text}
        </button>
    )
}

export default Button;