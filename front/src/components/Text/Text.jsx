import { useState } from 'react';
import styles from './styles.module.scss'

const Text = ({text, upperCase}) => {

    const [words, setWords] = useState(text);
    const [color, setColor] = useState('#fff');


    return( 
        <p className={upperCase ? styles.upperCase : styles.text}>
         {text}
        </p>
    )
}

export default Text;