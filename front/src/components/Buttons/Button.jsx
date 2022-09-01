import styles from './styles.module.scss'
import ITEMS from './Constants'

const Button = ({name}) => {
    return( 
        <button>
            {name}
        </button>
    )
}

export default Button;