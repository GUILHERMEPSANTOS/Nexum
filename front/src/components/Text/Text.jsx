import styles from './styles.module.scss'

const Text = ({text, upperCase, small}) => {

    return( 
        <p className={upperCase ? styles.upperCase : small ? styles.text__small : styles.text}>
         {text}
        </p>
    )
}

export default Text;