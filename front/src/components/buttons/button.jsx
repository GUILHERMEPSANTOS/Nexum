import { Link } from "react-router-dom";
import styles from "./styles.module.scss";

const Button = ({ text, isEmpty, link, disabled, ...props }) => {
  const renderButton = () => {
    const className = [
      styles.buttonFillBackground,
      isEmpty ? styles.buttonEmptyBackground : "",
      props.className,
    ]
      .filter(Boolean)
      .join(" ");

    const disabledProp = disabled ? true : undefined;

    return (
      <button
        {...props}
        onClick={props.onClick}
        className={className}
        disabled={disabledProp}
      >
        {text}
      </button>
    );
  };

  return link ? <Link to={link}>{renderButton()}</Link> : renderButton();
};

export default Button;
